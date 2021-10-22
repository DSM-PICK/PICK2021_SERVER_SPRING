package io.github.pickdsm.pick_server_spring.domain.student.domain.repository;

import java.util.List;
import java.util.Optional;

import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
	Optional<Student> findByNameAndGcn(String name, String gcn);
	@Query("select s from tbl_student s where s.major.id = :majorId")
	List<Student> findByMajor(Long majorId);
	@Query("select s from tbl_student s where s.name like %:name%")
	List<Student> findByNameLike(String name);
}
