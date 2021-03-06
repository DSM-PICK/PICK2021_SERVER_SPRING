package io.github.pickdsm.pick_server_spring.domain.attendance.domain;

import io.github.pickdsm.pick_server_spring.domain.attendance.domain.type.State;
import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"date", "student_id", "period"})})
@Entity(name = "tbl_attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int period;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private State state;

    private String memo;

    private String reason;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id")
    private Location location;

    private LocalDate date;

    public Long getStudentId() {
        return this.student.getId();
    }

    public String getStudentName() {
        return this.student.getName();
    }

    public String getStudentGcn() {
        return this.student.getGcn();
    }

    public String getTeacherId() {
        return this.teacher.getId();
    }

    public String getTeacherName() {
        return this.teacher.getName();
    }

    public String getLocationName() {
        return this.location.getName();
    }

    @Builder
    public Attendance(int period, State state, String memo,
                      String reason, Student student, Teacher teacher, Location location, LocalDate date) {
        this.period = period;
        this.state = state;
        this.memo = memo;
        this.reason = reason;
        this.student = student;
        this.teacher = teacher;
        this.location = location;
        this.date = date;
    }

    public void updateAttendance(int period, State state, Location location, Teacher teacher, String reason) {
        this.period = period;
        this.state = state;
        this.location = location;
        this.teacher = teacher;
        this.reason = reason;
    }

}
