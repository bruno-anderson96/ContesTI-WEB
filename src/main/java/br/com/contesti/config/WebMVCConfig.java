package br.com.contesti.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter {


	public void addViewController(ViewControllerRegistry registry){
		registry.addViewController("/").setViewName("Login");
//		registry.addViewController("/logout").setViewName("login");
	}
	
}
