package io.github.pickdsm.pick_server_spring.domain.after_school.service;

import io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.facade.AffiliatedAfterSchoolFacade;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository.AfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.exception.AfterSchoolNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.RemoveAfterSchoolStudentRequest;
import io.github.pickdsm.pick_server_spring.domain.student.facade.StudentFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class RemoveAfterSchoolStudentServiceTest {

    @Mock
    AffiliatedAfterSchoolFacade affiliatedAfterSchoolFacade;
    
    @Mock
    AfterSchoolRepository afterSchoolRepository;
    
    @Mock
    StudentFacade studentFacade;

    @InjectMocks
    RemoveAfterSchoolStudentService removeAfterSchoolStudentService;

    @Mock
    RemoveAfterSchoolStudentRequest removeAfterSchoolStudentRequest;

    @Test
    void afterSchoolNotFound() {
        given(afterSchoolRepository.findById(1L)).willReturn(Optional.empty());

        assertThatThrownBy(() -> removeAfterSchoolStudentService.execute(1L, removeAfterSchoolStudentRequest))
                .isInstanceOf(AfterSchoolNotFoundException.class);
    }

    @Test
    void execute() {
        given(afterSchoolRepository.findById(1L)).willReturn(Optional.of(AfterSchool.builder().build()));
        given(removeAfterSchoolStudentRequest.getStudentId()).willReturn(1L);

        removeAfterSchoolStudentService.execute(1L, removeAfterSchoolStudentRequest);
    }

}