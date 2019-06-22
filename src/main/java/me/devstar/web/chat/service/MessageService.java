/**
 * @author 신춘호(sch0718@naver.com)
 * @date 2019. 6. 22.
 * @file MessageService.java
 */
package me.devstar.web.chat.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import me.devstar.common.entity.SearchForm;
import me.devstar.common.service.BaseCrudService;
import me.devstar.web.chat.entity.Message;
import me.devstar.web.chat.repository.MessageRepository;
import me.devstar.web.service.impl.AbstractBaseCrudService;

/**
 * 
 */
@Service
public class MessageService extends AbstractBaseCrudService<Message, SearchForm, MessageRepository, Long>
		implements BaseCrudService<Message, SearchForm, Long> {
	
	@Override
	@Autowired
	public void setRepository(MessageRepository repository) {
		super.setRepository(repository);
	}
	
	public List<Message> getMessagesAfter(Long roomId, Long id) {
		return repository.findAll(Specification.where((root, query, cb) -> {
			final Collection<Predicate> predicates = new ArrayList<>();
			predicates.add(cb.equal(root.get("isDeleted"), false));
			predicates.add(cb.equal(root.get("roomId"), roomId));
			predicates.add(cb.greaterThan(root.get("id"), id));
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		}), Sort.by(Order.asc("id")));
	}
}
