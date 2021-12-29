package io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response;

import lombok.Getter;

@Getter
public class LoginResponse {

    private final String accessToken;
    private final String refreshToken;
    private final String teacherId;
    private final Long locationId;
    private final String locationName;

    public LoginResponse(TokenResponse token, Long locationId, String locationName) {
        this.accessToken = token.getAccessToken();
        this.refreshToken = token.getRefreshToken();
        this.teacherId = token.getTeacherId();
        this.locationId = locationId;
        this.locationName = locationName;
    }

}
