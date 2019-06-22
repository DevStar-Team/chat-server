/**
 * @author 신춘호(sch0718@naver.com)
 * @date 2019. 6. 22.
 * @file ChatAutoConfigure.java
 */
package me.devstar.web.chat;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import me.devstar.web.Application;
import me.devstar.web.WebAutoconfigure;

/**
 * 
 */
@Configuration
@AutoConfigureAfter(Application.class)
@AutoConfigureBefore(WebAutoconfigure.class)
@ComponentScan(basePackages = ChatAutoConfigure.BASE_PACKAGE_PREFIX)
@EntityScan(basePackageClasses = Jsr310JpaConverters.class, basePackages = {ChatAutoConfigure.BASE_PACKAGE_PREFIX})
@EnableJpaRepositories(basePackages = ChatAutoConfigure.BASE_PACKAGE_PREFIX)
@EnableJpaAuditing(auditorAwareRef = "anonymousAuditorAware")
public class ChatAutoConfigure extends WebSecurityConfigurerAdapter implements WebMvcConfigurer, InitializingBean {
	
	public static final String BASE_PACKAGE_PREFIX = "me.devstar.web.chat";
	
	@Autowired
	ChatProperties configs;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().and().logout().disable().formLogin().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
				.authenticationEntryPoint((request, response, e) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and().authorizeRequests()
				.antMatchers(configs.getPermitAllPages()).permitAll().anyRequest().authenticated();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOrigin("*");
		configuration.addAllowedMethod("*");
		configuration.addAllowedHeader("*");
		configuration.setAllowCredentials(true);
		configuration.setMaxAge(3600L);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
}
