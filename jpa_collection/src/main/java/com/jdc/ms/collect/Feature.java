package com.jdc.ms.collect;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Feature implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private String name;
	private String feature;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feature other = (Feature) obj;
		return Objects.equals(feature, other.feature) && Objects.equals(name, other.name);
	}
	@Override
	public int hashCode() {
		return Objects.hash(feature, name);
	}
	
	

}
