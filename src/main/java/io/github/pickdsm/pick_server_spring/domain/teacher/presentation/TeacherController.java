package io.github.pickdsm.pick_server_spring.domain.teacher.presentation;

import javax.validation.Valid;

import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.LoginRequest;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.RegisterRequest;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.InformationResponse;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.TokenResponse;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.LoginTeacherService;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.QueryInformationService;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.RegisterTeacherService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

	private final RegisterTeacherService registerTeacherService;
	private final LoginTeacherService loginTeacherService;
	private final QueryInformationService queryInformationService;

	@PostMapping("/register")
	public TokenResponse registerTeacher(@RequestBody @Valid RegisterRequest request) {
		return registerTeacherService.execute(request);
	}

	@PostMapping("/login")
	public TokenResponse loginTeacher(@RequestBody @Valid LoginRequest request) {
		return loginTeacherService.execute(request);
	}

	@GetMapping("/{teacher_id}/information")
	public InformationResponse queryInformation(@PathVariable("teacher_id") String teacherId) {
		return queryInformationService.execute(teacherId);
	}

}
