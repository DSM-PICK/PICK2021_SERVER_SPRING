package io.github.pickdsm.pick_server_spring.domain.attendance.domain.repository.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class StudentInfoVO {

    private final String gcn;
    private final Long id;
    private final String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentInfoVO that = (StudentInfoVO) o;
        return Objects.equals(gcn, that.gcn) && Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gcn, id, name);
    }
}
