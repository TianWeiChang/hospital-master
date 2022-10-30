package com.tian.utils;

import com.tian.entity.DepartmentInfo;
import com.tian.entity.PatientRegister;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月21日 15:43
 */
public class StringUtil {
    public static String[] split(String str) {
        if (isEmpty(str)) {
            return null;
        }
        return str.split(",");
    }

    public static boolean isEmpty(String st) {
        return st == null || st.trim().equals("");
    }

    public static void main(String[] args) {
//        List<PatientRegister> patientRegisterList = new ArrayList<>();
//        PatientRegister patientRegister = new PatientRegister();
//        patientRegister.setPatientId(1);
//        patientRegisterList.add(patientRegister);
//
//        PatientRegister patientRegister1 = new PatientRegister();
//        patientRegister1.setPatientId(1);
//        patientRegisterList.add(patientRegister1);
//        String ids= patientRegisterList.stream().map(item -> String.valueOf(item.getPatientId())).collect(Collectors.joining(","));
//        Map<Integer, String> departmentInfoMap = departmentInfos.stream().collect(Collectors.toMap(DepartmentInfo::getId, DepartmentInfo::getDepartmentName));
//        Map<Long, User> maps = userList.stream().collect(Collectors.toMap(User::getId,Function.identity()));
//        System.out.println(ids);
       /* String[] idss = split(ids);
        System.out.println(idss);*/

    }

    /**
     * 用uuid生成为 token
     */
    public static  String getToken(String pre) {
        String uuid = UUID.randomUUID().toString();
        return pre + uuid;
    }
}
