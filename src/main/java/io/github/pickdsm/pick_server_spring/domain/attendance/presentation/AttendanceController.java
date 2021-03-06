package io.github.pickdsm.pick_server_spring.domain.attendance.presentation;

import io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.request.PostAttendanceRequest;
import io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.request.QueryAttendanceRequest;
import io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.request.UpdateAttendanceRequest;
import io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.response.QueryAttendanceResponse;
import io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.response.QueryTodayAttendanceResponse;
import io.github.pickdsm.pick_server_spring.domain.attendance.service.DeleteAttendanceService;
import io.github.pickdsm.pick_server_spring.domain.attendance.service.PostAttendanceService;
import io.github.pickdsm.pick_server_spring.domain.attendance.service.QueryAttendanceService;
import io.github.pickdsm.pick_server_spring.domain.attendance.service.QueryTodayAttendanceService;
import io.github.pickdsm.pick_server_spring.domain.attendance.service.UpdateAttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/attendance")
@RestController
public class AttendanceController {

    private final PostAttendanceService postAttendanceService;
    private final QueryTodayAttendanceService queryTodayAttendanceService;
    private final DeleteAttendanceService deleteAttendanceService;
    private final UpdateAttendanceService updateAttendanceService;
    private final QueryAttendanceService queryAttendanceService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void postAttendance(@RequestBody PostAttendanceRequest request) {
        postAttendanceService.postAttendance(request);
    }

    @GetMapping("/today")
    public List<QueryTodayAttendanceResponse> queryTodayAttendance(@RequestParam("floor") int floor) {
        return queryTodayAttendanceService.queryTodayAttendance(floor);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{attendanceId}")
    public void deleteAttendance(@PathVariable("attendanceId") Long attendanceId) {
        deleteAttendanceService.deleteAttendance(attendanceId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping
    public void updateAttendance(@RequestBody UpdateAttendanceRequest request) {
        updateAttendanceService.updateAttendance(request);
    }

    @GetMapping("/{locationId}")
    public QueryAttendanceResponse queryAttendance(@RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @PathVariable("locationId") Long locationId) {
        return queryAttendanceService.queryAttendance(date, locationId);
    }


}
