package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RatingController {
    private List<Rating> ratingList = new ArrayList<>();

    @PostMapping("/ratings")
    public void addRating(@RequestBody AddRatingRequestDto requestDto) {
        // 요청 데이터를 Rating 객체로 변환하여 리스트에 저장
        Rating rating = new Rating(requestDto.getRaterName(), requestDto.getTargetName(), requestDto.getRating());
        ratingList.add(rating);
        System.out.println(rating + " 저장됨");
    }

    @GetMapping("/ratings")
    public List<Rating> getList() {
        return ratingList;
    }
}
