package com.zzw.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzhiwen
 */
@Slf4j
@RestController
public class ServerController {
    @GetMapping("/msg")
    public String msg() {
        log.error("在这里");
        return "this is product msg";
    }

}
