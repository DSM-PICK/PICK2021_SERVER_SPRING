package io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MajorInformationResponse {

	private final String majorName;
	private final int count;
	private final String headName;
	private final String teacherName;
	private final String locationName;
	private final List<Member> members;

	@Getter
	@AllArgsConstructor
	public static class Member {
		private final Long studentId;
		private final String studentName;
		private final String gcn;
	}

}
