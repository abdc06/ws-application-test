package me.abdc.mockitogettingstarted.study;

import me.abdc.mockitogettingstarted.domain.Member;
import me.abdc.mockitogettingstarted.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    void createStudyService(@Mock MemberService memberService2, @Mock StudyRepository studyRepository2) {
        MemberService memberService3 = Mockito.mock(MemberService.class);
        StudyRepository studyRepository3 = Mockito.mock(StudyRepository.class);

        StudyService studyService = new StudyService(memberService, studyRepository);
        StudyService studyService2 = new StudyService(memberService2, studyRepository2);
        StudyService studyService3 = new StudyService(memberService3, studyRepository3);

        assertNotNull(studyService);
        assertNotNull(studyService2);
        assertNotNull(studyService3);
    }

}