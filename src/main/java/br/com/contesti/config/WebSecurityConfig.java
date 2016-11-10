package br.com.contesti.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import br.com.contesti.entidades.Role;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Bean(name = "userDetailService")
	public UserDetailsService userDetailsService(DataSource dataSource) {
		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
		jdbcImpl.setDataSource(dataSource);
		jdbcImpl.setUsersByUsernameQuery(
				"select id_usuario as principal, senha as credentials, true from usuario where login = ?");
		jdbcImpl.setAuthoritiesByUsernameQuery(
				"select usuario_id_usuario as principal, roles_role as role from usuario_roles where usuario_id_usuario = ?");
		return jdbcImpl;
	}

	@Bean(name = "passwordEncoder")
	public Md5PasswordEncoder passwordencoder() throws Exception {
		return new Md5PasswordEncoder();
	}

	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("admin").password("123").authorities("ADMIN");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
		// auth.userDetailsService(userDetailsService);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/homeAdm").hasAuthority("ADMIN")
				.antMatchers("/cadastroQuestaoConcurso").hasAuthority("ADMIN").antMatchers("/cadastroQuestao")
				.fullyAuthenticated().antMatchers("/home").fullyAuthenticated().antMatchers("/Sobre")
				.fullyAuthenticated().antMatchers("/cadastro").permitAll().and().formLogin().loginPage("/").permitAll()
				.defaultSuccessUrl("/home").usernameParameter("login").passwordParameter("senha").and().csrf().and()
				.exceptionHandling().accessDeniedPage("/Access_Denied");
	}

}
