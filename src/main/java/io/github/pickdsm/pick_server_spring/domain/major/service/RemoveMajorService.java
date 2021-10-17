package io.github.pickdsm.pick_server_spring.domain.major.service;

import javax.transaction.Transactional;

import io.github.pickdsm.pick_server_spring.domain.major.domain.Major;
import io.github.pickdsm.pick_server_spring.domain.major.domain.repository.MajorRepository;
import io.github.pickdsm.pick_server_spring.domain.major.exception.MajorNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import io.github.pickdsm.pick_server_spring.domain.student.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveMajorService {

	private final MajorRepository majorRepository;
	private final StudentRepository studentRepository;

	@Transactional
	public void execute(Long majorId) {
		Major major = majorRepository.findById(majorId)
				.orElseThrow(MajorNotFoundException::new);

		studentRepository.findByMajor(major.getId())
				.forEach(Student::setMajorNull);

		majorRepository.deleteById(majorId);
	}

}
