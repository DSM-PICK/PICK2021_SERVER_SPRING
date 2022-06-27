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
import io.github.pickdsm.pick_server_spring.domain.teacher.facade.TeacherFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class UpdateAttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final TeacherFacade teacherFacade;
    private final LocationFacade locationFacade;
    private final StudentFacade studentFacade;

    @Transactional
    public void updateAttendance(UpdateAttendanceRequest request) {
        Location location = locationFacade.getLocationById(request.getLocationId());

        if (request.getAttendanceId() != null) {
            Attendance attendance = attendanceRepository.findById(request.getAttendanceId())
                    .orElseThrow(() -> AttendanceNotFoundException.EXCEPTION);
            attendance.updateAttendance(attendance.getPeriod(), attendance.getStudent(), State.valueOf(request.getState()), location);
        } else {
            Student student = studentFacade.getStudentById(request.getStudentId());
            attendanceRepository.save(
                    Attendance.builder()
                            .period(request.getPeriod())
                            .state(State.valueOf(request.getState()))
                            .student(student)
                            .location(location)
                            .student(student)
                            .teacher(teacherFacade.getTeacherById(teacherFacade.getCurrentTeacherId()))
                            .date(LocalDate.now())
                            .build()
            );
        }

    }

}
