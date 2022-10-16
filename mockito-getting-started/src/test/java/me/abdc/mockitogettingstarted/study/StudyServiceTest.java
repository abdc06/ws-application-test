package me.abdc.mockitogettingstarted.study;

import me.abdc.mockitogettingstarted.domain.Member;
import me.abdc.mockitogettingstarted.domain.Study;
import me.abdc.mockitogettingstarted.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

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

    @Test
    void stubbing() {
        Optional<Member> member = memberService.findById(1L);
        assertTrue(member.isEmpty());
        assertFalse(member.isPresent());

        Member mockMember = new Member();
        mockMember.setId(1L);
        mockMember.setEmail("abdc2806@email.com");

        when(memberService.findById(any())).thenReturn(Optional.of(mockMember));

                Optional<Member> member2 = memberService.findById(1L);
        assertFalse(member2.isEmpty());
        assertEquals("abdc2806@email.com", member2.get().getEmail());

        doThrow(new IllegalArgumentException()).when(memberService).validate(1L);

        assertThrows(IllegalArgumentException.class, () -> {
            memberService.validate(1L);
        });

        memberService.validate(2L);
    }

    /**
     * TODO memberService 객체에 findById 메소드를 1L 값으로 호출하면 Optional.of(member) 객체를 리턴하도록 Stubbing
     * TODO studyRepository 객체에 save 메소드를 study 객체로 호출하면 study 객체 그대로 리턴하도록 Stubbing
     */
    @Test
    void stubbingProblem() {
        StudyService studyService = new StudyService(memberService, studyRepository);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("abdc2806@email.com");

        Study mockStudy = new Study();
        mockStudy.setLimitCount(10);
        mockStudy.setName("테스트");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(mockStudy)).thenReturn(mockStudy);

        Study study = studyService.createNewStudy(1L, mockStudy);

        assertNotNull(study.getOwner());
        assertEquals(member, study.getOwner());
    }

    @Test
    void verification() {
        verifyNoInteractions(memberService);

        memberService.validate(1L);
        memberService.validate(1L);
        memberService.validate(2L);

        verify(memberService, times(2)).validate(1L);
        verify(memberService, times(1)).validate(2L);
        verify(memberService, never()).validate(3L);

        verifyNoMoreInteractions(memberService);
    }

    @Test
    void bddStyle() {
        // Given
        StudyService studyService = new StudyService(memberService, studyRepository);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("abdc2806@email.com");

        Study mockStudy = new Study();
        mockStudy.setLimitCount(10);
        mockStudy.setName("테스트");

        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(mockStudy)).willReturn(mockStudy);

        // When
        Study study = studyService.createNewStudy(1L, mockStudy);
        memberService.validate(1L);

        // Then
        assertNotNull(study.getOwner());
        assertEquals(member, study.getOwner());
        then(memberService).should(times(1)).validate(1L);
        then(memberService).shouldHaveNoMoreInteractions();
    }
}