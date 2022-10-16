package me.abdc.mockitogettingstarted.member;

import me.abdc.mockitogettingstarted.domain.Member;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);
}
