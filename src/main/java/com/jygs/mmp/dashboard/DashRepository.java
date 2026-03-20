package com.jygs.mmp.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DashRepository extends JpaRepository<DashEntity, Long> {
	
	@Query(value = "SELECT ds.stats_date, ds.clicks, ds.installs, ds.conversions, ds.revenue, ds.cost, ds.impressions, c.channel "+
			"FROM daily_stats ds JOIN campaigns c "
			+ " ON ds.campaign_id = c.campaign_id " 
			+ " ORDER BY ds.stats_date DESC", nativeQuery = true)
	List<Object[]> getDashboardData();

	
}
