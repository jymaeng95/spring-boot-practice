package zayson.java.lab.resttemplate.controller;

import zayson.java.lab.resttemplate.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/resttemplate")
@Slf4j
public class RestTemplateController {
    @GetMapping("/search")
    public ResponseEntity<Person> search() {
        log.info("RestTemplate Get Request");

        Person person = Person.builder().name("zayson")
                .age(28)
                .interest(List.of("Coding", "Soccer", "Develop"))
                .build();

        return ResponseEntity.ok(person);
    }

    @PostMapping("/new/location")
    public ResponseEntity<Void> joinPersonLocation(@RequestBody Person person, UriComponentsBuilder builder) {
        log.info("RestTemplate Post Request");
        log.info("Request Person : {}", person);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/location/{name}").buildAndExpand(person.getName()).toUri());

        log.info("Reosurce Location : {}", headers.getLocation());
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

    @PostMapping("/new")
    public ResponseEntity<Person> joinPerson(@RequestBody Person person, HttpServletRequest servletRequest) {
        log.info("RestTemplate Post Request");
        log.info("Request Person : {}", person);
        log.info("Request Header : {}", servletRequest.getHeader("id"));

        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }

    @DeleteMapping(value = "/{name}/{age}")
    public ResponseEntity<Void> delete(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        log.info("Delete Method Request");
        log.info("Path Name : {}", name);
        log.info("Path age : {}", age);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{name}/{age}")
    public ResponseEntity<Void> put(@PathVariable("name") String name, @PathVariable("age") Integer age,
                                    @RequestBody Person person) {
        log.info("Put Method Request");
        log.info("Path Name : {}", name);
        log.info("Path age : {}", age);
        log.info("Request Body : {}", person);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/timeout")
    public ResponseEntity<Person> timeout() throws InterruptedException {
        log.info("Timeout Test");
        Person person = Person.builder()
                .name("zayson")
                .age(28)
                .interest(List.of("Coding", "Soccer", "Develop"))
                .build();

        // 타임아웃 발생!!
        Thread.sleep(5000);

        return ResponseEntity.ok(person);
    }
}
