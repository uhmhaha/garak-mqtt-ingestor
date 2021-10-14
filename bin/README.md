----

# MQTT Ingestor Module in 전동관제 시스템 

## 시스템 

### 개요 

* 프로젝트 명 : 가락시장 MQTT Ingestor
* 개발자 : 양승권

## references
* https://github.com/eclipse/paho.mqtt.java
## 요구사항
* specification
	* 
* 주요 features
	* MQTT shared subscription
	* Event handling subscription

## 작업들

### logging 관련
* Access Log 
    * 참고 : https://jacojang.github.io/spring-boot/java/tomcat/2016/08/01/spring-boot-embedded-tomcat-access-log.html
	* 스프링부트는 모든 내부 로깅에 Commons Logging을 사용하지만 기본 로그 구현은 확장할 수 있도록 열여 둡니다. 만약, 아무런 변경을 하지 않았다면 기본 로거는 Logback 입니다.
    * 하지만 Access Log 는 내부 로깅의 영역이 아닙니다. 웹어블리케이션 서버인 톰캣이 남기는 기능이기 때문에 다른 처리가 필요합니다.



		



