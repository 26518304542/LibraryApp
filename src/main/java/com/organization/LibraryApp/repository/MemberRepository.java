package com.organization.LibraryApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.LibraryApp.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
