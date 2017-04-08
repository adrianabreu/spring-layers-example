package com.domain.springlayersexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.springlayersexample.domain.Greeting;
import com.domain.springlayersexample.repository.GreetingRepository;

@Service
public class GreetingService {
	
	@Autowired
	private GreetingRepository greetingRepository;
	
	
	public List<Greeting> findAll() {
		return greetingRepository.findAll();
	}
	
	public Greeting findOneById(Long id) {
		return greetingRepository.findOneById(id);
	}
	
	public Greeting save(Greeting greeting) {
		// Usando la lógica de negocio modificamos los campos que solo nos interesan de la entidad
		greeting.setUpdated(Boolean.TRUE);
		return greetingRepository.save(greeting);
	}
	
	public void delete(Long id) {
		greetingRepository.delete(id);
	}
}
