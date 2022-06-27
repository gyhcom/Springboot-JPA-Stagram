package com.gyhstagram.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller

public class ImageController {
    @GetMapping({"/","/image/feed"})
    public String feed() {
        log.info("main start");
        return "image/feed";
    }
}
