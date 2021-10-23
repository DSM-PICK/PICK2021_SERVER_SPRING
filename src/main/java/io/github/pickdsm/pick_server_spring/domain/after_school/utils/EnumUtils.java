package io.github.pickdsm.pick_server_spring.domain.after_school.utils;

import io.github.pickdsm.pick_server_spring.domain.after_school.domain.types.Day;
import io.github.pickdsm.pick_server_spring.global.exception.InvalidEnumValueException;

public class EnumUtils {

	public static Day convertToDay(String day) {
		try {
			return Day.valueOf(day);
		} catch (IllegalArgumentException e) {
			throw InvalidEnumValueException.EXCEPTION;
		}
	}

}
