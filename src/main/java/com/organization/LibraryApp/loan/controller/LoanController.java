package com.organization.LibraryApp.loan.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organization.LibraryApp.dto.LoanDto;
import com.organization.LibraryApp.loan.model.Loan;
import com.organization.LibraryApp.loan.service.LoanService;

@RestController
@RequestMapping("/api/loans")
@CrossOrigin(origins = "*")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<LoanDto>> memberLoans(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.ok(
                loanService.getMemberLoans(memberId).stream().map(LoanDto::fromEntity).toList());
    }

    @PostMapping("/borrow")
    public ResponseEntity<LoanDto> borrow(@RequestParam("memberId") Long memberId,
            @RequestParam("bookId") Long bookId) {
        return ResponseEntity.ok(LoanDto.fromEntity(loanService.borrowBook(memberId, bookId)));
    }

    @PostMapping("/return")
    public ResponseEntity<LoanDto> returnBook(@RequestParam("loanId") Long loanId) {
        return ResponseEntity.ok(LoanDto.fromEntity(loanService.returnBook(loanId)));
    }
}
