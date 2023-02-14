package com.lmh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.lmh.controller","com.lmh.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
