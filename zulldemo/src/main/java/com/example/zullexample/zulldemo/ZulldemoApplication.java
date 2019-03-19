package com.example.zullexample.zulldemo;

import com.example.zullexample.zulldemo.filters.ErrorFilter;
import com.example.zullexample.zulldemo.filters.PostFilter;
import com.example.zullexample.zulldemo.filters.PreFilter;
import com.example.zullexample.zulldemo.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZulldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZulldemoApplication.class, args);
	}

		@Bean
		public PreFilter preFilter() {
			return new PreFilter();
		}
		@Bean
		public PostFilter postFilter() {
			return new PostFilter();
		}
		@Bean
		public ErrorFilter errorFilter() {
			return new ErrorFilter();
		}
		@Bean
		public RouteFilter routeFilter() {
			return new RouteFilter();
		}





}

