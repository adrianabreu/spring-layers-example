package com.domain.springlayersexample.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.domain.springlayersexample.domain.Greeting;
import com.domain.springlayersexample.dto.GreetingDTO;

@Component
public class GreetingMapper {

	public GreetingDTO toDTO(Greeting source) {
		if (source == null) {
			return null;
		}
		
		GreetingDTO target = new GreetingDTO();
		target.setId(source.getId());
		target.setMessage(source.getMessage());
		return target;
	}
	
	public Greeting toEntity(GreetingDTO source) {
		if (source == null) {
			return null;
		}
		
		Greeting target = new Greeting();
		target.setId(source.getId());
		target.setMessage(source.getMessage());
		return target;
	}
	
	public List<GreetingDTO> toDTOList(List<Greeting> source) {
		if (source == null) {
			return null;
		}
		List<GreetingDTO> target = source.stream().map(greeting -> toDTO(greeting)).collect(Collectors.toList());
		return target;	
	}
	
	public List<Greeting> toEntityList(List<GreetingDTO> source) {
		if (source == null) {
			return null;
		}
		List<Greeting> target = source.stream().map(greetingDTO -> toEntity(greetingDTO)).collect(Collectors.toList());
		return target;
				
	}
}
