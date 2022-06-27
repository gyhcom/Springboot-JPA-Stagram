package com.gyhstagram.web;

import com.gyhstagram.Script;
import com.gyhstagram.web.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gyhstagram.web.dto.UserJoinReqDto;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/loginForm")
    public String loginForm
            (@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "exception", required = false) String exception, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        log.info("loginForm view resolve");

        return "/auth/loginForm";
    }

    @GetMapping("/auth/joinForm")
    public String joinForm() {

        return "auth/joinForm";
    }

    @PostMapping("/auth/join")
    public @ResponseBody String join(UserJoinReqDto userJoinReqDto) {
        authService.joinMember(userJoinReqDto.toEntity());
        return Script.href("성공", "/auth/loginForm");
    }
}
