package io.github.pickdsm.pick_server_spring.domain.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.major.domain.Major;
import io.github.pickdsm.pick_server_spring.domain.student.exception.StudentIsHeadException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 5)
	private String name;

	@Column(columnDefinition = "CHAR(4)", nullable = false)
	private String gcn;

	@Column(length = 20)
	private String state;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "major_id")
	private Major major;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private Location location;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "head")
	private Major HeadMajor;

	@Builder
	public Student(String name, String gcn, String state, Major major, Location location) {
		this.name = name;
		this.gcn = gcn;
		this.state = state;
		this.major = major;
		this.location = location;
	}

	public void changeMajor(Major major) {
		if(HeadMajor != null)
			throw new StudentIsHeadException();
		this.major = major;
	}

	public void setMajorNull() {
		this.major = null;
	}

}
