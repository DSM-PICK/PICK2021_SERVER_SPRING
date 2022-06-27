package io.github.pickdsm.pick_server_spring.domain.after_school.service;

import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository.AfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.exception.AfterSchoolNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class RemoveAfterSchoolServiceTest {

    @Mock
    AfterSchoolRepository afterSchoolRepository;

    @InjectMocks
    RemoveAfterSchoolService removeAfterSchoolService;

    @Test
    void afterSchoolNotFound() {
        given(afterSchoolRepository.existsById(1L)).willReturn(false);

        assertThatThrownBy(() -> removeAfterSchoolService.execute(1L))
                .isInstanceOf(AfterSchoolNotFoundException.class);
    }

    @Test
    void execute() {
        given(afterSchoolRepository.existsById(1L)).willReturn(true);

        removeAfterSchoolService.execute(1L);
    }

}