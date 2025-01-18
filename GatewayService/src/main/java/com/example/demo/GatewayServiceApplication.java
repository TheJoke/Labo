package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	@Bean
	RouteLocator routeLocator(RouteLocatorBuilder builder)
	{
	return builder.routes()
	.route(r->r.path("/membres/**").uri("lb://MEMBERSERVICE-COPY"))
	.route(r->r.path("/articles/**").uri("lb://ARTICLESERVICE"))
	.route(r->r.path("/events/**").uri("lb://EVENTSERVICE"))
	.route(r->r.path("/tools/**").uri("lb://TOOLSSERVICE"))
	.build();
	}


}

