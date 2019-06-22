/**
 * @author 신춘호(sch0718@naver.com)
 * @date 2019. 6. 22.
 * @file Message.java
 */
package me.devstar.web.chat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import me.devstar.common.entity.BaseModel;

/**
 * 
 */
@Entity
@Table(name = "MESSAGE")
public class Message extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5624003429491128710L;
	
	private Long roomId;
	
	@Column(name = "MESSAGE_TYPE")
	private String type;
	
	private String message;
	
	@Column(name = "TALKER_NAME")
	private String talkerName;
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return the roomId
	 */
	public Long getRoomId() {
		return roomId;
	}
	
	/**
	 * @return the talkerName
	 */
	public String getTalkerName() {
		return talkerName;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	
	/**
	 * @param talkerName the talkerName to set
	 */
	public void setTalkerName(String talkerName) {
		this.talkerName = talkerName;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
