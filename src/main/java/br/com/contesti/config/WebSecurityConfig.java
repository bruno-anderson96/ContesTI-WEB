package br.com.contesti.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth,DataSource dataSource) throws Exception{
		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("prof1").password("123").roles("PROF");
//		auth.inMemoryAuthentication().withUser("est1").password("123").roles("ESTUDANTE");
	
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select id_usuario as principal, senha as credentials, true from usuario where login = ?")
		.authoritiesByUsernameQuery("select usuario_id_usuario as principal, roles_role as role from usuario_roles where usuario_id_usuario = ?").rolePrefix("ROLE_");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
   http.csrf().disable().authorizeRequests()  
	 		.antMatchers("/cadastroQuestao").hasRole("ADMIN")
	        .antMatchers("/cadastro").permitAll()
	         .and().formLogin().loginPage("/").permitAll().defaultSuccessUrl("/cadastroQuestao")
	        .usernameParameter("login").passwordParameter("senha")
	        .and().csrf()
	        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
	    }
	

	}
	
	
	

