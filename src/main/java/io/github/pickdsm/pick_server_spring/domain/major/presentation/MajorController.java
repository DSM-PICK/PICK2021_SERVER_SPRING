package io.github.pickdsm.pick_server_spring.domain.major.presentation;

import java.util.List;

import javax.validation.Valid;

import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request.CreateMajorRequest;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response.MajorResponse;
import io.github.pickdsm.pick_server_spring.domain.major.service.CreateMajorService;
import io.github.pickdsm.pick_server_spring.domain.major.service.QueryMajorListService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/major")
@RequiredArgsConstructor
public class MajorController {

	private final QueryMajorListService queryMajorListService;
	private final CreateMajorService createMajorService;


	@GetMapping("/list")
	public List<MajorResponse> queryMajorList() {
		return queryMajorListService.execute();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createMajor(@RequestBody @Valid CreateMajorRequest request) {
		createMajorService.execute(request);
	}

}
