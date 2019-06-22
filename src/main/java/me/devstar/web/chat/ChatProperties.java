/**
 * @author 신춘호(sch0718@naver.com)
 * @date 2019. 6. 22.
 * @file ChatProperties.java
 */
package me.devstar.web.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 
 */
@Configuration
@ConfigurationProperties(prefix = ChatProperties.CONFIGURATION_PREFIX)
public class ChatProperties implements InitializingBean {
	
	private static final Logger LOG = LoggerFactory.getLogger(ChatProperties.class);
	
	public static final String CONFIGURATION_PREFIX = "devstar.chat";
	
	private String[] permitAllPages;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug(getClass().getName() + " initialized.");
			
			for (String url : getPermitAllPages()) {
				LOG.debug("permit all pages: {}", url);
			}
		}
	}
	
	/**
	 * @return the permitAllPages
	 */
	public String[] getPermitAllPages() {
		return permitAllPages;
	}
	
	/**
	 * @param permitAllPages the permitAllPages to set
	 */
	public void setPermitAllPages(String[] permitAllPages) {
		this.permitAllPages = permitAllPages;
	}
	
}
