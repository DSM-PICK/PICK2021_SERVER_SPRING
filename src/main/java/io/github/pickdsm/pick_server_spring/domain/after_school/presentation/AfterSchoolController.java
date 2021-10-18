package io.github.pickdsm.pick_server_spring.domain.after_school.presentation;

import java.util.List;

import javax.validation.Valid;

import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.CreateAfterSchoolRequest;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.UpdateAfterSchoolRequest;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.response.AfterSchoolResponse;
import io.github.pickdsm.pick_server_spring.domain.after_school.service.CreateAfterSchoolService;
import io.github.pickdsm.pick_server_spring.domain.after_school.service.QueryAfterSchoolService;
import io.github.pickdsm.pick_server_spring.domain.after_school.service.UpdateAfterSchoolService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
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

}
