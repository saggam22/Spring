package com.yedam.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.yedam.test.**.mapper")
public class MybatisConfig {

}
