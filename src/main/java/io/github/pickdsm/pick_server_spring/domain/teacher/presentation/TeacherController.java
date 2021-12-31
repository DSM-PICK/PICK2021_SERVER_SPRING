package io.github.pickdsm.pick_server_spring.domain.teacher.presentation;

import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.*;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.*;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

	private final RegisterTeacherService registerTeacherService;
	private final LoginTeacherService loginTeacherService;
	private final QueryInformationService queryInformationService;
	private final ChangePasswordService changePasswordService;
	private final TokenRefreshService tokenRefreshService;
	private final ChangeNameService changeNameService;
	private final QueryTeacherListService queryTeacherListService;
	private final QueryStudentService queryStudentService;
	private final QueryStudentDetailService queryStudentDetailService;
	private final QuerySpecificDateService querySpecificDateService;

	@PostMapping("/register")
	public TokenResponse registerTeacher(@RequestBody @Valid RegisterRequest request) {
		return registerTeacherService.execute(request);
	}

	@PostMapping("/login")
	public LoginResponse loginTeacher(@RequestBody @Valid LoginRequest request) {
		return loginTeacherService.execute(request);
	}

	@GetMapping("/{teacher_id}/information")
	public InformationResponse queryInformation(@PathVariable("teacher_id") String teacherId) {
		return queryInformationService.execute(teacherId);
	}

	@PutMapping("/auth")
	public TokenResponse tokenRefresh(@RequestBody @Valid TokenRequest request) {
		return tokenRefreshService.execute(request);
	}

	@PatchMapping("/password")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changePassword(@RequestBody @Valid ChangePasswordRequest request) {
		changePasswordService.execute(request);
	}

	@PatchMapping("/name")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changeName(@RequestBody @Valid ChangeNameRequest request) {
		changeNameService.execute(request);
	}

	@GetMapping("/list")
	public List<TeacherResponse> queryTeacherList() {
		return queryTeacherListService.execute();
	}

	@GetMapping("/student")
	public List<StudentResponse> queryStudent(@RequestParam("name") String name) {
		return queryStudentService.execute(name);
	}

	@GetMapping("/student/detail")
	public List<StudentDetailResponse> queryStudentDetail(@RequestParam("name") String name) {
		return queryStudentDetailService.execute(name);
	}

	@GetMapping("/{date}")
	public TeacherScheduleResponse querySpecificDate(@PathVariable("date") String date) {
		return querySpecificDateService
				.execute(LocalDate.parse(date, DateTimeFormatter.ISO_DATE));
	}

}
