package com.example.gateway.controller.user;

import com.example.gateway.client.UserClient;
import com.example.gateway.dto.knowledge_test_type.KnowledgeTestTypeResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class KnowledgeTestType {
    private final UserClient userClient;

    @GetMapping("/test-type")
    List<KnowledgeTestTypeResponse> getKnowledgeTestTypeList() {
        return userClient.getKnowledgeTestTypeList();
    }
}
