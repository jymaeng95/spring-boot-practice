package zayson.java.lab.interview.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import zayson.java.lab.interview.dto.PersonRequest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class InterviewApisTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void not_empty_request_body() throws Exception {
        PersonRequest personRequest = new PersonRequest(28, "zayson");
        ObjectMapper mapper = new ObjectMapper();
        MockHttpServletResponse response = mvc.perform(
                MockMvcRequestBuilders
                        .post("/api/interview")
                        .content(mapper.writeValueAsString(personRequest))
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn().getResponse();
    }

    @Test
    void empty_request_body() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        MockHttpServletResponse response = mvc.perform(
                MockMvcRequestBuilders
                        .post("/api/interview")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andReturn().getResponse();
    }
}