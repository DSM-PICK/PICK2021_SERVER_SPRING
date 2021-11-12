package io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.pickdsm.pick_server_spring.domain.schedule.exception.InvalidDateException;
import lombok.Getter;

@Getter
public class QueryDirectorsRequest {

	@JsonProperty("year")
	private final int year;

	@JsonProperty("month")
	private final int month;

	public QueryDirectorsRequest(int year, int month) {
		if(month < 1 || month > 12)
			throw InvalidDateException.EXCEPTION;
		this.year = year;
		this.month = month;
	}

}
