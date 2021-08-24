
# [3주차 과제] Spring Boot를 사용하여 간단한 API 구현 & SQL문 작성

### Contents 
* [Spring Boot로 간단한 API 구현]()

* [SQL문 문서](https://github.com/noohk329/comento-workspace/blob/main/%5B3%EC%A3%BC%EC%B0%A8%5D%20%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8%EB%A5%BC%20%EC%9D%B4%EC%9A%A9%ED%95%9C%20%EA%B0%84%EB%8B%A8%ED%95%9C%20API%20%EA%B5%AC%ED%98%84/%5B4%EC%A3%BC%EC%B0%A8%5D%20SQL%EB%AC%B8.pdf)






## Spring Boot로 간단한 API 구현


### 1. Spring Boot 개발환경 세팅

### 2. Database 데이터 추가 (requestInfo, user)

### 3. mapper 작성 (statisticMapper.java, statisticMapper.xml)

### 4. Service 작성 및 settingTest.java 코드 추가

### 5. 구현 결과
* __연도별 로그인 수 조회__
  - Request URL: http://localhost:8031/20
  - 20년 로그인수 조회
  - 결과
  <img width="456" alt="스크린샷 2021-08-24 오후 1 20 30" src="https://user-images.githubusercontent.com/58394729/130555755-523af782-5b13-4347-a133-f49210f50117.png">
  
* __년/월별 로그인 수 조회__
  - Request URL: http://localhost:8031/20/06
  - 20년 6월 22일 로그인수 조회
  - 결과
  <img width="478" alt="스크린샷 2021-08-24 오후 1 20 48" src="https://user-images.githubusercontent.com/58394729/130555833-2a0256b9-5e4c-4303-83cb-71e9dc044978.png">


* __년/월/일별 로그인 수 조회__
  - Request URL: http://localhost:8031/20/06/22
  - 20년 6월 22일 로그인수 조회
  - 결과
  <img width="575" alt="스크린샷 2021-08-24 오후 1 20 58" src="https://user-images.githubusercontent.com/58394729/130555872-b050fe53-90b5-4336-8a97-977610f76c8a.png">


* __하루 평균 로그인 수 조회__
  - Request URL: http://localhost:8031/average 
  - 결과
  <img width="446" alt="스크린샷 2021-08-24 오후 1 21 10" src="https://user-images.githubusercontent.com/58394729/130555905-55e79db5-7fb7-4e85-a88d-e2416e59903c.png">

* __부서별 년/월 로그인 수 조회__
  - Request URL: http://localhost:8031/20/06/A
  - 20년 6월 로그인한 A 부서의 로그인수 조회
  - 결과


* __휴일 제외 하루 평균 로그인 수 조회 (차주 구현 필요)__
  - Request URL: http://localhost:8031/average/holiday 
  - 결과
  <img width="511" alt="스크린샷 2021-08-24 오후 1 21 48" src="https://user-images.githubusercontent.com/58394729/130555953-167693dc-896e-4da9-a706-a20118eebe06.png">




