package com.jdc.statement.dto;

import java.time.LocalDateTime;

public record Messages(
		int id,
		String title,
		String message,
		LocalDateTime postAt) {

	public Messages(String title, String message) {
		this(0,title,message,null);
	}
	
	public Messages cloneWithId(int id) {
		return new Messages(id,this.title(),this.message(),this.postAt);
		
	}
}
