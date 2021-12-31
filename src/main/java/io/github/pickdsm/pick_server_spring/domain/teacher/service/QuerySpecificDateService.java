package io.github.pickdsm.pick_server_spring.domain.teacher.service;

import io.github.pickdsm.pick_server_spring.domain.director.domain.repository.DirectorRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.repository.ScheduleRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.exception.ScheduleNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.TeacherResponseElement;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.TeacherScheduleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuerySpecificDateService {

    private final ScheduleRepository scheduleRepository;
    private final DirectorRepository directorRepository;

    public TeacherScheduleResponse execute(LocalDate date) {
        Schedule schedule = scheduleRepository.findByDate(date)
                .orElseThrow(() -> ScheduleNotFoundException.EXCEPTION);

        List<TeacherResponseElement> responseElements = new ArrayList<>();

        directorRepository.findBySchedule(schedule.getId())
                .forEach(director ->
                    responseElements.add(new TeacherResponseElement(director.getTeacher().getId(),
                            director.getTeacher().getName(), director.getFloor()))
                );

        return new TeacherScheduleResponse(responseElements);
    }

}
