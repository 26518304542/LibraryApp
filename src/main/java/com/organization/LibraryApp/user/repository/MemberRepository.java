package com.organization.LibraryApp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.LibraryApp.user.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
