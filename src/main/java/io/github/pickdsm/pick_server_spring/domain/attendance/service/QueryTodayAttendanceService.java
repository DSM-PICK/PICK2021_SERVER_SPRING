package io.github.pickdsm.pick_server_spring.domain.attendance.service;

import io.github.pickdsm.pick_server_spring.domain.attendance.domain.Attendance;
import io.github.pickdsm.pick_server_spring.domain.attendance.domain.repository.AttendanceRepository;
import io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.response.QueryTodayAttendanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryTodayAttendanceService {

    private static final int ALL_FLOOR = 1;

    private final AttendanceRepository attendanceRepository;

    public List<QueryTodayAttendanceResponse> queryTodayAttendance(int floor) {
        List<Attendance> attendanceList;
        if(floor == ALL_FLOOR) {
            attendanceList = attendanceRepository.findAllByDate(LocalDate.now());
        } else {
            attendanceList = attendanceRepository.findByFloor(LocalDate.now(), floor);
        }

        return attendanceList
                .stream().map(attendance ->
                    new QueryTodayAttendanceResponse(attendance.getId(), attendance.getState(), attendance.getPeriod(),
                            attendance.getReason(), attendance.getStudentId(), attendance.getStudentName(), attendance.getStudentGcn(),
                            attendance.getTeacherId(), attendance.getTeacherName())
                ).collect(Collectors.toList());
        //TODO startPeriod, endPeriod 추가
    }

}
