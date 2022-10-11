package zayson.java.lab.exception.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import zayson.java.lab.exception.common.ApiResult;
import zayson.java.lab.exception.service.TestService;

@RestController
@RequiredArgsConstructor
public class ExceptionController {
    private final TestService testService;

    @GetMapping("/api/search/{name}")
    public ApiResult<String> search(@PathVariable("name") String name) {
        return ApiResult.success(testService.toUpperName(name));
    }

}
