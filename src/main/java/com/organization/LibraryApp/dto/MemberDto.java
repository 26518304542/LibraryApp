package com.organization.LibraryApp.dto;

import com.organization.LibraryApp.user.model.Member;

public record MemberDto(Long id, String name, String email) {
    public static MemberDto fromEntity(Member member){
        return new MemberDto(
            member.getId(),
            member.getName(),
            member.getEmail());
    }
}
