package com.example.gateway.controller.journal;

import com.example.gateway.client.JournalClient;
import com.example.gateway.dto.journal.JournalResponse;
import com.example.gateway.dto.journal.SaveJournalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class JournalController {
    private final JournalClient journalClient;

    @PostMapping("journals")
    JournalResponse saveOrGet(@RequestBody SaveJournalRequest request) {
        return journalClient.saveOrGetJournal(request);
    }
    @GetMapping("group/{groupId}/journals")
    ResponseEntity<JournalResponse> getByGroupId(@PathVariable("groupId") final Long groupId) {
        return journalClient.getJournalByGroupId(groupId);
    }
}
