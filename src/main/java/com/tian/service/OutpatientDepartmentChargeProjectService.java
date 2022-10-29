package com.tian.service;

import com.tian.entity.OutpatientDepartmentChargeProject;
import com.tian.entity.User;

import java.util.List;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月25日 17:25
 */
public interface OutpatientDepartmentChargeProjectService {
    List<OutpatientDepartmentChargeProject> list(OutpatientDepartmentChargeProject outpatientDepartmentChargeProject);

    String add(OutpatientDepartmentChargeProject outpatientDepartmentChargeProject, User user);
}
