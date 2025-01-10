package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {

    private List<Login> loginList = new ArrayList<>();

    // 회원가입 처리
    @PostMapping("/login")
    public Integer addLogin(@RequestBody AddLoginRequestDto requestDto) {
        // 이미 등록된 ID가 있는지 확인
        for (Login login : loginList) {
            if (login.getId().equals(requestDto.getId())) {
                if (login.getPassword().equals(requestDto.getPassword())) {
                    return 1; // 로그인 성공
                }
            }
        }

        // 새로운 로그인 정보 추가
        Login login = new Login(requestDto.getId(), requestDto.getPassword());
        loginList.add(login);
        System.out.println(loginList + " 저장됨");
        return 0;
    }



    // 로그인 목록 조회 (디버깅용)
    @GetMapping("/login")
    public List<Login> getList() {
        System.out.println(loginList + " 반환함");
        return loginList;
    }
}
