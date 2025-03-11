package org.example.framework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/6/11 16:20
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @GetMapping("/demo.json")
    public String demo1() {
        return "demo.json";
    }
}
