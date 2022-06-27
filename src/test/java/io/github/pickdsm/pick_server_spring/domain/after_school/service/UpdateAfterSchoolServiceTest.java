package io.github.pickdsm.pick_server_spring.domain.after_school.service;

import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository.AfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.exception.AfterSchoolNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.UpdateAfterSchoolRequest;
import io.github.pickdsm.pick_server_spring.domain.location.facade.LocationFacade;
import io.github.pickdsm.pick_server_spring.domain.teacher.facade.TeacherFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UpdateAfterSchoolServiceTest {

    @Mock
    AfterSchoolRepository afterSchoolRepository;
    
    @Mock
    LocationFacade locationFacade;
    
    @Mock
    TeacherFacade teacherFacade;

    @InjectMocks
    UpdateAfterSchoolService updateAfterSchoolService;

    @Mock
    UpdateAfterSchoolRequest updateAfterSchoolRequest;

    @Test
    void afterSchoolNotFound() {
        Long afterSchoolId = 1L;

        given(afterSchoolRepository.findById(afterSchoolId)).willReturn(Optional.empty());

        assertThatThrownBy(() -> updateAfterSchoolService.execute(afterSchoolId, updateAfterSchoolRequest))
                .isInstanceOf(AfterSchoolNotFoundException.class);
    }

    @Test
    void execute() {
        given(updateAfterSchoolRequest.getTeacherId()).willReturn("dsm00");
        given(updateAfterSchoolRequest.getLocationId()).willReturn(1L);
        given(updateAfterSchoolRequest.getDay()).willReturn("MON");
        given(updateAfterSchoolRequest.getName()).willReturn("수학");

        given(afterSchoolRepository.findById(1L)).willReturn(Optional.of(AfterSchool.builder().build()));

        updateAfterSchoolService.execute(1L, updateAfterSchoolRequest);
    }

}