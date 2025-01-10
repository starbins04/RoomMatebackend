package com.example.demo;

public class AddProfileRequestDto {
    private String name;
    private String studentId;
    private String gender;
    private String description;

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

    @Override
    public String toString() {
        return "AddProfileRequestDto{" +
                "name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
