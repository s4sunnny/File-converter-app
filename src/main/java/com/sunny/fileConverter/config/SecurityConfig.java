package com.sunny.fileConverter.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.cors().disable().csrf().and()
		.authorizeRequests()
        .antMatchers(
                "/**",
                "/js/**",
                "/css/**",
                "/img/**",
                "/scss/**",
                "/fonts/**",
                "/vendor/remixicon/**",
                "/icon/**").permitAll()
        .antMatchers("/resources/**").permitAll();
//        .and()
//        .formLogin()
//        .loginPage("/login").permitAll()
//        .loginProcessingUrl("/doLogin")
//        .defaultSuccessUrl("/dashboard")
//        .failureUrl("/login?error=true")
//        .failureHandler(mvcConfig.authenticationFailureHandler())
//        .and()
//        .logout()
//        	.deleteCookies("JSESSIONID")
//        	.invalidateHttpSession(true)
//            .clearAuthentication(true)
//        .logoutUrl("/logout")
//        .logoutSuccessUrl("/login?logout=true")
//        .and()
//        .exceptionHandling()
//            .accessDeniedHandler(accessDeniedHandler);
//        .and()
//        .sessionManagement()
//        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
//        .invalidSessionUrl("/login?invalidSession=true")
//        .maximumSessions(5)
//        .maxSessionsPreventsLogin(true)
//        .expiredUrl("/login?sessionExpiry=true");
        
		
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/convert-pdf-to-jpg").antMatchers("/getCommonPageForConverted").antMatchers("/searchImageToPdfView")
	    .antMatchers("/convertImageToPdf").antMatchers("/getJpgToPdfView").antMatchers("/getPdfToTextView").antMatchers("/searchPdfToTextView")
	    .antMatchers("/convert-pdf-to-text").antMatchers("/getImageToTextView").antMatchers("/searchImageToTextView").antMatchers("/convertImageToText");
	}
}
