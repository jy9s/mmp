package com.jygs.mmp.dashboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashService {

	@Autowired
	private DashRepository dr;
	
	public List<DashEntity> searchDailyStats() {		
		return dr.findAllByOrderByStatsDateDesc();
	}
	
}
