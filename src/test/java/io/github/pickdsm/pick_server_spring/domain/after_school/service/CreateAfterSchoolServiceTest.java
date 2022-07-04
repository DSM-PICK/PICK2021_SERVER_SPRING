package io.github.pickdsm.pick_server_spring.domain.after_school.service;

import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository.AfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.types.Day;
import io.github.pickdsm.pick_server_spring.domain.after_school.exception.AlreadyExistAfterSchoolNameException;
import io.github.pickdsm.pick_server_spring.domain.after_school.exception.AlreadyExistDateAndLocationException;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.CreateAfterSchoolRequest;
import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.location.facade.LocationFacade;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.facade.TeacherFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CreateAfterSchoolServiceTest {

    @Mock
    AfterSchoolRepository afterSchoolRepository;

    @Mock
    LocationFacade locationFacade;

    @Mock
    TeacherFacade teacherFacade;

    @InjectMocks
    CreateAfterSchoolService createAfterSchoolService;

    @Mock
    CreateAfterSchoolRequest request;

    @Test
    void alreadyExistAfterSchool() {
        given(request.getName()).willReturn("name");

        given(afterSchoolRepository.findByName(request.getName())).willReturn(Optional.of(AfterSchool.builder().build()));


        assertThatThrownBy(() -> createAfterSchoolService.execute(request))
                .isInstanceOf(AlreadyExistAfterSchoolNameException.class);
    }

    @Test
    void saveFail() {
        given(request.getName()).willReturn("name");
        given(request.getDay()).willReturn(Day.MON.name());
        given(request.getLocationId()).willReturn(1L);
        given(request.getTeacherId()).willReturn("dsm00");

        given(locationFacade.getLocationById(request.getLocationId())).willReturn(Location.builder().build());
        given(teacherFacade.getTeacherById(request.getTeacherId())).willReturn(Teacher.builder().build());

        given(afterSchoolRepository.save(any())).willThrow(RuntimeException.class);

        assertThatThrownBy(() -> createAfterSchoolService.execute(request))
                .isInstanceOf(AlreadyExistDateAndLocationException.class);

    }

    @Test
    void execute() {
        given(request.getName()).willReturn("name");
        given(request.getDay()).willReturn(Day.MON.name());
        given(request.getLocationId()).willReturn(1L);
        given(request.getTeacherId()).willReturn("dsm00");

        given(locationFacade.getLocationById(request.getLocationId())).willReturn(Location.builder().build());
        given(teacherFacade.getTeacherById(request.getTeacherId())).willReturn(Teacher.builder().build());
        given(afterSchoolRepository.save(any())).willReturn(AfterSchool.builder().build());

        createAfterSchoolService.execute(request);
    }


}