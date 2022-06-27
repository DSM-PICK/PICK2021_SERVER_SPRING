package io.github.pickdsm.pick_server_spring.domain.attendance.service;

import io.github.pickdsm.pick_server_spring.domain.attendance.domain.Attendance;
import io.github.pickdsm.pick_server_spring.domain.attendance.domain.repository.AttendanceRepository;
import io.github.pickdsm.pick_server_spring.domain.attendance.domain.type.State;
import io.github.pickdsm.pick_server_spring.domain.attendance.exception.AttendanceNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.request.UpdateAttendanceRequest;
import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.location.facade.LocationFacade;
import io.github.pickdsm.pick_server_spring.domain.student.facade.StudentFacade;
import io.github.pickdsm.pick_server_spring.domain.teacher.facade.TeacherFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateAttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final TeacherFacade teacherFacade;
    private final LocationFacade locationFacade;
    private final StudentFacade studentFacade;

    @Transactional
    public void updateAttendance(UpdateAttendanceRequest request) {
        Attendance attendance = attendanceRepository.findById(request.getAttendanceId())
                .orElseThrow(() -> AttendanceNotFoundException.EXCEPTION);

        Location location;
        if (State.이동.equals(State.valueOf(request.getState()))) {
            location = locationFacade.getLocationById(request.getLocationId());
        } else {
            location = attendance.getLocation();
        }

        attendance.updateAttendance(attendance.getPeriod(), attendance.getStudent(), State.valueOf(request.getState()), location);


    }

}
