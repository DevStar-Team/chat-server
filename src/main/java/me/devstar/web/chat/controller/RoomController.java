/**
 * @author 신춘호(sch0718@naver.com)
 * @date 2019. 6. 22.
 * @file RoomController.java
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
import me.devstar.web.chat.entity.Room;
import me.devstar.web.chat.service.RoomService;

/**
 * 
 */
@RestController
@RequestMapping(RoomController.REQUEST_PREFIX)
public class RoomController {
	
	public static final String REQUEST_PREFIX = "/rooms";
	
	@Autowired
	RoomService service;
	
	@PostMapping
	public Room create(@RequestBody Room t) {
		return service.create(t);
	}
	
	@GetMapping("/{id}")
	public Room get(@PathVariable Long id) {
		return service.get(id);
	}
	
	@GetMapping
	public Page<Room> getList(SearchForm searchForm) {
		return service.getList(searchForm);
	}
	
	@GetMapping("/all")
	public List<Room> getListAll(SearchForm searchForm) {
		return service.getListAll(searchForm);
	}
	
	@PutMapping("/{id}")
	public Room modify(@PathVariable Long id, @RequestBody Room t) {
		t.setId(id);
		return service.modify(t);
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		service.remove(id);
	}
}
