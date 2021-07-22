package com.garak.ingestor.vo;

import java.util.Objects;

import com.garak.ingestor.entity.Mobility;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
//@Alias("mobility")
//의 사진과 같이 앞의 예제들에서 SQLMapper.xml 을 보면 parameterType과 resultType에서 VO클래스를 사용할 때 앞의 경로를 모두 적어야 하는 불편함이 있었다.
//이 경로를 생략할 수 있는 방법이 Alias 이다.
public class MobilityVO {

	private double id;
	private Gps gps;
	private Battery battery;
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mobility moility = (Mobility) o;
        return Objects.equals(id, moility.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
        
