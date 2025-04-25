package org.example.springmcpserver;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class SpringMcpServerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void myTest() {

        ServerParameters parameters = ServerParameters.builder("cmd")
                .args("/c", "C:/Program Files/Java/jdk17/bin/java", "-jar", "C:/Users/Zhang/IdeaProjects/spring-mcp-server/target/spring-mcp-server-0.0.1-SNAPSHOT.jar").build();

        McpSyncClient mcpClient = McpClient.sync(new StdioClientTransport(parameters)).build();

        McpSchema.CallToolResult callToolResult = mcpClient.callTool(new McpSchema.CallToolRequest("getWeather",
                Map.of("city", "南京")));


        List<McpSchema.Content> content = callToolResult.content();

        Assertions.assertNotNull(content);
        Assertions.assertEquals(content.size(), 1);

        McpSchema.TextContent result = (McpSchema.TextContent) content.get(0);

        Assertions.assertEquals(result.text(), "\"南京的温度是2\"");

        mcpClient.closeGracefully();

    }
}
