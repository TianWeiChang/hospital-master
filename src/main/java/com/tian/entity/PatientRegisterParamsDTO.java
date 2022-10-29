package com.tian.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月21日 11:19
 * 挂号请求参数
 */
public class PatientRegisterParamsDTO implements Serializable {

    private Integer id;

    private String patientName;

    private Integer gender;

    private String genderName;

    private String pathogeny;

    private String inspectInstructions;

    private Integer prescriptionPricingId;

    private Integer age;

    private Integer price;

    private String carId;

    private String phone;

    private Integer departmentId;

    private String departmentName;

    private Integer registerTypeId;

    private String registerTypeName;

    private Integer doctorId;

    private String doctorName;

    private Date createTime;

    private String createTimeStr;

    private String operationUser;

    private Integer date;

    public Integer getPrescriptionPricingId() {
        return prescriptionPricingId;
    }

    public void setPrescriptionPricingId(Integer prescriptionPricingId) {
        this.prescriptionPricingId = prescriptionPricingId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getOperationUser() {
        return operationUser;
    }

    public void setOperationUser(String operationUser) {
        this.operationUser = operationUser;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRegisterTypeName() {
        return registerTypeName;
    }

    public void setRegisterTypeName(String registerTypeName) {
        this.registerTypeName = registerTypeName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPathogeny() {
        return pathogeny;
    }

    public void setPathogeny(String pathogeny) {
        this.pathogeny = pathogeny;
    }

    public String getInspectInstructions() {
        return inspectInstructions;
    }

    public void setInspectInstructions(String inspectInstructions) {
        this.inspectInstructions = inspectInstructions;
    }
}
