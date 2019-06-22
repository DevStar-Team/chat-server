/**
 * @author 신춘호(sch0718@naver.com)
 * @date 2019. 6. 22.
 * @file RoomService.java
 */
package me.devstar.web.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.devstar.common.entity.SearchForm;
import me.devstar.common.service.BaseCrudService;
import me.devstar.web.chat.entity.Room;
import me.devstar.web.chat.repository.RoomRepository;
import me.devstar.web.service.impl.AbstractBaseCrudService;

/**
 * 
 */
@Service
public class RoomService extends AbstractBaseCrudService<Room, SearchForm, RoomRepository, Long> implements BaseCrudService<Room, SearchForm, Long> {
	
	@Override
	@Autowired
	public void setRepository(RoomRepository repository) {
		super.setRepository(repository);
	}
}
