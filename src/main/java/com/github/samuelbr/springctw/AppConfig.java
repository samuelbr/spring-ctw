package com.github.samuelbr.springctw;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages="com.github.samuelbr.springctw")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AppConfig {

}
