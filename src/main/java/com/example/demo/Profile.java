package com.example.demo;

public class Profile {

    private String name;
    private String studentId;
    private String gender;
    private String description;

    // 생성자
    public Profile(String name, String studentId, String gender, String description) {
        this.name = name;
        this.studentId = studentId;
        this.gender = gender;
        this.description = description;
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString() 메서드
    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
