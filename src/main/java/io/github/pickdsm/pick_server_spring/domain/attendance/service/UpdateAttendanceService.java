package io.github.pickdsm.pick_server_spring.domain.attendance.service;

import io.github.pickdsm.pick_server_spring.domain.attendance.domain.Attendance;
import io.github.pickdsm.pick_server_spring.domain.attendance.domain.repository.AttendanceRepository;
import io.github.pickdsm.pick_server_spring.domain.attendance.domain.type.State;
import io.github.pickdsm.pick_server_spring.domain.attendance.exception.AttendanceNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.request.UpdateAttendanceRequest;
import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.location.facade.LocationFacade;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import io.github.pickdsm.pick_server_spring.domain.student.facade.StudentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateAttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final LocationFacade locationFacade;
    private final StudentFacade studentFacade;

    @Transactional
    public void updateAttendance(UpdateAttendanceRequest request, Long attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> AttendanceNotFoundException.EXCEPTION);

        Location location = locationFacade.getLocationById(request.getLocationId());

        Student student = studentFacade.getStudentById(request.getStudentId());

        attendance.updateAttendance(attendance.getPeriod(), student, State.valueOf(request.getState()), location);
    }

}
