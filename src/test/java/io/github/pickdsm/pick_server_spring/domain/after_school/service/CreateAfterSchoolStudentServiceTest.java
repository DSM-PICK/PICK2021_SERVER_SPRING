package io.github.pickdsm.pick_server_spring.domain.after_school.service;

import io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.facade.AffiliatedAfterSchoolFacade;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository.AfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.exception.AfterSchoolNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.CreateAfterSchoolStudentRequest;
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
class CreateAfterSchoolStudentServiceTest {

    @Mock
    AfterSchoolRepository afterSchoolRepository;

    @Mock
    StudentFacade studentFacade;

    @Mock
    AffiliatedAfterSchoolFacade affiliatedAfterSchoolFacade;

    @InjectMocks
    CreateAfterSchoolStudentService createAfterSchoolStudentService;

    @Mock
    CreateAfterSchoolStudentRequest createAfterSchoolStudentRequest;

    @Test
    void afterSchoolNotFound() {
        Long afterSchoolId = 1L;

        given(afterSchoolRepository.findById(afterSchoolId)).willReturn(Optional.empty());

        assertThatThrownBy(() -> createAfterSchoolStudentService.execute(afterSchoolId, createAfterSchoolStudentRequest))
                .isInstanceOf(AfterSchoolNotFoundException.class);
    }

    @Test
    void execute() {
        Long afterSchoolId = 1L;

        given(createAfterSchoolStudentRequest.getStudentId()).willReturn(1L);
        given(afterSchoolRepository.findById(afterSchoolId)).willReturn(Optional.of(AfterSchool.builder().build()));

        createAfterSchoolStudentService.execute(afterSchoolId, createAfterSchoolStudentRequest);
    }

}