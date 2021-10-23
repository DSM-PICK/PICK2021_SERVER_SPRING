package io.github.pickdsm.pick_server_spring.domain.after_school.service;

import javax.transaction.Transactional;

import io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.domain.repository.AffiliatedAfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository.AfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.exception.AfterSchoolNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveAfterSchoolService {

	private final AfterSchoolRepository afterSchoolRepository;
	private final AffiliatedAfterSchoolRepository affiliatedAfterSchoolRepository;

	@Transactional
	public void execute(Long afterSchoolId) {
		if(!afterSchoolRepository.existsById(afterSchoolId))
			throw AfterSchoolNotFoundException.EXCEPTION;

		affiliatedAfterSchoolRepository.deleteByAfterSchool(afterSchoolId);
		afterSchoolRepository.deleteById(afterSchoolId);
	}

}
