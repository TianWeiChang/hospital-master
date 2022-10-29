package com.tian.controller;

import com.github.pagehelper.PageInfo;
import com.tian.entity.*;
import com.tian.service.PatientRegisterService;
import com.tian.service.RegisteredTypeService;
import com.tian.utils.ReturnDataUtil;
import com.tian.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月21日 11:11
 * 病人挂号
 */
@Controller
@RequestMapping("/patient/register")
public class PatientRegisterController {
    @Resource
    private PatientRegisterService patientRegisterService;
    @Resource
    private RegisteredTypeService registeredTypeService;

    @RequestMapping("/list")
    public Object list(PatientRegisterParamsDTO patientRegister, Model model, String params, Integer date, HttpServletRequest request) {
        HttpSession session = request.getSession();
        //将数据存储到session中
        session.setAttribute("date", date);
        patientRegister.setPatientName(params);
        patientRegister.setDate(date);
        List<PatientRegisterParamsDTO> listAll = patientRegisterService.list(patientRegister);
        model.addAttribute("report", listAll);
        return "cao/report";
    }


    @RequestMapping("/page")
    @ResponseBody
    public Object page(PatientRegisterParamsDTO patientRegister, String patientName, Integer date, HttpServletRequest request) {
        HttpSession session = request.getSession();
        //将数据存储到session中
        session.setAttribute("date", date);
        patientRegister.setPatientName(StringUtil.isEmpty(patientName) ? null : patientName);
        patientRegister.setDate(date);
        List<PatientRegisterParamsDTO> listAll = patientRegisterService.list(patientRegister);
        PageInfo<PatientRegisterParamsDTO> pageInfo = new PageInfo<>(listAll);
        return ReturnDataUtil.getTableData(pageInfo);
    }


    @RequestMapping("/add")
    @ResponseBody
    public Object add(PatientRegisterParamsDTO patientRegister) {
        int flag =  patientRegisterService.add(patientRegister);
        if (flag == 1) {
            return "添加成功";
        }
        return "添加失败";
    }

    /**
     * 获取价格
     */
    @RequestMapping("/price")
    @ResponseBody
    public Object price(PatientRegisterParamsDTO patientRegister) {
        RegisterTypeInfo registerTypeInfo = new RegisterTypeInfo();
        registerTypeInfo.setId(patientRegister.getRegisterTypeId());
        return registeredTypeService.registeredTypeList(registerTypeInfo).get(0).getPrice();
    }

    /**
     * 获取病因
     */
    @RequestMapping("/pathogeny")
    @ResponseBody
    public String getPatientPathogeny(PatientRegisterParamsDTO registerParamsDTO) {

        PatientRegister patientRegister = patientRegisterService.selectById(registerParamsDTO.getId());
        if (patientRegister == null) {
            return "";
        }
        return patientRegister.getPathogeny();
    }

    /**
     * 添加病因
     */
    @RequestMapping("/add/pathogeny")
    @ResponseBody
    public int addPatientPathogeny(PatientRegisterParamsDTO registerParamsDTO, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return patientRegisterService.addPatientPathogeny(registerParamsDTO, user);
    }

    /**
     * 获取 项目检查说明
     */
    @RequestMapping("/inspectInstructions")
    @ResponseBody
    public String getInspectInstructions(PatientRegisterParamsDTO registerParamsDTO) {
        PatientRegister patientRegister = patientRegisterService.selectById(registerParamsDTO.getId());
        if (patientRegister == null) {
            return "";
        }
        return patientRegister.getInspectInstructions();
    }

    /**
     * 添加 项目检查说明
     */
    @RequestMapping("/add/inspectInstructions")
    @ResponseBody
    public Object addInspectInstructions(PatientRegisterParamsDTO registerParamsDTO, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return patientRegisterService.addInspectInstructions(registerParamsDTO, user);
    }
}
