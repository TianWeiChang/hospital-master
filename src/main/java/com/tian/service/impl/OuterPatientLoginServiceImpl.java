package com.tian.service.impl;

import com.tian.config.RedisConfig;
import com.tian.dto.CommonResult;
import com.tian.dto.OuterPatientLoginReq;
import com.tian.dto.OuterPatientRegisterReq;
import com.tian.entity.OuterPatientRegister;
import com.tian.mapper.OuterPatientLoginMapper;
import com.tian.service.OuterPatientLoginService;
import com.tian.utils.CreateRandomCode;
import com.tian.utils.RedisPrefixConstant;
import com.tian.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年10月28日 11:03
 * 外部系统挂号
 */
@Service
public class OuterPatientLoginServiceImpl implements OuterPatientLoginService {

    @Resource
    private OuterPatientLoginMapper outerPatientLoginMapper;
    @Resource
    private RedisConfig redisConfig;

    @Override
    public CommonResult<String> login(OuterPatientLoginReq outerPatientLoginReq) {
        String code = redisConfig.get(RedisPrefixConstant.SEND_CODE_KEY_PREFIX + outerPatientLoginReq.getPhone());
        if (!outerPatientLoginReq.getCode().equals(code)) {
            return CommonResult.failed("登录失败，验证码错误");
        }
        OuterPatientRegister outerPatientRegister = new OuterPatientRegister();
        outerPatientRegister.setPhone(outerPatientRegister.getPhone());
        int flag = outerPatientLoginMapper.insert(outerPatientRegister);
        if (flag == 1) {
            String token = StringUtil.getToken(RedisPrefixConstant.OUTER_LOGIN_KEY_PREFIX);
            redisConfig.add(RedisPrefixConstant.OUTER_LOGIN_KEY_PREFIX + outerPatientLoginReq.getPhone(), token);
            redisConfig.add(token, outerPatientRegister);
            return CommonResult.success(token);
        }
        return CommonResult.failed("登录失败");
    }

    /**
     * 实际场景中  还会套用一个模板，把code放到模板中，然后，用第三方发短信的机构发送短信
     *
     * @param outerPatientLoginReq 手机号、验证码
     * @return 短信验证码
     */
    @Override
    public CommonResult<String> sendCode(OuterPatientLoginReq outerPatientLoginReq) {
        String code = CreateRandomCode.generateCode();
        //验证码 120秒  两分钟有效
        redisConfig.add(RedisPrefixConstant.SEND_CODE_KEY_PREFIX + outerPatientLoginReq.getPhone(), code, 120, TimeUnit.SECONDS);
        return CommonResult.success(code);
    }
}
