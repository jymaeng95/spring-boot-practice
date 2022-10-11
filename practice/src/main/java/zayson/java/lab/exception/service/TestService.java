package zayson.java.lab.exception.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zayson.java.lab.exception.CustomBadRequestException;
import zayson.java.lab.exception.CustomNotFoundException;
import zayson.java.lab.exception.common.ErrorCode;

import java.util.Locale;

@Service
@Slf4j
public class TestService {
    public String toUpperName(String name) {
        log.info("name : {}", name);

        // 길이가 0인 경우 잘못된 요청
        if(name.length() < 1)
            throw new CustomBadRequestException(ErrorCode.BAD_REQUEST);

        // 이름이 zayson과 매칭 되는 경우 없다고 가정
        if(name.equals("zayson"))
            throw new CustomNotFoundException("없는 이름입니다!");

        return name.toUpperCase(Locale.ROOT);
    }
}
