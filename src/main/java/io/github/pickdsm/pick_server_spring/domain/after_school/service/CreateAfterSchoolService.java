package io.github.pickdsm.pick_server_spring.domain.after_school.service;

import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository.AfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.exception.AlreadyExistAfterSchoolNameException;
import io.github.pickdsm.pick_server_spring.domain.after_school.exception.AlreadyExistDateAndLocationException;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.CreateAfterSchoolRequest;
import io.github.pickdsm.pick_server_spring.domain.after_school.utils.EnumUtils;
import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.location.facade.LocationFacade;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.facade.TeacherFacade;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAfterSchoolService {

	private final AfterSchoolRepository afterSchoolRepository;
	private final LocationFacade locationFacade;
	private final TeacherFacade teacherFacade;

	public void execute(CreateAfterSchoolRequest request) {
		if(afterSchoolRepository.findByName(request.getName()).isPresent())
			throw AlreadyExistAfterSchoolNameException.EXCEPTION;

		Location location = locationFacade
				.getLocationById(request.getLocationId());
		Teacher teacher = teacherFacade
				.getTeacherById(request.getTeacherId());

		try {
			afterSchoolRepository.save(
					AfterSchool.builder()
					.name(request.getName())
					.day(EnumUtils.convertToDay(request.getDay()))
					.location(location)
					.teacher(teacher)
					.build()
			);
		} catch (RuntimeException e) {
			throw AlreadyExistDateAndLocationException.EXCEPTION;
		}

	}

}
