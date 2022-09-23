package zayson.java.lab.webclient.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import zayson.java.lab.webclient.dto.ApiResult;
import zayson.java.lab.webclient.dto.OttDto;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/web-client")
@Slf4j
public class WebClientApiController {
    @GetMapping("/get")
    public ApiResult getApiTest() throws JsonProcessingException {
        ApiResult<Map<String, List<OttDto>>> dtos = WebClient.builder()
                .baseUrl("http://129.154.222.27:8800")
                .filter(
                        (req, next) -> next.exchange(
                                ClientRequest.from(req)
                                        .header("headerTest", "zayson")
                                        .build()
                        )
                ).build()
                .get()
                .uri("/nbbang-user/ott-interest/list")
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(
                        clientResponse -> {
                            if (clientResponse.statusCode() == HttpStatus.OK) {
                                return clientResponse.bodyToMono(new ParameterizedTypeReference<ApiResult<Map<String, List<OttDto>>>>() {
                                });
                            } else {
                                return clientResponse.createException().flatMap(Mono::error);
                            }
                        }
                ).block();

        Map<String, List<OttDto>> data = dtos.getData();
        log.info("status : {}", dtos.getStatus());
        data.get("ottView").forEach(ottDto -> log.info(ottDto.toString()));
        log.info("message : {}", dtos.getMessage());

        return dtos;
    }
}
