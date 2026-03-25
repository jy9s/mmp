package com.jygs.mmp.dashboard;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<ConversionsEntity, Long> {
	
	
	@Query("SELECT COALESCE(SUM(c.revenue), 0) FROM ConversionsEntity c WHERE c.createdAt BETWEEN :start AND :end")
	Long getTotalRevenue(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

	
}
