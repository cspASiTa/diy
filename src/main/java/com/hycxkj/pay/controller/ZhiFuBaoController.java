package com.hycxkj.pay.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.hycxkj.pay.bean.ZhiFuBaoBean;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 陈少平
 * @description
 * @create in 2018/5/5 17:18
 */
@RequestMapping("/api")
@RestController
public class ZhiFuBaoController {

    // 商户appid
    private static String APPID = "2016091500516548";
    // 私钥 pkcs8格式的
    private static String RSA_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCzUiZv7PI9EUD/jiG55RhYPjtRr/HQtxZasM2JYil+YY5pZKIj4MLBPIswERDH3aMcQ95hrJwp1xkClfUv96PMmggfuk6PrwERzbsG3vlxoarjYw+TNE2yKgs7uVH77qXAZwTReCltV+RwLDcQjDbj9ZK7i1jsLMrHNleAK6cuV46bz0792+l6KWFBg6VWYm3TwVDpJadex64oBW+pUoIlaQtZ8R1+IjwgyH+MEFLnAdC/XzbIq2MtXRKqSlixSnz3UNHM5q+fCg8VS6oSGIP25Upt8uWl/b/+TuqBRbL/Kj7MYyXKDLUTIn73Mje/JkUF2Nvka8N8eARtsTkDw2RRAgMBAAECggEAZ55604ZJ2/vSYVnSJ0c4sBUV1fgjdYW2hyVPP6nXbE4XKtOZ1b2VDHBdxaK23ac3D6gwIqTJgGvo6dOZYORqZFpFg3/20ZRAu/bzsd66qWzQAKFHaLp6gw9Eenh15WxbnzhoUlprJeH6AM+r6gX72fIXngPBmIexjTfbjBatflrk/IFIidVcMYOsWx4G4C+cyW+pbnF1Dhyh4yDxFrmiuBMEpKABWbTDzKA3f4WiisArac9p11iM5aazYi2ICmi37oaCcTROWt7EMkHVJIRbxPwXEe2uapvIki0ip3yCfk7KR/mXdbIC0pJL9lkC93oiDsMUsbe7svjRzXCMnuhoAQKBgQDtppMJkyEtGDwgExYxIb/UuWFbN9EpFdeWs+BsgZpXqXFVOG6gW+kyCSX3jeIYfyBrD/A/mvYikamgCzZDSS1l1/27hr5LlfaiJ4yIeUoS5p1lTreQnDWcm2DF2vyG51EPMEqJmodn0P8ETYW3LapsnsESgo+xx63p43VqQrW0wQKBgQDBKp+0B4xBD6+XT8BpjOrCypqrw9U03G3QQmK3QajFP7l849BZrD8/mEbn4MfT5R/Ux1uwP3GK+uJQekVgNoD8oN6eps6G12HttnMqsYYz4+xBqnR6huvE0JQz8y3qiwCljXD+ZjZh5jxreb00N8j6zg2VMJ39U6+PDZPSb2nDkQKBgF/fjnwTXhP6Le9mo9JIYkJoUy1glEH17NaAVK6RjnmFAxK1RHPvAGHOLQH0vFzTlHl8oZiXZGrHxt2pCEgW0ni+rT8k+co2gpwiRmCcRdTgMmk3W3i8fChkyqKnWK73zMzK15cxvySTvP24ZJRkmNdfKFbWUzAOdUvhFnI63WFBAoGALCHN3PbAf3jS+DH7VuIgHKLnVYjnZC1cVXFlVlME+RPHEBaIWoR06tWilYWQggPeEuH9O7Yy/bq2DAbzZLjvHUivs/WOR9ZbhFDj3QQ0EhTnvFTySbAbm5q/0WKkwepCGpDHGQhHMnTEpxVoOc7o9wwupEA4SFFfUcKbXD+iHVECgYA4CMmaKTjeV4XGtOmXGlM2AT1RGqOEYYIAqP4PRM/67uRj6tGiDKQs4EKQKutE20gspCVGrCp0yYq5qBS4r8Cp/wWLOzwEfSV6JpzlhW1ehxte3UAkaVwnzZlOkDLRdbi81DAw9PU6T7AIItQvhpgVcCWWcn7CoBpOzbVm/2ehZg==";

    // 请求网关地址
    private static String URL = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    private static String CHARSET = "UTF-8";
    // 返回格式
    private static String FORMAT = "json";
    // 支付宝公钥
    private static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsOM5e1j0j7q9cSpnHCiYurPBUJWTHli8WTBHdWuVxcQIt8UALg86VUDMUCY38gu5pPvh7sjqxDfhqJKphktjyJM3bkfAGJbMv1FgcE3gbJEy2S5jh+9AF0D6rkVhaEXnwD+a2nhp13NanZhbK0aJwvxSWZOJfnQVA6k4C+R0HoB/lTITLZKolo7qOgTiSdBSOBzS5IbAk1WXtkEhhFCjuEdY0US1xqXqFYsORWq7VswKJVvXG+oSXietRtFrFt6FpGVE9r85QcWNXMUz/lDYhQGAZyk1r9czbsaCYiCt7avNUSoLcL8rop5JLIhnVEY/VvPObKeE2+gieRTd6S5hhwIDAQAB";
    // 日志记录目录
    private static String log_path = "/log";
    // RSA2
    private static String SIGNTYPE = "RSA2";

    public void  zhifubaoPay(@ModelAttribute ZhiFuBaoBean zhiFuBaoBean, HttpServletResponse response) {
        AlipayClient alipayClient = new DefaultAlipayClient(URL,APPID,RSA_PRIVATE_KEY,FORMAT,CHARSET,ALIPAY_PUBLIC_KEY,SIGNTYPE);
        AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();
        AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
        model.setOutTradeNo(zhiFuBaoBean.getWIDout_trade_no());
        model.setSubject(zhiFuBaoBean.getWIDsubject());
        model.setTotalAmount(zhiFuBaoBean.getWIDtotal_amount());
        model.setBody(zhiFuBaoBean.getWIDbody());
        model.setTimeoutExpress(zhiFuBaoBean.getTimeout_express());
        model.setProductCode(zhiFuBaoBean.getProduct_code());
        alipay_request.setBizModel(model);
        String form = "";
        try{
            form = alipayClient.pageExecute(alipay_request).getBody();
            response.setContentType("text/html;charset=" + CHARSET);
            response.getWriter().write(form);//直接将完整的表单html输出到页面
            response.getWriter().flush();
            response.getWriter().close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
