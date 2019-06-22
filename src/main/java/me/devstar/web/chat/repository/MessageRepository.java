/**
 * @author 신춘호(sch0718@naver.com)
 * @date 2019. 6. 22.
 * @file MessageRepository.java
 */
package me.devstar.web.chat.repository;

import me.devstar.common.repository.BaseCrudRepository;
import me.devstar.web.chat.entity.Message;

/**
 * 
 */
public interface MessageRepository extends BaseCrudRepository<Message, Long> {
	
}
