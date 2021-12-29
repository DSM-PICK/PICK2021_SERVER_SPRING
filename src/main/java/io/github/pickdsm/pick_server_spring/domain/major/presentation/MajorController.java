package io.github.pickdsm.pick_server_spring.domain.major.presentation;

import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request.*;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response.MajorInformationResponse;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response.MajorResponse;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response.PostMajorResponse;
import io.github.pickdsm.pick_server_spring.domain.major.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
	private final ChangeMajorNameService changeMajorNameService;
	private final ChangeMajorLocationService changeMajorLocationService;

	@GetMapping("/list")
	public List<MajorResponse> queryMajorList() {
		return queryMajorListService.execute();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PostMajorResponse createMajor(@RequestBody @Valid CreateMajorRequest request) {
		return createMajorService.execute(request);
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

	@PatchMapping("/{major_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changeMajorName(@PathVariable("major_id") Long majorId,
			@RequestBody @Valid ChangeNameRequest request) {
		changeMajorNameService.execute(majorId, request);
	}

	@PatchMapping("/{major_id}/location")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changeMajorLocation(@PathVariable("major_id") Long majorId,
			@RequestBody @Valid ChangeLocationRequest request) {
		changeMajorLocationService.execute(majorId, request);
	}

}
