package com.jdc.ms.collect;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;

@Embeddable
public class Contact {

	@ElementCollection
	private List<String> phones;
	@SuppressWarnings("unused")
	private String address;
	@ElementCollection
	private List<String> email;
}
