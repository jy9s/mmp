package com.jygs.mmp.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashRepository extends JpaRepository<DashEntity, Long> {
	List<DashEntity> findAllByOrderByStatsDateDesc();
}
