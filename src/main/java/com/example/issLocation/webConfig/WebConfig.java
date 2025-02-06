package com.example.issLocation.webConfig;

import com.example.issLocation.listener.SessionListener;
import com.example.issLocation.service.AccessCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final AccessCountService accessCountService;

    @Autowired
    public WebConfig(AccessCountService accessCountService) {
        this.accessCountService = accessCountService;
    }

    public ServletListenerRegistrationBean<SessionListener> sessionListener() {
        return new ServletListenerRegistrationBean<>(new SessionListener(accessCountService));
    }
}
