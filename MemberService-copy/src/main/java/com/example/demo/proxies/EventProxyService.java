package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.bean.EventBean;

@FeignClient(name = "EVENTSERVICE")
public interface EventProxyService {
	@GetMapping("/events/{id}")
	public EventBean findEventById(@PathVariable(name = "id") Long id);
}
