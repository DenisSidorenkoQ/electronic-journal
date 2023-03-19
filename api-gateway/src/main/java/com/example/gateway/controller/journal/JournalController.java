package com.example.gateway.controller.journal;

import com.example.gateway.client.JournalClient;
import com.example.gateway.dto.journal.JournalResponse;
import com.example.gateway.dto.journal.SaveJournalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@EnableMethodSecurity
public class JournalController {
    private final JournalClient journalClient;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("journals")
    JournalResponse saveOrGet(@RequestBody SaveJournalRequest request) {
        return journalClient.saveOrGetJournal(request);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("group/{groupId}/journals")
    ResponseEntity<JournalResponse> getByGroupId(@PathVariable("groupId") final Long groupId) {
        return journalClient.getJournalByGroupId(groupId);
    }
}
