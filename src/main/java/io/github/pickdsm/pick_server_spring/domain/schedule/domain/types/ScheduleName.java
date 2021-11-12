package io.github.pickdsm.pick_server_spring.domain.schedule.domain.types;

public enum ScheduleName {
	SELF_STUDY, MAJOR, AFTER_SCHOOL;

	@Override
	public String toString() {
		switch (this) {
			case SELF_STUDY:
				return "자습";
			case MAJOR:
				return "전공동아리";
			default:
				return "방과후";
		}
	}
}
