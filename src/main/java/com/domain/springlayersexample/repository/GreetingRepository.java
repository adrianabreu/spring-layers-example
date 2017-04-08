package com.domain.springlayersexample.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.domain.springlayersexample.domain.Greeting;

@Repository
public class GreetingRepository {

	private AtomicInteger idCounter = new AtomicInteger();
	private HashMap<Long,Greeting> greetings = new HashMap();
	
	public List<Greeting> findAll() {
		return new ArrayList<Greeting>(greetings.values());
	}
	
	public Greeting findOneById(Long id) {
		return greetings.get(id);
	}
	
	public Greeting save(Greeting greeting) {
		greeting.setId(idCounter.longValue());
		greetings.put(idCounter.longValue(), greeting);
		idCounter.incrementAndGet();
		return greeting;
	}
	
	public void delete(Long id) {
		greetings.remove(id);
	}
}
