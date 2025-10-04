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

import com.organization.LibraryApp.dto.MemberDto;
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
    public ResponseEntity<MemberDto> add(@RequestBody Member member) {
        return ResponseEntity.ok(MemberDto.fromEntity(memberRepository.save(member)));
    }

    @GetMapping
    public ResponseEntity<List<MemberDto>> getAll() {
        return ResponseEntity.ok(memberRepository.findAll().stream().map(MemberDto::fromEntity).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> get(@RequestParam("id") Long id) {
        return ResponseEntity.ok(MemberDto.fromEntity(memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"))));
    }




}
