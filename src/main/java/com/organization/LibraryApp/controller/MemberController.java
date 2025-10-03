package com.organization.LibraryApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organization.LibraryApp.model.Member;
import com.organization.LibraryApp.repository.MemberRepository;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "*")
public class MemberController {
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostMapping
    public ResponseEntity<Member> add(@RequestBody Member member) {
        return ResponseEntity.ok(memberRepository.save(member));
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAll() {
        return ResponseEntity.ok(memberRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> get(@RequestParam Long id) {
        return ResponseEntity.ok(memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found")));
    }




}
