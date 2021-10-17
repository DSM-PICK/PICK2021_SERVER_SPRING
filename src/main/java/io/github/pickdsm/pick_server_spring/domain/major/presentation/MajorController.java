package io.github.pickdsm.pick_server_spring.domain.major.presentation;

import java.util.List;

import javax.validation.Valid;

import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request.AddMemberRequest;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request.ChangeHeadRequest;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request.CreateMajorRequest;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request.RemoveMemberRequest;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response.MajorInformationResponse;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response.MajorResponse;
import io.github.pickdsm.pick_server_spring.domain.major.service.AddMemberService;
import io.github.pickdsm.pick_server_spring.domain.major.service.ChangeHeadService;
import io.github.pickdsm.pick_server_spring.domain.major.service.CreateMajorService;
import io.github.pickdsm.pick_server_spring.domain.major.service.QueryMajorInformationService;
import io.github.pickdsm.pick_server_spring.domain.major.service.QueryMajorListService;
import io.github.pickdsm.pick_server_spring.domain.major.service.RemoveMajorService;
import io.github.pickdsm.pick_server_spring.domain.major.service.RemoveMemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	private final QueryMajorInformationService queryMajorInformationService;
	private final AddMemberService addMemberService;
	private final RemoveMemberService removeMemberService;
	private final ChangeHeadService changeHeadService;
	private final RemoveMajorService removeMajorService;

	@GetMapping("/list")
	public List<MajorResponse> queryMajorList() {
		return queryMajorListService.execute();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createMajor(@RequestBody @Valid CreateMajorRequest request) {
		createMajorService.execute(request);
	}

	@GetMapping("/{major_id}")
	public MajorInformationResponse queryMajorInformation(@PathVariable("major_id") Long majorId) {
		return queryMajorInformationService.execute(majorId);
	}

	@PostMapping("/member")
	@ResponseStatus(HttpStatus.CREATED)
	public void addMember(@RequestBody @Valid AddMemberRequest request) {
		addMemberService.execute(request);
	}

	@DeleteMapping("/member")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeMember(@RequestBody @Valid RemoveMemberRequest request) {
		removeMemberService.execute(request);
	}

	@PatchMapping("/head")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changeHead(@RequestBody @Valid ChangeHeadRequest request) {
		changeHeadService.execute(request);
	}

	@DeleteMapping("/{major_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeMajor(@PathVariable("major_id") Long majorId) {
		removeMajorService.execute(majorId);
	}

}
