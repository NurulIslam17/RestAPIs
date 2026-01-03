package com.nurul.RestAPIs.dto;

public class CourseRequestDto {

    private String title;
    private String code;
    private int credit;
    private int price;
    private int discountPercentage;
    private String duration;
    private Long departmentId;
    private Long teacherId;

    public CourseRequestDto(String title, String code, int credit, int price, int discountPercentage, String duration, Long departmentId, Long teacherId) {
        this.title = title;
        this.code = code;
        this.credit = credit;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.duration = duration;
        this.departmentId = departmentId;
        this.teacherId = teacherId;
    }

    public CourseRequestDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "CourseRequestDto{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", credit=" + credit +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", duration='" + duration + '\'' +
                ", departmentId=" + departmentId +
                ", teacherId=" + teacherId +
                '}';
    }
}
