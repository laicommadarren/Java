package com.darrenlai.hellohuman;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloHumanController {
	@RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String name,
    		@RequestParam(value="last_name", required=false) String last_name,
    		@RequestParam(value="times", required=false) int times) {
		String result = "";
		for (int i = 1; i <= times; i++) {
			if (i > 1) result += " ";
			if (name == null && last_name == null) result += "Hello Human";
			else if (name == null && last_name != null) result += "Hello " + last_name;
			else if (name != null && last_name == null) result += "Hello " + name;
			else result += "Hello " + name + " " + last_name;
		}
		return result;
    }
}