package com.jdc.cm;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
@Table(name = "media_asset_tbl")

@Getter
@Setter
public class MediaAsset implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	private String format;
	
	@ElementCollection
	@CollectionTable(name = "permission_tbl", 
					 joinColumns = @JoinColumn(name = "permission_num"))
	@Column(name = "permission",nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private List<Permission> permissions;
	
	public enum Permission{
		EXECUTE,WRITE,READ
	}
	
	@ElementCollection
	private Deque<LocalDateTime> modifications; 
	
	@ElementCollection
	@CollectionTable(name = "media_asset_tags",
							joinColumns = @JoinColumn(name = "media_asset_id"))
	@MapKeyColumn(name = "tags_key")
	@Column(name = "tags")
	private Map<Integer,String> tags;
	
	@ElementCollection
	@MapKeyColumn(name = "permission_map_key")
	@MapKeyEnumerated(EnumType.STRING)
	@Enumerated(EnumType.STRING)
	private Map<Permission,permissionNumber> permissionNumber;
	public  enum permissionNumber{
		ONE,TWO,THREE
    }
	
	@ElementCollection
	@Column(name = "permission_number" , nullable = false)
	private Set<Integer> permissionNumbers;
	
	
	
}
