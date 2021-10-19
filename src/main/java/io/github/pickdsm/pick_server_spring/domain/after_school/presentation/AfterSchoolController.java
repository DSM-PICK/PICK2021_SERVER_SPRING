package io.github.pickdsm.pick_server_spring.domain.after_school.presentation;

import java.util.List;

import javax.validation.Valid;

import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.CreateAfterSchoolRequest;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.CreateAfterSchoolStudentRequest;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.RemoveAfterSchoolStudentRequest;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.UpdateAfterSchoolRequest;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.response.AfterSchoolResponse;
import io.github.pickdsm.pick_server_spring.domain.after_school.service.CreateAfterSchoolService;
import io.github.pickdsm.pick_server_spring.domain.after_school.service.CreateAfterSchoolStudentService;
import io.github.pickdsm.pick_server_spring.domain.after_school.service.QueryAfterSchoolService;
import io.github.pickdsm.pick_server_spring.domain.after_school.service.RemoveAfterSchoolService;
import io.github.pickdsm.pick_server_spring.domain.after_school.service.RemoveAfterSchoolStudentService;
import io.github.pickdsm.pick_server_spring.domain.after_school.service.UpdateAfterSchoolService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/after-school")
@RequiredArgsConstructor
public class AfterSchoolController {

	private final QueryAfterSchoolService queryAfterSchoolService;
	private final CreateAfterSchoolService createAfterSchoolService;
	private final UpdateAfterSchoolService updateAfterSchoolService;
	private final RemoveAfterSchoolService removeAfterSchoolService;
	private final CreateAfterSchoolStudentService createAfterSchoolStudentService;
	private final RemoveAfterSchoolStudentService removeAfterSchoolStudentService;

	@GetMapping("/list")
	public List<AfterSchoolResponse> queryAfterSchool() {
		return queryAfterSchoolService.execute();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createAfterSchool(@RequestBody @Valid CreateAfterSchoolRequest request) {
		createAfterSchoolService.execute(request);
	}

	@PatchMapping("/{after-school_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateAfterSchool(@PathVariable("after-school_id") Long afterSchoolId,
			@RequestBody @Valid UpdateAfterSchoolRequest request) {
		updateAfterSchoolService.execute(afterSchoolId, request);
	}

	@DeleteMapping("/{after-school_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeAfterSchool(@PathVariable("after-school_id") Long afterSchoolId) {
		removeAfterSchoolService.execute(afterSchoolId);
	}

	@PostMapping("/{after-school_id}/student")
	@ResponseStatus(HttpStatus.CREATED)
	public void createAfterSchoolStudent(@PathVariable("after-school_id") Long afterSchoolId,
			@RequestBody @Valid CreateAfterSchoolStudentRequest request) {
		createAfterSchoolStudentService.execute(afterSchoolId, request);
	}

	@DeleteMapping("/{after-school_id}/student")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeAfterSchoolStudent(@PathVariable("after-school_id") Long afterSchoolId,
			@RequestBody @Valid RemoveAfterSchoolStudentRequest request) {
		removeAfterSchoolStudentService.execute(afterSchoolId, request);
	}

}
