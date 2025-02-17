package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.bean.ToolsBean;

@FeignClient(name = "TOOLSSERVICE")
public interface ToolsProxyService {
	@GetMapping("/tools/{id}")
	public ToolsBean findToolsById(@PathVariable(name = "id") Long id);
}
