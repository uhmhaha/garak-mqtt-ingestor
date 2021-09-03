package com.garak.ingestor.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter // getter 메소드 생성
@Builder // 빌더를 사용할 수 있게 함
@ToString(exclude = "MobilityUserDB")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "users") // 테이블 명을 작성
public class UserRDB {
    @Id
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "user_id", nullable = false)
	private String userId;
	@Column(name = "user_nm", nullable = false)
	private String userNm;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "status", nullable = false)
	private String status;

}
