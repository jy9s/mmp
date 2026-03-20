package com.jygs.mmp.dashboard;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashService {

	@Autowired
	private DashRepository dr;
	
	public List<DashDTO> getDashboardData() {
	    List<Object[]> rows = dr.getDashboardData();

	    return rows.stream()
	            .map(r -> new DashDTO(
	            		((LocalDateTime) r[0]).toLocalDate(),
	                    ((Number) r[1]).intValue(),
	                    ((Number) r[2]).intValue(),
	                    ((Number) r[3]).intValue(),
	                    ((Number) r[4]).intValue(),
	                    ((Number) r[5]).intValue(),
	                    ((Number) r[6]).intValue(),
	                    (String) r[7]
	            ))
	            .toList();
	}
	
}
