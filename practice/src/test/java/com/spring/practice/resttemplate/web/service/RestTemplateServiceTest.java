package com.spring.practice.resttemplate.web.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.practice.resttemplate.web.dto.Person;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class RestTemplateServiceTest {
    private Logger log;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        this.restTemplate = new RestTemplate();
        this.log = LoggerFactory.getLogger(RestTemplateServiceTest.class);
        this.objectMapper = new ObjectMapper();
    }

    @Test
    void getForEntity() throws JsonProcessingException {
        // given
        String url = "http://localhost:8080/resttemplate/search";

        // when
        //1. getForEntity : URL을 호출하고 데이터를 ResponseEntity<String>으로 받아온다.
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        log.info("response : {}", response);

        JsonNode person = objectMapper.readTree(response.getBody());
        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        assertThat(person.path("name").asText()).isEqualTo("zayson");
        assertThat(person.path("age").asInt()).isEqualTo(28);
        assertThat(person.path("interest").size()).isEqualTo(3);
    }

    @Test
    void getForObject() {
        String url = "http://localhost:8080/resttemplate/search";

        // 2. getForObject : URL을 호출하고 데이터를 Custom Object 타입으로 받아온다.
        Person response = restTemplate.getForObject(url, Person.class);

        log.info("response : {}", response);

        assertThat(response).isNotNull();
        assertThat(response.getName()).isEqualTo("zayson");
        assertThat(response.getAge()).isEqualTo(28);
        assertThat(response.getInterest().size()).isEqualTo(3);
    }

    @Test
    void postForLocation() {
        // given
        String url = "http://localhost:8080/resttemplate/new/location";
        Person person = createPerson();

        // when
        // 3. postForLocation : 리소스를 생성하고 생성된 리소스의 URI 위치를 반환한다.
        URI location = restTemplate.postForLocation(url, person);
        log.info("Resoure Location : {}", location);

        // then
        assertThat(location).isNotNull();
    }

    @Test
    void postForEntity() {
        // given
        String url = "http://localhost:8080/resttemplate/new";
        Person person = createPerson();

        // Http 헤더 설정
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("id", "guest");

        HttpEntity<Person> request = new HttpEntity<>(person, httpHeaders);

        // when
        // 4. postForEntity : 리소스를 생성하고 ResponseEntity타입으로 데이터를 받는다. (헤더 사용)
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        log.info("Created Response : {}", response);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void postForObject() {
        // given
        String url = "http://localhost:8080/resttemplate/new";
        Person person = createPerson();

        // Http 헤더 설정
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("id", "guest");

        HttpEntity<Person> request = new HttpEntity<>(person, httpHeaders);

        // when
        // 4. postForObject : 리소스를 생성하고 지정한 객체 타입으로 데이터를 받는다. (헤더 사용)
        Person createdPerson = restTemplate.postForObject(url, request, Person.class);
        log.info("Created Response : {}", createdPerson.toString());

        // then
        assertThat(createdPerson).isNotNull();
        assertThat(createdPerson.getName()).isEqualTo("zayson");
        assertThat(createdPerson.getAge()).isEqualTo(28);
        assertThat(createdPerson.getInterest().size()).isEqualTo(3);
    }

    @Test
    void delete() {
        // given
        String url = "http://localhost:8080/resttemplate/{name}/{age}";
        Map<String, String> params = new HashMap<>();
        params.put("name", "zayson");
        params.put("age", "28");

        // when
        // 6. delete : DELETE 메서드를 이용해 해당 URL에 요청한다.
        restTemplate.delete(url, params);
    }

    @Test
    void put() {
        // given
        String url = "http://localhost:8080/resttemplate/{name}/{age}";
        Person person = createPerson();

        Map<String, String> params = new HashMap<>();
        params.put("name", "zayson");
        params.put("age", "28");

        // when
        // 7. put : PUT 메소드를 요청한다.
        restTemplate.put(url, person, params);
    }

    @Test
    void headForHeaders() {
        // given
        String url = "http://localhost:8080/resttemplate/search";

        // when
        // 8. headForHeaders : HEAD 메서드를 이용해 해당 URL이 포함한 헤더 정보를 반환한다.
        HttpHeaders httpHeaders = restTemplate.headForHeaders(url);
        log.info("Headers : {}", httpHeaders);

        // then
        assertThat(httpHeaders.getContentType()).isNotNull();
        assertThat(httpHeaders.getContentType().includes(MediaType.APPLICATION_JSON)).isTrue();
    }

    @Test
    void exchange_GET() {
        // given
        String url = "http://localhost:8080/resttemplate/search";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> reqeust = new HttpEntity<>(headers);

        // when
        // 9. exchange : 모든 HTTP 메서드로 요청하는 것이 가능하다. (GET 방식, String 타입으로 받기)
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, reqeust, String.class);
        log.info("response : {}", response);
        log.info("statusCode : {}", response.getStatusCode());

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void exchange_POST() {
        // given
        String url = "http://localhost:8080/resttemplate/new";
        Person person = createPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Person> request = new HttpEntity<>(person, headers);

        // when
        // POST 방식 객체 타입으로 반환 받기
        ResponseEntity<Person> response = restTemplate.exchange(url, HttpMethod.POST, request, Person.class);
        log.info("response : {}", response);
        log.info("statusCode : {}", response.getStatusCode());

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void optionsForAllow() {
        // given
        String url = "http://localhost:8080/resttemplate/{name}/{age}";
        Map<String, String> params = new HashMap<>();
        params.put("name", "zayson");
        params.put("age", "28");

        // when
        // 11. OPTIONS OPTIONS 메서드를 이용해 URL이 지원하는 HTTP METHOD를 반환받는다.
        Set<HttpMethod> httpMethods = restTemplate.optionsForAllow(url, params);
        log.info("response : {}", httpMethods);

        // then
        assertThat(httpMethods.containsAll(List.of(HttpMethod.PUT, HttpMethod.DELETE))).isTrue();
    }

    @Test
    void exectue() throws JsonProcessingException {
        // given
        String url = "http://localhost:8080/resttemplate/search";

        // Request Callback
        RequestCallback requestCallback = request -> {
            request.getHeaders().set("id", "manager");
            log.info("Request Callback : {}", request.getHeaders());
        };

        // Response Callback
        ResponseExtractor<Person> responseExtractor = response -> {
            Person person = objectMapper.readValue(response.getBody(), Person.class);

            log.info("Status Code : {}",response.getStatusCode());
            log.info("Response Body : {}", person.toString());

            return person;
        };

        // when
        // 11. execute : 모든 HTTP 메서드를 사용할 수 있고, request Callback과 Response Extractor를 이용해 요청 후 로직과 응답 후 로직을 사용자가 컨트롤 할 수 있다.
        Person person = restTemplate.execute(url, HttpMethod.GET, requestCallback, responseExtractor);

        // then
        assertThat(person).isNotNull();
        assertThat(person.getName()).isEqualTo("zayson");
        assertThat(person.getAge()).isEqualTo(28);
        assertThat(person.getInterest().size()).isEqualTo(3);
    }

    @Test
    void timeout() {
        // given
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        String url = "http://localhost:8080/resttemplate/timeout";

        // then
        assertThrows(ResourceAccessException.class, () -> restTemplate.getForObject(url, String.class));
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 1000;

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .setSocketTimeout(timeout)
                .build();
        CloseableHttpClient client = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(config)
                .build();
        return new HttpComponentsClientHttpRequestFactory(client);
    }

    private Person createPerson() {
        return Person.builder().name("zayson")
                .age(28)
                .interest(List.of("Coding", "Soccer", "Develop"))
                .build();
    }
}