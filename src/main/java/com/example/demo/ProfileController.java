package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProfileController {

    private List<Profile> profileList = new ArrayList<>();

    @PostMapping("/profiles")
    public void addProfile(@RequestBody AddProfileRequestDto requestDto) {
        // 요청 데이터를 Profile 객체로 변환
        Profile profile = new Profile(requestDto.getName(), requestDto.getStudentId(),
                requestDto.getGender(), requestDto.getDescription(), requestDto.getBedTime());

        // 중복된 hashKey가 있는지 확인하여 기존 프로필 삭제
        profileList.removeIf(item -> item.getHashKey().equals(profile.getHashKey()));
        System.out.println("삭제됨");

        // 새 프로필 추가
        profileList.add(profile);
        System.out.println(profileList + " 저장됨");
    }

    @GetMapping("/profiles")
    public List<Profile> getList() {
        System.out.println(profileList + " 반환함");
        return profileList;
    }

    @GetMapping("/profiles/{studentId}")
    public Profile getProfile(@PathVariable("studentId") String studentId) {
        Profile profile = null;
        for (var item : profileList) {
            if (item.getStudentId().equals(studentId)) {
                profile = item;
            }
        }
        return profile;
    }
}
