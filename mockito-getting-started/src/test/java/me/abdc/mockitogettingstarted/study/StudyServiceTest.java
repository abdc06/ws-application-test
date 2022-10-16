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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

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
}