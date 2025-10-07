package com.organization.LibraryApp.loan.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.organization.LibraryApp.book.model.Book;
import com.organization.LibraryApp.user.model.Member;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "loans")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDate loanDate;
    private LocalDate returnDate;

    private boolean returned = false;
    private double feeCharged = 0.0;


}
