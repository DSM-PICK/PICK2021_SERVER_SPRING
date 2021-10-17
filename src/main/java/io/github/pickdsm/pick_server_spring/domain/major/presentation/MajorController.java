package io.github.pickdsm.pick_server_spring.domain.major.presentation;

import java.util.List;

import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response.MajorResponse;
import io.github.pickdsm.pick_server_spring.domain.major.service.QueryMajorListService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/major")
@RequiredArgsConstructor
public class MajorController {

	private final QueryMajorListService queryMajorListService;


	@GetMapping("/list")
	public List<MajorResponse> queryMajorList() {
		return queryMajorListService.execute();
	}

}
