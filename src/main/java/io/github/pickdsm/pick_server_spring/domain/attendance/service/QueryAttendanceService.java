package io.github.pickdsm.pick_server_spring.domain.attendance.service;

import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository.AfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.exception.AfterSchoolNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.attendance.domain.Attendance;
import io.github.pickdsm.pick_server_spring.domain.attendance.domain.repository.AttendanceRepository;
import io.github.pickdsm.pick_server_spring.domain.attendance.domain.repository.vo.StudentInfoVO;
import io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.request.QueryAttendanceRequest;
import io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.response.QueryAttendanceResponse;
import io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.response.StudentAttendance;
import io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.response.StudentInfo;
import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.location.facade.LocationFacade;
import io.github.pickdsm.pick_server_spring.domain.major.domain.Major;
import io.github.pickdsm.pick_server_spring.domain.major.domain.repository.MajorRepository;
import io.github.pickdsm.pick_server_spring.domain.major.exception.MajorNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.repository.ScheduleRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.types.ScheduleName;
import io.github.pickdsm.pick_server_spring.domain.schedule.exception.ScheduleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryAttendanceService {

    private final AttendanceRepository attendanceRepository;;
    private final ScheduleRepository scheduleRepository;
    private final MajorRepository majorRepository;
    private final AfterSchoolRepository afterSchoolRepository;
    private final LocationFacade locationFacade;

    public QueryAttendanceResponse queryAttendance(LocalDate requestLocal, Long locationId) {
        LocalDate date = requestLocal == null ? LocalDate.now() : requestLocal;

        Schedule schedule = scheduleRepository.findByDate(date)
                .orElseThrow(() -> ScheduleNotFoundException.EXCEPTION);

        Location location = locationFacade.getLocationById(locationId);

        String scheduleName =  schedule.getName().toString();
        String locationName = location.getName();

        String className = location.getName();
        String headName = null;

        List<StudentInfoVO> studentInfoVOList;

        if(ScheduleName.MAJOR.equals(schedule.getName())) {
            Major major = majorRepository.findByLocation(location)
                    .orElseThrow(() -> MajorNotFoundException.EXCEPTION);

            className = major.getName();
            headName = major.getHeadName();
            studentInfoVOList = attendanceRepository.findMajorStudyStudentByLocationId(locationId);
        } else if(ScheduleName.AFTER_SCHOOL.equals(schedule.getName())) {
            AfterSchool afterSchool = afterSchoolRepository.findByLocation(location)
                    .orElseThrow(() -> AfterSchoolNotFoundException.EXCEPTION);

            className = afterSchool.getName();
            studentInfoVOList = attendanceRepository.findAffiliatedAfterSchoolStudentByLocationId(locationId);
        } else {
            studentInfoVOList = attendanceRepository.findSelfStudyStudentByLocationId(locationId);
        }

        List<Attendance> attendances = attendanceRepository.findByLocationId(date, location.getId());

        List<StudentInfo> studentInfoList = studentInfoVOList
                .stream()
                .map(student -> {
                    List<StudentAttendance> attendanceList = attendances.stream()
                            .filter(attendance -> attendance.getStudentId().equals(student.getId()))
                            .map(attendance ->
                                    new StudentAttendance(
                                            attendance.getId(),
                                            attendance.getPeriod(),
                                            attendance.getLocationName(),
                                            attendance.getState()
                                    )
                            )
                            .collect(Collectors.toList());

                    return new StudentInfo(student.getGcn(), student.getId(), student.getName(), attendanceList);
                }).collect(Collectors.toList());

        return new QueryAttendanceResponse(scheduleName, locationName, className, headName, schedule.getPeriod(), studentInfoList);

    }

}
