package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Tool;
import com.example.demo.service.IToolService;

@RestController
public class ToolsRestController {
	@Autowired
	IToolService toolsService;

	@RequestMapping(value = "/tools", method = RequestMethod.GET)
	public List<Tool> findMembres() {
		return toolsService.findAll();
	}

	@GetMapping(value = "/tools/{id}")
	public Tool findToolsById(@PathVariable Long id) {
		return toolsService.findTool(id);
	}

	@PostMapping(value = "/tools")
	public Tool addTool(@RequestBody Tool e) {
		return toolsService.addTool(e);
	}

	@DeleteMapping(value = "/tools/{id}")
	public void deleteTool(@PathVariable Long id) {
		toolsService.deleteTool(id);
	}

	@PutMapping(value = "/tools/{id}")
	public Tool updateTool(@PathVariable Long id, @RequestBody Tool p) {
		p.setId(id);
		return toolsService.updateTool(p);
	}




}