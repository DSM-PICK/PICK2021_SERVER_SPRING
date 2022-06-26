package io.github.pickdsm.pick_server_spring.domain.location.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int floor;

	private int priority;

	@Column(length = 10)
	private String name;

	@Builder
	public Location(int floor, int priority, String name) {
		this.floor = floor;
		this.priority = priority;
		this.name = name;
	}

	public void updateLocation(String name, int floor, int priority) {
		this.name = name;
		this.floor = floor;
		this.priority = priority;
	}

}
