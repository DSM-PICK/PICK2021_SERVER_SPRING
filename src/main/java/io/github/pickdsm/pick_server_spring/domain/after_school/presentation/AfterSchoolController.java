package io.github.pickdsm.pick_server_spring.domain.after_school.presentation;

import java.util.List;

import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.response.AfterSchoolResponse;
import io.github.pickdsm.pick_server_spring.domain.after_school.service.QueryAfterSchoolService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/after-school")
@RequiredArgsConstructor
public class AfterSchoolController {

	private final QueryAfterSchoolService queryAfterSchoolService;

	@GetMapping("/list")
	public List<AfterSchoolResponse> queryAfterSchool() {
		return queryAfterSchoolService.execute();
	}

}
