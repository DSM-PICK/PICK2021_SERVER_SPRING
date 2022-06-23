package io.github.pickdsm.pick_server_spring.domain.attendance.service;

import io.github.pickdsm.pick_server_spring.domain.attendance.domain.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteAttendanceService {

    private final AttendanceRepository attendanceRepository;

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

}
