package com.tian.dto;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月28日 10:52
 *
 */
public class OuterPatientRegisterReq   {
    private String token;
    private String patientName;
    private String cardId;
    private Integer gender;
    private Integer age;
    private Integer departmentId;
    private Integer registerTypeId;
    private Integer doctorId;
    private Integer doctorRegisterTimeSlotId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getRegisterTypeId() {
        return registerTypeId;
    }

    public void setRegisterTypeId(Integer registerTypeId) {
        this.registerTypeId = registerTypeId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getDoctorRegisterTimeSlotId() {
        return doctorRegisterTimeSlotId;
    }

    public void setDoctorRegisterTimeSlotId(Integer doctorRegisterTimeSlotId) {
        this.doctorRegisterTimeSlotId = doctorRegisterTimeSlotId;
    }
}
