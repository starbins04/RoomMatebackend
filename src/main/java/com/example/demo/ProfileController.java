package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProfileController {

    private List<Profile> profileList = new ArrayList<>();

    @PostMapping("/profiles")
    public void addProfile(@RequestBody AddProfileRequestDto requestDto) {
        // 요청 데이터를 Profile 객체로 변환하여 리스트에 저장
        Profile profile = new Profile(requestDto.getName(), requestDto.getStudentId(),
                requestDto.getGender(), requestDto.getDescription(), requestDto.getBedTime());
        profileList.add(profile);
        System.out.println(profileList + " 저장됨");
    }

    @GetMapping("/profiles")
    public List<Profile> getList() {
        System.out.println(profileList + " 반환함");
        return profileList;
    }


}
