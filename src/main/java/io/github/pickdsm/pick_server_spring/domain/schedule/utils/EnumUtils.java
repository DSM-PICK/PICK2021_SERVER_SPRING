package io.github.pickdsm.pick_server_spring.domain.schedule.utils;

import io.github.pickdsm.pick_server_spring.domain.schedule.domain.types.ScheduleName;
import io.github.pickdsm.pick_server_spring.global.exception.InvalidEnumValueException;

public class EnumUtils {

	public static ScheduleName convertToScheduleName(String value) {
		try {
			return ScheduleName.valueOf(value);
		} catch (IllegalArgumentException e) {
			throw new InvalidEnumValueException();
		}
	}

}
