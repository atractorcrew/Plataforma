package web.atractor.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value="/web/app")
public class MyController {

	 @GetMapping(value="/")
	    public String homePage() {
	//	 System.out.println("HOLA MUNDOOOOOOOOOOOOOOOOOOOO");
	        return "Home";
	    }
}
