package com.yedam.test;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
@SpringBootApplication
public class AppApplication {
    private static final Logger log = LoggerFactory.getLogger(AppApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
    
    @Bean
    public LocaleResolver localeResolver() {
    	SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
    	sessionLocaleResolver.setDefaultLocale(Locale.KOREA);
    	return sessionLocaleResolver;
    }
    
    @RequestMapping("/")
    public String index() {
    	return "index";
    }
}
