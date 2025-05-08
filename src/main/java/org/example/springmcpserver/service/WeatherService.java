package org.example.springmcpserver.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * 正常的spring service
 */
@Service
public class WeatherService {


    /** 构建根据城市获取天气的tool
     * @param city 城市名称
     * @return 天气信息
     */
    @Tool(name = "getWeather", description = "根据城市获取天气")
    public String getWeather(String city) {
        return new String((city).getBytes(), StandardCharsets.UTF_8) + " 天气为晴天 25℃";
    }
}
