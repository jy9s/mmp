package com.jygs.mmp.dashboard;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="conversions")
public class ConversionsEntity {

    @Id
    @Column(name = "conversions_id")
    private Long conversionsId;

    @Column(name = "campaign_id")
    private Long campaignId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "revenue")
    private Long revenue;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
