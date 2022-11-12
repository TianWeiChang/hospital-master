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
 * 支付宝支付
 */
@Slf4j
@Controller
@RequestMapping("/out/pay")
public class PayController {

    @Resource
    private AlipayClient alipayClient;
    @Resource
    private MyDefaultAlipayClient myDefaultAlipayClient;

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
    public void wxPay(Double money, String body, Integer uid, HttpServletResponse response) throws Exception {
        // TODO: 2022/11/12 待替换
        String tradeNo = String.valueOf(System.currentTimeMillis());
        log.info("订单号：{}", tradeNo);

        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        JSONObject params = new JSONObject();
        params.put("out_trade_no", tradeNo);
        params.put("total_amount", "0.01");
        params.put("subject", "备注");
        params.put("body", "详情");
        params.put("store_id", "NJ_2031");
        request.setBizContent(params.toString());
        request.setNotifyUrl(myDefaultAlipayClient.getNotifyUrl());

        AlipayTradePrecreateResponse responseData = null;
        try {
            responseData = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            log.error("获取支付宝支付二维码失败", e);
        }
        if (responseData == null) {
            log.error("获取支付宝支付二维码失败, 返回参数为空");
            throw new Exception("获取支付宝支付二维码失败, 返回参数为空");
        }
        log.info("response:{}", responseData.getBody());
        String qrCode = responseData.getQrCode();
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
        String tradeNo = request.getParameter("out_trade_no");

        if (StringUtil.isEmpty(tradeStatus) || StringUtil.isEmpty(tradeNo)) {
            log.error("支付宝回调 参数为空");
        }
        //判断状态是否完成
        if ("TRADE_SUCCESS".equals(tradeStatus)) {
            // TODO 支付成功 修改订单状态
            //notify success trade_status=TRADE_SUCCESS out_trade_no=1668263409801
            log.info("notify success trade_status={} out_trade_no={}", tradeStatus, tradeNo);
        } else {
            log.error("notify failed trade_status={} out_trade_no={}", tradeStatus, tradeNo);
        }
    }
}
