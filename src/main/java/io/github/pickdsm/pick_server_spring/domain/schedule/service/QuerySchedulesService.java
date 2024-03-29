package io.github.pickdsm.pick_server_spring.domain.schedule.service;

import io.github.pickdsm.pick_server_spring.domain.director.domain.repository.DirectorRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.repository.ScheduleRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.response.ScheduleListResponse;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.response.ScheduleListResponse.Director;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuerySchedulesService {

    private final ScheduleRepository scheduleRepository;
    private final DirectorRepository directorRepository;

    public List<ScheduleListResponse> execute(int year, int month) {
        return scheduleRepository.findByYearAndMonth(String.valueOf(year), String.format("%02d", month))
                .stream()
                .map(schedule ->
                        new ScheduleListResponse(
                                schedule.getDate(),
                                schedule.getName().name(),
                                schedule.getPeriod(),
                                queryDirector(schedule)
                        )
                ).collect(Collectors.toList());
    }

    private List<Director> queryDirector(Schedule schedule) {
        return directorRepository.findBySchedule(schedule.getId())
                .stream()
                .map(director -> {
                    Teacher teacher = director.getTeacher();
                    return new Director(teacher.getName(), teacher.getId(), director.getFloor());
                }).collect(Collectors.toList());
    }

}
