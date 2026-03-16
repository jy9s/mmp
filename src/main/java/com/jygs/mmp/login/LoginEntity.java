package com.jygs.mmp.login;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="USERS")

@Getter
@Setter
@ToString
@NoArgsConstructor
public class LoginEntity {
	
	@Id
	@Column(name="NUM", nullable = false)
	private Integer num;
	
	@Column(name="EMAIL", length = 100, nullable=false)
	private String email;
	
	@Column(name="PASS", length = 300, nullable=false)
	private String pass;	
}
