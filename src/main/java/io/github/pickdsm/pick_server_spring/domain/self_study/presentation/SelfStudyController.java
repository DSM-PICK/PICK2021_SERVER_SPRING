package io.github.pickdsm.pick_server_spring.domain.self_study.presentation;

import io.github.pickdsm.pick_server_spring.domain.self_study.presentation.dto.response.QueryClassResponse;
import io.github.pickdsm.pick_server_spring.domain.self_study.service.QueryClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/self-study")
@RestController
public class SelfStudyController {

    private final QueryClassService queryClassService;

    @GetMapping
    public List<QueryClassResponse> queryClass() {
        return queryClassService.queryClass();
    }


}
