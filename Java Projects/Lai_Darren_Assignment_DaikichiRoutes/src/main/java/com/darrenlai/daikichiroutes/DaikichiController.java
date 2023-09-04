package com.darrenlai.daikichiroutes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
		@RequestMapping("")
		public String welcomeMessage() {
			return "Welcome!";	
		}
		
		@RequestMapping("/today")
		public String todayMessage() {
			return "Today you will find luck in all your endeavors!";
		}
		@RequestMapping("/tomorrow")
		public String tomorrowMessage() {
			return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
		}
		
		@RequestMapping("/travel/{location}")
		public String travelMessage(@PathVariable("location") String location) {
			return "Congratulations! You will soon travel to " + location + "!";
		}
		@RequestMapping("/lotto/{integer}")
		public String lottoMessage(@PathVariable("integer") int integer) {
			if (integer % 2 == 0) return "You will take a grand journey in the near future, but be weary of tempting offers.";
			else return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
		

}
