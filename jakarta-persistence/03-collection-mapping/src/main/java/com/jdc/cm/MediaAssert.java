package com.jdc.cm;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Deque;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "media_assert_tbl")
@Getter
@Setter
public class MediaAssert implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	private String format;
	
	@ElementCollection
	@CollectionTable(name = "permission_tbl", joinColumns = @JoinColumn(name = "media_assert_id"))
	@Column(name = "permission", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<Permission> permissions;
	
	@ElementCollection
	@Column(nullable = false)
	private Deque<LocalDateTime> modifictions;
	
//	@ElementCollection
//	@CollectionTable(name = "media_assert_tag", joinColumns = @JoinColumn(name = "media_assert_id"))
//	@MapKeyColumn(name = "tag_key")
//	@Column(name = "tag", nullable = false)
//	private Map<Integer, String> tags;
	
//	@ElementCollection
//	@Column(name = "permission_number", nullable = false)
//	@Enumerated(EnumType.STRING)
//	private Set<PermissionNumber> permissionNumbers;  
	
	@ElementCollection
	@MapKeyColumn(name = "permission_map_key")
	@Enumerated(EnumType.STRING)
	@MapKeyEnumerated(EnumType.STRING)
	private Map<Permission, PermissionNumber> permissionMap;
	
	public enum Permission {
		EXECUTABLE, READ, WRITE, 
	}
	
	public enum PermissionNumber {
		ONE, TWO, FOUR
	}
	
}
