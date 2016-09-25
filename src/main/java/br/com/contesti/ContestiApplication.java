  package br.com.contesti;
   
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  import org.springframework.boot.orm.jpa.EntityScan;
  import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

 
  @SpringBootApplication
  @EntityScan(basePackages = {
              "br.com.contesti.entidades"
              })
  @EnableJpaRepositories(basePackages = {
              "br.com.contesti.repository;"
              })
  public class ContestiApplication {
		

   
      public static void main(String[] args) {
          SpringApplication.run(ContestiApplication.class, args);    

          
          
      }
 
      
      
  }