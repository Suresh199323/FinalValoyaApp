package com.example.zullserver;

import com.example.zullserver.filters.ErrorFilter;
import com.example.zullserver.filters.PostFilter;
import com.example.zullserver.filters.PreFilter;
import com.example.zullserver.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZullServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZullServerApplication.class, args);
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

