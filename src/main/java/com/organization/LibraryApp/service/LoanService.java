package com.organization.LibraryApp.service;

import com.organization.LibraryApp.model.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.LibraryApp.model.Book;
import com.organization.LibraryApp.model.Invoice;
import com.organization.LibraryApp.model.Loan;
import com.organization.LibraryApp.repository.BookRepository;
import com.organization.LibraryApp.repository.InvoiceRepository;
import com.organization.LibraryApp.repository.LoanRepository;
import com.organization.LibraryApp.repository.MemberRepository;

@Service
public class LoanService {
    private final LoanRepository loanRepo;
    private final BookRepository bookRepo;
    private final MemberRepository memberRepo;
    private final InvoiceRepository invoiceRepo;

    public LoanService(LoanRepository loanRepo, BookRepository bookRepo, MemberRepository memberRepo,
            InvoiceRepository invoiceRepo) {
        this.loanRepo = loanRepo;
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
        this.invoiceRepo = invoiceRepo;
    }

    public Loan BorrowBook(Long memberId, Long bookId) {
        Member member = memberRepo.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

        List<Loan> activeLoans = loanRepo.findByMember_IdAndReturnedFalse(memberId);
        if(activeLoans.size() >= 5)
            throw new RuntimeException("User has reached the maximum limit of 5 books!");

        if(!book.isAvailable())
            throw new RuntimeException("Book is not available for borrowing");

        Loan loan = Loan.builder()
                .book(book)
                .member(member)
                .loanDate(LocalDate.now())
                .returned(false)
                .feeCharged(book.getPrice())
                .build();

        book.setAvailable(false);
        bookRepo.save(book);
        Loan savedLoan = loanRepo.save(loan);

        Invoice invoice = Invoice.builder()
                .memberId(member.getId())
                .amount(book.getPrice())
                .description("Borrowed : " + book.getTitle())
                .createdAt(LocalDateTime.now())
                .build();
        invoiceRepo.save(invoice);

        return savedLoan;
    }

    public Loan returnBook(Long loanId){
        Loan loan = loanRepo.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));

        if(loan.isReturned()){
            throw new RuntimeException("Book has already been returned");
        }

        loan.setReturned(true);
        loan.setReturnDate(LocalDate.now());

        Book b = loan.getBook();
        b.setAvailable(true);
        bookRepo.save(b);

        Invoice refund = Invoice.builder()
                .memberId(loan.getMember().getId())
                .amount(-loan.getFeeCharged())
                .description("Returned : " + b.getTitle())
                .createdAt(LocalDateTime.now())
                .build();
        invoiceRepo.save(refund);

        return loanRepo.save(loan);
    }

    public List<Loan> getMemberLoans(Long memberId){
        return loanRepo.findByMember_IdAndReturnedFalse(memberId);
    };

    //Controllerlar ile devam edilecek
}
