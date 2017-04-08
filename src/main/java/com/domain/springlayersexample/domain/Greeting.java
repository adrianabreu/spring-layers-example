package com.domain.springlayersexample.domain;

public class Greeting {

	private Long id;
	
	private String message;
	
	// Este atributo solo estará en la entidad
	private Boolean updated;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getUpdated() {
		return updated;
	}

	public void setUpdated(Boolean updated) {
		this.updated = updated;
	}
	
	
	
}
