package com.garak.ingestor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // getter 메소드 생성
@Builder // 빌더를 사용할 수 있게 함
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "comm_cd_dt") // 테이블 명을 작성
public class CodeDetailRDB {
    @Id
	@Column(name = "code", nullable = true)
	private String code;
	@Column(name = "code_nm", nullable = true)
	private String codeNm;
	@Column(name = "desc", nullable = true)
	private String desc;
	@Column(name = "group_code", nullable = true)
	private String groupCode;
	@Column(name = "use_yn", nullable = true)
	private String useYn;

}
