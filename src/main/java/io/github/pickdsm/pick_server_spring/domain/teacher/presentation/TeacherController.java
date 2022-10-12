package io.github.pickdsm.pick_server_spring.domain.teacher.presentation;

import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.ChangeNameRequest;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.ChangePasswordRequest;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.CreateTeacherRequest;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.LoginRequest;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.RegisterRequest;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.TokenRequest;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.InformationResponse;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.LoginResponse;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.StudentDetailResponse;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.StudentResponse;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.TeacherResponse;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.TeacherScheduleResponse;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.TokenResponse;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.ChangeNameService;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.ChangePasswordService;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.CreateTeacherService;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.LoginTeacherService;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.QueryInformationService;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.QuerySpecificDateService;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.QueryStudentDetailService;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.QueryStudentService;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.QueryTeacherListService;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.RegisterTeacherService;
import io.github.pickdsm.pick_server_spring.domain.teacher.service.TokenRefreshService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    private final CreateTeacherService createTeacherService;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createTeacher(@RequestBody @Valid CreateTeacherRequest request) {
        createTeacherService.execute(request);
    }

}
