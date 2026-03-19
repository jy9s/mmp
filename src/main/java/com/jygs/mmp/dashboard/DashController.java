package com.jygs.mmp.dashboard;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashController {

	
	private final DashService ds;	
	
	public DashController(DashService ds) {
		this.ds=ds;
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		
		List<DashEntity> list =  ds.searchDailyStats();
		
		System.out.println(list);
		
		return "dashboard";
	}
	
	
	
	
}
