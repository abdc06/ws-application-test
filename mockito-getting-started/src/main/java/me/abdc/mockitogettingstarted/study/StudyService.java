package me.abdc.mockitogettingstarted.study;

import me.abdc.mockitogettingstarted.member.MemberService;

public class StudyService {

    final MemberService memberService;

    final StudyRepository studyRepository;

    public StudyService(MemberService memberService, StudyRepository studyRepository) {
        assert memberService != null;
        assert studyRepository != null;
        this.memberService = memberService;
        this.studyRepository = studyRepository;
    }
}
