package fi.harkka.catfood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fi.harkka.catfood.web.UserDetailServiceImpl;

//Extending the already existing Springboots WebSecurityConfigurerAdapter
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        //Here are URl that don't need any authentication
	        .authorizeRequests()
	        	.antMatchers("/css/**").permitAll() // Enable css when logged out
	        		.and()
	      //Which URls need authentication
	        .authorizeRequests()
	          .anyRequest().authenticated()
	          .and()
	      .formLogin()
	      		//Put login-page here
	      		//.loginPage("/login")
	      		//Where to redirect if login is successful
	          .defaultSuccessUrl("/index", true)
	          .permitAll()
	          .and()
	      .logout()
	      	//allowing all to call logout
	          .permitAll();
	    }
	    
	    //password encrypting
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	    }
	
}
