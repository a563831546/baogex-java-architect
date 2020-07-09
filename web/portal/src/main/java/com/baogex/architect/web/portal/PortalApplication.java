package com.baogex.architect.web.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 门户网站Starter
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-09
 */
@SpringBootApplication
@RestController
public class PortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class);
    }

    @GetMapping("/")
    public String init() {
        return "init repository done.<br/>Please move to  <a href='https://github.com/a563831546/baogex-java-architect'>https://github.com/a563831546/baogex-java-architect</a> ";
    }
}
