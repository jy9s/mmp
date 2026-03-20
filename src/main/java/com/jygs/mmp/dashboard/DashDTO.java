package com.jygs.mmp.dashboard;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DashDTO {
		
	private LocalDate statsDate;
    private int clicks;
    private int installs;
    private int conversions;
    private int revenue;
    private int cost;
    private int impressions;
    private String channel;
}
