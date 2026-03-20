package com.jygs.mmp.dashboard;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="DAILY_STATS")



@Getter
@Setter
@ToString
@NoArgsConstructor
public class DashEntity {
	
	@Id
	@Column(name="STATS_ID")
    private Long statsId;
	

	@Column(name="CAMPAIGN_ID")
    private String campaignId;
	
	@Column(name="STATS_DATE")
    private LocalDate statsDate;
	
	@Column(name="CLICKS")
    private Long clicks;
	
	@Column(name="INSTALLS")
    private Long installs;
	
	@Column(name="CONVERSIONS")
    private Long conversions;
	
	@Column(name="REVENUE")
    private Long revenue;
}