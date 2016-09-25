package br.com.contesti;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getHomePage(){
        return "Login";
    }

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		
//		
//		return "views/home";
//	}
	@RequestMapping("/cadastro")	
		public ModelAndView recebeParam(Model model){
			String nome = "Bem Vindo ao ContesTI!!!";
			model.addAttribute(nome);
		return new ModelAndView("/cadastro", "nome", nome);
		}
	

		
	}
	

	

