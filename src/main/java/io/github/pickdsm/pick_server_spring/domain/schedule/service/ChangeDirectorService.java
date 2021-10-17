package io.github.pickdsm.pick_server_spring.domain.schedule.service;

import javax.transaction.Transactional;

import io.github.pickdsm.pick_server_spring.domain.director.domain.repository.DirectorRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.repository.ScheduleRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.exception.DirectorNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.schedule.exception.ScheduleNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.ChangeDirectorRequest;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.TeacherRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.TeacherNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeDirectorService {

	private final TeacherRepository teacherRepository;
	private final DirectorRepository directorRepository;
	private final ScheduleRepository scheduleRepository;

	@Transactional
	public void execute(ChangeDirectorRequest request) {
		Schedule schedule = scheduleRepository
				.findByDate(request.getDate())
				.orElseThrow(ScheduleNotFoundException::new);
		Teacher teacher = teacherRepository.findById(request.getTeacherId())
				.orElseThrow(TeacherNotFoundException::new);
		directorRepository.findByScheduleAndFloor(schedule.getId(), request.getFloor())
				.orElseThrow(DirectorNotFoundException::new)
				.changeTeacher(teacher);

	}

}