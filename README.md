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
	* 투자상품이 오픈될 때, 다수의 고객이 동시에 투자를 합니다. 




## Scenarios - REST APIs

* ***`GET /investAssets/`***
	* Desc. :
		* 전체 투자상품목록을 조회한다. 
	* Input : 
    	* 없음 
    * Output : 
    	````json
    	[
		    {
		        "assetId": 1,
		        "assetTitle": "kakao-fund-002",
		        "assetTotalAmount": 200000000,
		        "assetCurrentAmount": 6000000,
		        "investorNumbers": 2000,
		        "assetStatus": "INPROGRESS",
		        "assetValidFromDate": "2018-12-15T10:00:00",
		        "assetValidToDate": "2018-12-17T10:00:00"
		    },
		    {
		        "assetId": 2,
		        "assetTitle": "kakao-fund-002",
		        "assetTotalAmount": 200000000,
		        "assetCurrentAmount": 6000000,
		        "investorNumbers": 2000,
		        "assetStatus": "INPROGRESS",
		        "assetValidFromDate": "2018-12-15T10:00:00",
		        "assetValidToDate": "2018-12-17T10:00:00"
		    },
		    {
		        "assetId": 3,
		        "assetTitle": "kakao-fund-002",
		        "assetTotalAmount": 106000000,
		        "assetCurrentAmount": 106000000,
		        "investorNumbers": 2000,
		        "assetStatus": "INPROGRESS",
		        "assetValidFromDate": "2018-12-15T10:00:00",
		        "assetValidToDate": "2018-12-17T10:00:00"
		    },
		    {
		        "assetId": 5,
		        "assetTitle": "kakao-fund-002",
		        "assetTotalAmount": 200000000,
		        "assetCurrentAmount": 6000000,
		        "investorNumbers": 2000,
		        "assetStatus": "INPROGRESS",
		        "assetValidFromDate": "2018-12-15T10:00:00",
		        "assetValidToDate": "2018-12-17T10:00:00"
		    }
		]
		````
	
* ***`POST /invest/`***
	* Desc. :
		* 특정상품에 투자한다.
	* Input : 
		* Header : "X-USER-ID" : kakaopay001
		* Body :
    	````json
    	{
		    "assetId" : 1,
		    "investAmount": 1000,
		    "investDate": "2018-12-15T10:00:00"
		}
		````
		
    * Output : 상품 id를 return
    	````json
    	1
		````
		
		
## Test Scenarios

		



