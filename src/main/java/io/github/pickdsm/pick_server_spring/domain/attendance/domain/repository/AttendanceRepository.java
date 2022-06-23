package io.github.pickdsm.pick_server_spring.domain.attendance.domain.repository;

import io.github.pickdsm.pick_server_spring.domain.attendance.domain.Attendance;

import io.github.pickdsm.pick_server_spring.domain.attendance.domain.repository.vo.StudentInfoVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
    @Query("SELECT a FROM tbl_attendance a WHERE a.date = :date AND a.location.floor = :floor")
    List<Attendance> findByFloor(LocalDate date, int floor);

    @Query("SELECT a FROM tbl_attendance a WHERE a.date = :date AND a.location.id = :locationId")
    List<Attendance> findByLocationId(LocalDate date, Long locationId);

    @Query("SELECT NEW io.github.pickdsm.pick_server_spring." +
            "domain.attendance.domain.repository.vo.StudentInfoVO(a.student.gcn, a.student.id, a.student.name) " +
            "FROM tbl_attendance a WHERE a.date = :date AND a.location.id = :locationId")
    Set<StudentInfoVO> findStudentByLocationId(LocalDate date, Long locationId);

    @Query("SELECT NEW io.github.pickdsm.pick_server_spring." +
            "domain.attendance.domain.repository.vo.StudentInfoVO(a.gcn, a.id, a.name) " +
            "FROM tbl_student a WHERE a.location.id = :locationId")
    List<StudentInfoVO> findSelfStudyStudentByLocationId(Long locationId);

    @Query("SELECT NEW io.github.pickdsm.pick_server_spring." +
            "domain.attendance.domain.repository.vo.StudentInfoVO(a.gcn, a.id, a.name) " +
            "FROM tbl_student a WHERE a.major.location.id = :locationId")
    List<StudentInfoVO> findMajorStudyStudentByLocationId(Long locationId);

    @Query("SELECT NEW io.github.pickdsm.pick_server_spring." +
            "domain.attendance.domain.repository.vo.StudentInfoVO(a.student.gcn, a.student.id, a.student.name) " +
            "FROM tbl_affiliated_after_school a WHERE a.afterSchool.location.id = :locationId")
    List<StudentInfoVO> findAffiliatedAfterSchoolStudentByLocationId(Long locationId);

}
