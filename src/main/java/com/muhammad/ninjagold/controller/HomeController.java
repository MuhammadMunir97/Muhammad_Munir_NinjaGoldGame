package com.muhammad.ninjagold.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping(value="/")
	public String home(Model model, HttpSession session) {
		Integer gold = 0;
		String webLog = "";
		session.setAttribute("totalGold", gold);
		model.addAttribute("totalGold", gold);
		session.setAttribute("webLog", webLog);
		model.addAttribute("webLog", webLog);
		return "Index.jsp";
	}
	@RequestMapping(value="/Gold", method=RequestMethod.POST)
	public String gold(Model model, @RequestParam("place") String sentFrom, HttpSession session) {
		Random rand = new Random();
		Integer gold = (Integer) session.getAttribute("totalGold");
		String webLog = (String) session.getAttribute("webLog");
		Integer temp = gold;
		switch(sentFrom) {
			case"farm":
				gold += rand.nextInt(10) + 10;
				break;
			case"cave":
				gold += rand.nextInt(5) + 5;
				break;
			case"house":
				gold += rand.nextInt(2) + 3;
				break;
			case"casino":
				gold += rand.nextInt(100) - 50;
				break;
			default:
				return "Index.jsp";
		}
		Integer earning = gold - temp;
		webLog += "<br>You entered a " + sentFrom + " and earned " + earning.toString() + " " +  dateBuilder();
		
		session.setAttribute("totalGold", gold);
		model.addAttribute("totalGold", gold);
		session.setAttribute("webLog", webLog);
		model.addAttribute("webLog" , webLog);
		
		return "Index.jsp";
	}
	
	
	private String dateBuilder() {
		 //String weekDay;
		 String month;
		 int year;
		 int day;
		 int hour;
		 int min;
		
		
		 Calendar  calendar = Calendar.getInstance();
		
		
		TimeZone tz = TimeZone.getTimeZone("EST");
		calendar.setTimeZone(tz);;
		//weekDay = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
		month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US);
		year = calendar.get(Calendar.YEAR);
		day = Calendar.DAY_OF_MONTH;
		hour = calendar.get(Calendar.HOUR);
		min = calendar.get(Calendar.MINUTE);
		
		String prefix = "PM";
		int com = calendar.get(Calendar.AM_PM);
		if(com == 0)
			prefix = "AM";
		
		return month + " " + day + " "+ year + " " + hour + ": " + min + " " + prefix;
	}
}
