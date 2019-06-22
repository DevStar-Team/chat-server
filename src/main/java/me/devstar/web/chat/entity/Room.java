/**
 * @author 신춘호(sch0718@naver.com)
 * @date 2019. 6. 21.
 * @file Room.java
 */
package me.devstar.web.chat.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import me.devstar.common.entity.BaseModel;

/**
 * 
 */
@Entity
@Table(name = "ROOM")
public class Room extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1640803864709234055L;
	
	private String name;
	
	private String description;
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
