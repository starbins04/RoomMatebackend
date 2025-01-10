package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {

    private List<Login> loginList = new ArrayList<>();

    // 회원가입 처리
    @PostMapping("/login")
    public String addLogin(@RequestBody AddLoginRequestDto requestDto) {
        // 이미 등록된 ID가 있는지 확인
        for (Login login : loginList) {
            if (login.getId().equals(requestDto.getId())) {
                return "ID already exists. Please choose a different ID.";
            }
        }

        // 새로운 로그인 정보 추가
        Login login = new Login(requestDto.getId(), requestDto.getPassword());
        loginList.add(login);
        System.out.println(loginList + " 저장됨");
        return "회원 가입이 완료되었습니다.";
    }

    // 로그인 처리
    @PostMapping("/login/authenticate")
    public String authenticateLogin(@RequestBody AddLoginRequestDto requestDto) {
        // ID와 비밀번호 검증
        for (Login login : loginList) {
            if (login.getId().equals(requestDto.getId())) {
                if (login.getPassword().equals(requestDto.getPassword())) {
                    return "로그인이 완료되었습니다.";
                } else {
                    return "비밀번호가 틀렸습니다.";
                }
            }
        }
        return "회원 가입을 먼저 진행해주세요.";
    }

    // 로그인 목록 조회 (디버깅용)
    @GetMapping("/login")
    public List<Login> getList() {
        System.out.println(loginList + " 반환함");
        return loginList;
    }
}
