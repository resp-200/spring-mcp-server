package org.example.springmcpserver.config;

import org.example.springmcpserver.service.WeatherService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpConfig {


//    @Bean
//    public List<ToolCallback> getToolCallbacks(WeatherService service) {
//        return List.of(ToolCallbacks.from(service));
//    }

    @Bean
    public ToolCallbackProvider getToolCallbackProvider(WeatherService weatherService) {
        return MethodToolCallbackProvider.builder().toolObjects(weatherService).build();
    }
}
