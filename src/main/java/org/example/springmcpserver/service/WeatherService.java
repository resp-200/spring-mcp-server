package org.example.springmcpserver.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class WeatherService {


    @Tool(name = "getWeather", description = "根据城市获取天气")
    public String getWeather(String city) {
        return new String((city).getBytes(), StandardCharsets.UTF_8) + " 天气为晴天 25℃";
    }
}
