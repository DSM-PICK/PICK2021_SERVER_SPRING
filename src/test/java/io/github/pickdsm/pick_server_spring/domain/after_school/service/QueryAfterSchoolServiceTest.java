package io.github.pickdsm.pick_server_spring.domain.after_school.service;


import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository.AfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.types.Day;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.response.AfterSchoolResponse;
import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QueryAfterSchoolServiceTest {

    @Mock
    AfterSchoolRepository afterSchoolRepository;

    @InjectMocks
    QueryAfterSchoolService queryAfterSchoolService;

    @Test
    void execute() {
        given(afterSchoolRepository.findAll()).willReturn(List.of(
                AfterSchool.builder()
                        .name("name")
                        .day(Day.MON)
                        .teacher(Teacher.builder().build())
                        .location(Location.builder().build())
                        .build()
        ));

        assertThat(queryAfterSchoolService.execute())
                .hasSize(1)
                .extracting(AfterSchoolResponse::getName)
                .contains("name");

    }

}