package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Event;
import com.example.demo.service.IEventService;
@RestController
public class EventsController {
	@Autowired
	IEventService eventService;

	@GetMapping(value = "/events")
	public List<Event> getEvents() {
	    return eventService.findAll();
	}

	@GetMapping(value = "/events/{id}")
	public Event findEventById(@PathVariable Long id) {
		return eventService.findEvent(id);
	}

	@PostMapping(value = "/events")
	public Event addEvent(@RequestBody Event m) {
		return eventService.addEvent(m);
	}



	@DeleteMapping(value = "/events/{id}")
	public void deleteEvent(@PathVariable Long id) {
		eventService.deleteEvent(id);
	}

	@PutMapping(value = "/events/{id}")
	public Event updateEvent(@PathVariable Long id, @RequestBody Event p) {
		p.setId(id);
		return eventService.updateEvent(p);
	}


}
