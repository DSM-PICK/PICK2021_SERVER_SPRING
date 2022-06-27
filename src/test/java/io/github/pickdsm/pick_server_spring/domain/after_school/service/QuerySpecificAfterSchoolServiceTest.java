package io.github.pickdsm.pick_server_spring.domain.after_school.service;

import io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.domain.AffiliatedAfterSchool;
import io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.domain.repository.AffiliatedAfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository.AfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.types.Day;
import io.github.pickdsm.pick_server_spring.domain.after_school.exception.AfterSchoolNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.response.AfterSchoolDetailResponse;
import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class QuerySpecificAfterSchoolServiceTest {

    @Mock
    AfterSchoolRepository afterSchoolRepository;

    @Mock
    AffiliatedAfterSchoolRepository affiliatedAfterSchoolRepository;

    @InjectMocks
    QuerySpecificAfterSchoolService querySpecificAfterSchoolService;

    @Test
    void afterSchoolNotFound() {
        given(afterSchoolRepository.findById(1L)).willReturn(Optional.empty());

        assertThatThrownBy(() -> querySpecificAfterSchoolService.execute(1L))
                .isInstanceOf(AfterSchoolNotFoundException.class);
    }

    @Test
    void execute() {
        AfterSchool afterSchool = AfterSchool.builder()
                .teacher(Teacher.builder().build())
                .location(Location.builder().build())
                .name("after school name")
                .day(Day.MON)
                .build();
        Student student = Student.builder()
                .name("student")
                .build();
        given(afterSchoolRepository.findById(1L)).willReturn(Optional.of(afterSchool));

        given(affiliatedAfterSchoolRepository.findByAfterSchool(afterSchool))
                .willReturn(List.of(
                        AffiliatedAfterSchool.builder()
                                .student(student)
                                .afterSchool(afterSchool)
                                .build()
                ));

        AfterSchoolDetailResponse response = querySpecificAfterSchoolService.execute(1L);

        assertThat(response.getAfterSchoolName()).isEqualTo("after school name");
        assertThat(response.getDay()).isEqualTo("MON");
        assertThat(response.getCount()).isEqualTo(1);
        assertThat(response.getMembers().get(0).getStudentName()).isEqualTo("student");
    }

}