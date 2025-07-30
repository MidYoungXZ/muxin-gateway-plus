package com.muxin.gateway.admin.config;

import com.muxin.gateway.admin.websocket.MonitorWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * WebSocket配置
 *
 * @author muxin
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    
    private final MonitorWebSocketHandler monitorWebSocketHandler;

    public WebSocketConfig(MonitorWebSocketHandler monitorWebSocketHandler) {
        this.monitorWebSocketHandler = monitorWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(monitorWebSocketHandler, "/ws/monitor")
                .setAllowedOrigins("*");
    }
} 