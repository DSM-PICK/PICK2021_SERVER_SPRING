package io.github.pickdsm.pick_server_spring.domain.attendance.domain.repository;

import io.github.pickdsm.pick_server_spring.domain.attendance.domain.Attendance;
import io.github.pickdsm.pick_server_spring.domain.attendance.domain.repository.vo.StudentInfoVO;
import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
    @Query("SELECT a FROM tbl_attendance a WHERE a.date = :date AND a.location.floor = :floor")
    List<Attendance> findByFloor(LocalDate date, int floor);

    List<Attendance> findAllByDate(LocalDate date);

    @Query("SELECT a FROM tbl_attendance a WHERE a.date = :date AND a.location.id = :locationId")
    List<Attendance> findByLocationId(LocalDate date, Long locationId);

    Optional<Attendance> findByLocationAndStudentAndDateAndPeriod(Location location, Student student, LocalDate date, int period);

    @Query("SELECT a FROM tbl_attendance a WHERE a.date = :date AND a.student.major.location.id = :locationId")
    List<Attendance> findByMajorLocationId(LocalDate date, Long locationId);

    @Query("SELECT a FROM tbl_attendance a WHERE a.date = :date AND a.student.location.id = :locationId")
    List<Attendance> findByStudentLocationId(LocalDate date, Long locationId);

    @Query("SELECT a FROM tbl_attendance a " +
            "LEFT JOIN FETCH tbl_affiliated_after_school taas ON a.student.id = taas.student.id " +
            "LEFT JOIN FETCH tbl_after_school tas ON taas.afterSchool.id = tas.id " +
            "WHERE a.date = :date AND tas.location.id = :locationId")
    List<Attendance> findByAfterSchoolId(LocalDate date, Long locationId);

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
            "FROM tbl_affiliated_after_school a WHERE a.afterSchool.location.id = :locationId AND a.afterSchool.id = :afterSchoolId")
    List<StudentInfoVO> findAffiliatedAfterSchoolStudentByLocationId(Long locationId, Long afterSchoolId);

}
