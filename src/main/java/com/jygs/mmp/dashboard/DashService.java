package com.jygs.mmp.dashboard;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashService {
	
	private final RevenueRepository rr;
	
	public Long getRevenue(String startDate, String endDate) {
		
		LocalDateTime start = LocalDate.parse(startDate).atStartOfDay();
		LocalDateTime end = LocalDate.parse(endDate).atTime(23,59,59);		
		
		return rr.getTotalRevenue(start, end);
		
	}


}
