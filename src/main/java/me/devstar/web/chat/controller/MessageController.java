/**
 * @author 신춘호(sch0718@naver.com)
 * @date 2019. 6. 22.
 * @file MessageController.java
 */
package me.devstar.web.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.devstar.common.entity.SearchForm;
import me.devstar.web.chat.entity.Message;
import me.devstar.web.chat.service.MessageService;

/**
 * 
 */
@RestController
@RequestMapping(RoomController.REQUEST_PREFIX)
public class MessageController {
	
	public static final String REQUEST_PREFIX = "/rooms";
	
	@Autowired
	MessageService service;
	
	@PostMapping("/{roomId}/messages")
	public Message create(@PathVariable("roomId") Long roomId, @RequestBody Message t) {
		t.setRoomId(roomId);
		return service.create(t);
	}
	
	@GetMapping("/{roomId}/messages/{id}")
	public Message get(@PathVariable("roomId") Long roomId, @PathVariable("id") Long id) {
		return service.get(id);
	}
	
	@GetMapping("/{roomId}/messages")
	public Page<Message> getList(@PathVariable("roomId") Long roomId, SearchForm searchForm) {
		return service.getList(searchForm);
	}
	
	@GetMapping("/{roomId}/messages/all")
	public List<Message> getListAll(@PathVariable("roomId") Long roomId, SearchForm searchForm) {
		return service.getListAll(searchForm);
	}
	
	@PutMapping("/{roomId}/messages/{id}")
	public Message modify(@PathVariable("roomId") Long roomId, @PathVariable("id") Long id, @RequestBody Message t) {
		t.setRoomId(roomId);
		t.setId(id);
		return service.modify(t);
	}
	
	@DeleteMapping("/{roomId}/messages/{id}")
	public void remove(@PathVariable("roomId") Long roomId, @PathVariable("id") Long id) {
		service.remove(id);
	}
	
	@GetMapping("/{roomId}/messages/{id}/after")
	public List<Message> getMessagesAfter(@PathVariable("roomId") Long roomId, @PathVariable("id") Long id) {
		return service.getMessagesAfter(roomId, id);
	}
}
