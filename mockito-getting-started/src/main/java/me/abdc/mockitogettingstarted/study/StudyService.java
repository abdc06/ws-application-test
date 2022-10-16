package me.abdc.mockitogettingstarted.study;

import me.abdc.mockitogettingstarted.domain.Member;
import me.abdc.mockitogettingstarted.domain.Study;
import me.abdc.mockitogettingstarted.member.MemberService;

import java.util.Optional;

public class StudyService {

    final MemberService memberService;

    final StudyRepository studyRepository;

    public StudyService(MemberService memberService, StudyRepository studyRepository) {
        assert memberService != null;
        assert studyRepository != null;
        this.memberService = memberService;
        this.studyRepository = studyRepository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Optional<Member> member = memberService.findById(memberId);
        study.setOwner(member.orElseThrow(IllegalArgumentException::new));
        return studyRepository.save(study);
    }
}
