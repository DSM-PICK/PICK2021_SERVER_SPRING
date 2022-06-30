package io.github.pickdsm.pick_server_spring.domain.attendance.service;

import io.github.pickdsm.pick_server_spring.domain.attendance.domain.Attendance;
import io.github.pickdsm.pick_server_spring.domain.attendance.domain.repository.AttendanceRepository;
import io.github.pickdsm.pick_server_spring.domain.attendance.domain.type.State;
import io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.request.PostAttendanceRequest;
import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.location.facade.LocationFacade;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import io.github.pickdsm.pick_server_spring.domain.student.facade.StudentFacade;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.facade.TeacherFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class PostAttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentFacade studentFacade;
    private final TeacherFacade teacherFacade;
    private final LocationFacade locationFacade;

    @Transactional
    public void postAttendance(PostAttendanceRequest request) {

        Student student = studentFacade.getStudentById(request.getStudentId());
        Location location;

        State state = State.valueOf(request.getState());

        if(State.이동.equals(state)) {
            location = locationFacade.getLocationById(request.getLocationId());
        } else {
            location = student.getLocation();
        }

        Teacher teacher = teacherFacade.getTeacherById(teacherFacade.getCurrentTeacherId());

        if(request.getStartDate().equals(request.getEndDate())) {
            saveAttendance(request.getStartPeriod(), request.getEndPeriod(), student, teacher, location, state,
                    request.getReason(), request.getStartDate());
        } else { //날짜가 다를 때
            LocalDate startDate = request.getStartDate();
            while(startDate.isBefore(request.getEndDate()) || startDate.isEqual(request.getEndDate())) {
                if(request.getStartDate().equals(startDate)) {
                    saveAttendance(request.getStartPeriod(), 10, student, teacher, location, state,
                            request.getReason(), request.getStartDate());
                } else if(request.getEndDate().equals(startDate)) {
                    saveAttendance(8, request.getEndPeriod(), student, teacher, location, state,
                            request.getReason(), request.getEndDate());
                } else {
                    saveAttendance(8, 10, student, teacher, location, state,
                            request.getReason(), startDate);
                }

                //TODO 금요일 7교시부터시작 처리
                startDate = startDate.plusDays(1);
            }
        }

    }

    private void saveAttendance(int startPeriod, int endPeriod, Student student, Teacher teacher, Location location,
                                State state, String reason, LocalDate date) {
        for(int i = startPeriod; i <= endPeriod; i++) {
            System.out.println("hihii");
            if (attendanceRepository.findByLocationAndStudentAndDateAndPeriod(location, student, date, i).isPresent()) {
                Attendance attendance = attendanceRepository.findByLocationAndStudentAndDateAndPeriod(location, student, date, i).get();
                attendance.updateAttendance(i, state, location, teacher, reason);
                attendanceRepository.save(attendance);
            } else {
                Attendance attendance = Attendance.builder()
                        .student(student)
                        .teacher(teacher)
                        .location(location)
                        .state(state)
                        .reason(reason)
                        .date(date)
                        .period(i)
                        .build();
                attendanceRepository.save(attendance);
            }

        }
    }

}
