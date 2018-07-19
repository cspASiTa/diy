package com.hycxkj.common.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DevicePlatform;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 陈少平
 * @description
 * @create in 2018/3/30 11:18
 */
public class HttpUtil {

    public static String getClientAgent(HttpServletRequest request, Device device) {
        String deviceName = "unknown";
        if(device.isMobile()) {
            DevicePlatform platform = device.getDevicePlatform();
            deviceName = platform.name();
        }else if(device.isNormal()) {
            deviceName = "PC";
        }else if(device.isTablet()) {
            deviceName = "Tablet";
        }
        InnerAgentInfo agentInfo = new InnerAgentInfo();
        agentInfo.setDeviceName(deviceName);
        return JSONObject.toJSONString(agentInfo);
    }

    public static class InnerAgentInfo {
        private String deviceName;

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }
    }


}
