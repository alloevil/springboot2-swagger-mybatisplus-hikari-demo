package com.allo.demo;

//import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableSwaggerBootstrapUI
@SpringBootApplication
@MapperScan({"com.allo.demo.dao"})
@ComponentScan(basePackages = "com.allo.demo")
public class MqsDataViewApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqsDataViewApplication.class, args);
	}

}
