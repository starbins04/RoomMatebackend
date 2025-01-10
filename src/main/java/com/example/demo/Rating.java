package com.example.demo;

public class Rating {
    private String raterName;      // 평가자 이름
    private String targetName;     // 평가 대상자 이름
    private float rating;          // 별점 (1-5)
    private long ratingTime;       // 평가 시간

    public Rating(String raterName, String targetName, float rating) {
        this.raterName = raterName;
        this.targetName = targetName;
        this.rating = rating;
        this.ratingTime = System.currentTimeMillis();
    }

    // Getters and Setters
    public String getRaterName() {
        return raterName;
    }
    public void setRaterName(String raterName) {
        this.raterName = raterName;
    }

    public String getTargetName() {
        return targetName;
    }
    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public float getRating() {
        return rating;
    }
    public void setRating(Float rating) {
        this.rating = rating;
    }

    public long getRatingTime() {
        return ratingTime;
    }
    public void setRatingTime(long ratingTime) {
        this.ratingTime = ratingTime;
    }
}

