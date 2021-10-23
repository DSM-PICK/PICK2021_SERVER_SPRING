package io.github.pickdsm.pick_server_spring.domain.after_school.service;

import javax.transaction.Transactional;

import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository.AfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.exception.AfterSchoolNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.UpdateAfterSchoolRequest;
import io.github.pickdsm.pick_server_spring.domain.after_school.utils.EnumUtils;
import io.github.pickdsm.pick_server_spring.domain.location.facade.LocationFacade;
import io.github.pickdsm.pick_server_spring.domain.teacher.facade.TeacherFacade;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateAfterSchoolService {

	private final AfterSchoolRepository afterSchoolRepository;
	private final LocationFacade locationFacade;
	private final TeacherFacade teacherFacade;

	@Transactional
	public void execute(Long afterSchoolId, UpdateAfterSchoolRequest request) {
		AfterSchool afterSchool = afterSchoolRepository
				.findById(afterSchoolId)
				.orElseThrow(() -> AfterSchoolNotFoundException.EXCEPTION);
		if(request.getName() != null) {
			afterSchool.changeName(request.getName());
		}
		if(request.getDay() != null) {
			afterSchool.changeDay(
					EnumUtils.convertToDay(request.getDay())
			);
		}
		if(request.getLocationId() != null) {
			afterSchool.changeLocation(
					locationFacade.getLocationById(request.getLocationId())
			);
		}
		if(request.getTeacherId() != null) {
			afterSchool.changeTeacher(
					teacherFacade.getTeacherById(request.getTeacherId())
			);
		}
	}

}
