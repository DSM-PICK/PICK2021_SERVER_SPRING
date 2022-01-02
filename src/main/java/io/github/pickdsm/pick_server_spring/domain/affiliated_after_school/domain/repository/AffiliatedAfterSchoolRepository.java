package io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.domain.repository;

import io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.domain.AffiliatedAfterSchool;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AffiliatedAfterSchoolRepository extends CrudRepository<AffiliatedAfterSchool, Long> {

	@Modifying
	@Query("delete from tbl_affiliated_after_school a where a.afterSchool.id = :afterSchoolId")
	void deleteByAfterSchool(Long afterSchoolId);

	@Query("select a from tbl_affiliated_after_school a where a.afterSchool.id = :afterSchoolId and a.student.id = :studentId")
	Optional<AffiliatedAfterSchool> findByAfterSchoolAndStudent(Long afterSchoolId, Long studentId);

	List<AffiliatedAfterSchool> findByStudent(Student student);

	List<AffiliatedAfterSchool> findByAfterSchool(AfterSchool afterSchool);

}
