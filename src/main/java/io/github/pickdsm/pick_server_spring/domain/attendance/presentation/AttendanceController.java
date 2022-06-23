package io.github.pickdsm.pick_server_spring.domain.attendance.presentation;

import io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.request.PostAttendanceRequest;
import io.github.pickdsm.pick_server_spring.domain.attendance.service.PostAttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/attendance")
@RestController
public class AttendanceController {

    private final PostAttendanceService postAttendanceService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void postAttendance(@RequestBody PostAttendanceRequest request) {
        postAttendanceService.postAttendance(request);
    }


}
