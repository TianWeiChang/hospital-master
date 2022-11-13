package com.tian.controller.outer;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tian.config.MyDefaultAlipayClient;
import com.tian.dto.CommonResult;
import com.tian.enums.ResultCode;
import com.tian.service.OuterPatientRegisterService;
import com.tian.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年11月12日 07:43
 * 支付宝API https://opendocs.alipay.com/open/194/103296?ref=api
 * <p>
 * 支付宝支付
 */
@Slf4j
@Controller
@RequestMapping("/out/pay")
public class PayController {


    @Resource
    private OuterPatientRegisterService outerPatientRegisterService;

    /**
     * 根据挂号单id发起支付
     * 1、根据挂号单id查询挂号单费用
     * 2、tradeNo = "REGISTER"+id
     * 3、在回调的时候，把这个"REGISTER"替换成空 就变成id
     * 4、再根据这个id去更新挂号单支付状态
     */
    /**
     * 创建支付宝 支付二维码
     */
    @GetMapping("/pre/create")
    public void preCreateOrder(Integer id, HttpServletResponse response) throws Exception {
        CommonResult<String> result = outerPatientRegisterService.preCreateOrder(id);
        if (ResultCode.SUCCESS.getCode() != result.getCode()) {
            log.error(result.getMessage());
            // TODO: 2022/11/13 跳转到统一的一个错误页面去
            return;
        }
        String qrCode = result.getData();
        try {
            // 生成二维码配置
            Map<EncodeHintType, Object> hints = new HashMap<>();
            // 设置纠错等级
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            // 编码类型
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            BitMatrix bitMatrix = new MultiFormatWriter().encode(qrCode, BarcodeFormat.QR_CODE, 400, 400, hints);
            OutputStream outputStream = response.getOutputStream();

            MatrixToImageWriter.writeToStream(bitMatrix, "png", outputStream);

        } catch (Exception e) {
            log.error("获取支付宝支付二维码，生成二维码失败", e);
        }
    }

    /**
     * 支付宝支付后  支付回调接口
     */
    @RequestMapping("/callback")
    public void callback(HttpServletRequest request) {
        String tradeStatus = request.getParameter("trade_status");
        //trade_status_sync
        String notifyType = request.getParameter("notify_type");
        String tradeNo = request.getParameter("out_trade_no");
        // TODO: 2022/11/13 真实环境这里需要验签哈 根据 sign_type和sign
        if (StringUtil.isEmpty(tradeStatus) || StringUtil.isEmpty(tradeNo)) {
            log.error("支付宝回调 参数为空");
        }
        //判断状态是否完成
        if ("TRADE_SUCCESS".equals(tradeStatus)) {
            // TODO 支付成功 修改订单状态
            //notify success trade_status=TRADE_SUCCESS out_trade_no=1668263409801
            outerPatientRegisterService.payNotify(tradeNo, tradeStatus);
            log.info("notify success trade_status={} out_trade_no={}", tradeStatus, tradeNo);
        } else {
            log.error("notify failed trade_status={} out_trade_no={}", tradeStatus, tradeNo);
        }
    }
}
