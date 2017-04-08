package com.domain.springlayersexample.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.springlayersexample.domain.Greeting;
import com.domain.springlayersexample.dto.GreetingDTO;
import com.domain.springlayersexample.mapper.GreetingMapper;
import com.domain.springlayersexample.service.GreetingService;

@RequestMapping("/greetings")
@RestController
public class GreetingResource {

	@Autowired
	private GreetingService greetingService;
	
	@Autowired
	private GreetingMapper greetingMapper;
	
    @GetMapping("")
    public List<GreetingDTO> obtener() {
    	List<Greeting> greetings = greetingService.findAll();
    	List<GreetingDTO> greetingDTOs = greetingMapper.toDTOList(greetings);
    	return greetingDTOs;
    }
    
    
    @PostMapping("")
    public GreetingDTO crear(GreetingDTO greetingDTO) {
    	Greeting greeting = greetingMapper.toEntity(greetingDTO);
    	greeting = greetingService.save(greeting);
    	greetingDTO = greetingMapper.toDTO(greeting);
    	
    	return greetingDTO;
    }
    
    @GetMapping("/{id}")
    public GreetingDTO optenerPorId(@PathVariable(value="id") Long greetingId) {
    	Greeting greeting = greetingService.findOneById(greetingId);
    	GreetingDTO greetingDTO = greetingMapper.toDTO(greeting);
    	return greetingDTO;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity borrar(@PathVariable(value="id") Long greetingId) {
    	greetingService.delete(greetingId);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
