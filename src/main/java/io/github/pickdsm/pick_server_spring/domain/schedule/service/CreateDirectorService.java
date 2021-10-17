package io.github.pickdsm.pick_server_spring.domain.schedule.service;

import io.github.pickdsm.pick_server_spring.domain.director.domain.Director;
import io.github.pickdsm.pick_server_spring.domain.director.domain.repository.DirectorRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.repository.ScheduleRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.exception.AlreadyExistDirectorException;
import io.github.pickdsm.pick_server_spring.domain.schedule.exception.DirectorNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.schedule.exception.ScheduleNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.CreateDirectorRequest;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.TeacherRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.TeacherNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.teacher.facade.TeacherFacade;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateDirectorService {

	private final TeacherFacade teacherFacade;
	private final DirectorRepository directorRepository;
	private final ScheduleRepository scheduleRepository;

	public void execute(CreateDirectorRequest request) {
		Schedule schedule = scheduleRepository
				.findByDate(request.getDate())
				.orElseThrow(ScheduleNotFoundException::new);
		Teacher teacher = teacherFacade.getTeacherById(request.getTeacherId());
		directorRepository.findByScheduleAndFloor(schedule.getId(), request.getFloor())
				.ifPresent(director -> {throw new AlreadyExistDirectorException();});
		directorRepository.save(
				Director.builder()
				.floor(request.getFloor())
				.schedule(schedule)
				.teacher(teacher)
				.build()
		);
	}

}
