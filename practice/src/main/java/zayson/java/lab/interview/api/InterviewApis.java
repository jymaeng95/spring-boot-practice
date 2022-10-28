package zayson.java.lab.interview.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zayson.java.lab.interview.dto.PersonRequest;

@RestController
@Slf4j
@RequestMapping("/api/interview")
public class InterviewApis {
    @PostMapping
    public ResponseEntity<String> saveInterview(@RequestBody PersonRequest personRequest) {
        log.info("person = {}",personRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }
}
