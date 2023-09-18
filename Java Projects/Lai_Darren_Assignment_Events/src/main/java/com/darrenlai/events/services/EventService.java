package com.darrenlai.events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darrenlai.events.models.Event;
import com.darrenlai.events.repositories.EventRepository;


@Service
public class EventService {
    
    @Autowired
    private EventRepository eventRepo;
    
    public List<Event> allEvents() {
        return eventRepo.findAll();
    }
	
	public Event createEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public Event findEvent(Long id) {
		Optional<Event> optionalEvent = eventRepo.findById(id);
		if(optionalEvent.isPresent()) {
			return optionalEvent.get();
		}
		else return null;
	}

	public Event updateEvent(Event event) {
		return eventRepo.save(event);
	}

	public void deleteExpense(Long id) {
        eventRepo.deleteById(id);
    }
	

}