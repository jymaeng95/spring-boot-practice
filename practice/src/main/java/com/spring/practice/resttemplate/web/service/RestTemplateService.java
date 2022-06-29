package com.spring.practice.resttemplate.web.service;

import com.spring.practice.resttemplate.web.dto.CommonSuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestTemplateService {
    private final RestTemplate restTemplate;

    /**
     * GET getForObject, getForEntity
     */
    public void getForEntityTest() {
        String url = "localhost:9300/notice/2";

        //1. getForEntity : URL을 호출하고 데이터를 ResponseEntity<String>으로 받아온다.
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            // logic
            log.info("response : {}", response);
        }
    }

    /**
     * GET getForObject
     */
    public void getForObjectTest() {
        String url = "localhost:9300/notice/2";

        // getForObject : URL을 호출하고 POJO 방식으로 객체 타입으로 받아온다.
        CommonSuccessResponse response = restTemplate.getForObject(url, CommonSuccessResponse.class);

    }
}
