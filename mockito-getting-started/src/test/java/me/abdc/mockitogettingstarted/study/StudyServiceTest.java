package me.abdc.mockitogettingstarted.study;

import me.abdc.mockitogettingstarted.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Mock
    MemberService memberService1;

    @Mock
    StudyRepository studyRepository1;

    @Test
    void createStudyService(@Mock MemberService memberService2, @Mock StudyRepository studyRepository2) {
        MemberService memberService3 = Mockito.mock(MemberService.class);
        StudyRepository studyRepository3 = Mockito.mock(StudyRepository.class);

        StudyService studyService1 = new StudyService(memberService1, studyRepository1);
        StudyService studyService2 = new StudyService(memberService2, studyRepository2);
        StudyService studyService3 = new StudyService(memberService3, studyRepository3);

        assertNotNull(studyService1);
        assertNotNull(studyService2);
        assertNotNull(studyService3);
    }

}