package com.example.journal.controller;

import com.example.journal.facade.SubjectFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
public class SubjectControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SubjectFacade subjectFacade;

    @Test
    void shouldReturnSubjects() throws Exception {
        var requestBuilder = MockMvcRequestBuilders.get("/api/v1/subjects");

        this.mockMvc.perform(requestBuilder)
                .andExpectAll(
                        status().isOk()
                );
    }
}
