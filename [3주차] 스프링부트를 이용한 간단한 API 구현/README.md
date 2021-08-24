
# [3주차 과제] Spring Boot를 사용하여 간단한 API 구현 & SQL문 작성

### Contents 
* [Spring Boot로 간단한 API 구현](#spring-boot로-간단한-api-구현)

* [SQL문 문서](https://github.com/noohk329/comento-workspace/blob/main/%5B3%EC%A3%BC%EC%B0%A8%5D%20%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8%EB%A5%BC%20%EC%9D%B4%EC%9A%A9%ED%95%9C%20%EA%B0%84%EB%8B%A8%ED%95%9C%20API%20%EA%B5%AC%ED%98%84/%5B4%EC%A3%BC%EC%B0%A8%5D%20SQL%EB%AC%B8.pdf)






## Spring Boot로 간단한 API 구현


### 1. Spring Boot 개발환경 세팅
* __디렉토리__

   <img width="357" alt="스크린샷 2021-08-24 오후 1 45 16" src="https://user-images.githubusercontent.com/58394729/130557247-9cd5c4b3-3e97-43ce-b47e-ee3257b5a785.png">

* __개발환경 세팅 완료__: http://localhost:8031/test

   <img width="256" alt="스크린샷 2021-08-23 오후 9 49 23" src="https://user-images.githubusercontent.com/58394729/130557099-7fb85a59-a933-419d-b3de-a97b7aed3001.png">

### 2. Database 데이터 추가 (requestInfo, user)
* __requestInfo 테이블__

   <img width="281" alt="스크린샷 2021-08-24 오후 1 41 06" src="https://user-images.githubusercontent.com/58394729/130556849-33e094f8-1904-4f41-834d-1fec21bec8e2.png">

* __user 테이블__

   <img width="195" alt="스크린샷 2021-08-24 오후 1 41 17" src="https://user-images.githubusercontent.com/58394729/130556873-b73c3c70-24f2-455e-9dcb-8b5681fd5ac6.png">


### 3. mapper 작성 (statisticMapper.java, statisticMapper.xml)
* __statisticMapper.xml__
```xml:statisticMapper.xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    
<mapper namespace="com.devfun.settingweb_boot.dao.StatisticMapper">
 
    <select id="selectYearLogin" parameterType="string" resultType="hashMap">
        select count(*) as totCnt
        from statistc.requestinfo ri
        where left(ri.createDate, 2) = #{year};
    </select>
    
    <select id="selectYearMonthLogin" parameterType="string" resultType="hashMap">
        select count(*) as totCnt
        from statistc.requestinfo ri
        where left(ri.createDate, 2) = #{year} and mid(ri.createDate, 3, 2) = #{month};
    </select>
    
    <select id="selectYearMonthDateLogin" parameterType="string" resultType="hashMap">
        select count(*) as totCnt
        from statistc.requestinfo ri
        where left(ri.createDate, 2) = #{year} 
        and mid(ri.createDate, 3, 2) = #{month} 
        and mid(ri.createDate, 5, 2) = #{date};
    </select>
    
    <select id="selectAverageLogin" parameterType="string" resultType="hashMap">
        select count(*)/
(select count(distinct(substring(ri.createDate, 1, 6))) from statistc.requestInfo ri) as average
from statistc.requestInfo;
    </select>
    
    <select id="selectAverageHolidayLogin" parameterType="string" resultType="hashMap">
        select count(*)/
(select count(distinct(substring(ri.createDate, 1, 6))) from statistc.requestInfo ri) as average
from statistc.requestInfo;
    </select>
    
    <select id="selectOrganLogin" parameterType="string" resultType="hashMap">
        select count(*) as totCnt 
		from statistc.requestInfo ri, statistc.user
		where ri.userID = user.userID
		and left(ri.createDate, 2) = #{year} and mid(ri.createDate, 3, 2) = #{month} 
		and HR_ORGAN = #{organ};
    </select>
    
</mapper>
```
* __statisticMapper.java__
```java:statisticMapper.java
public interface  StatisticMapper {
    public HashMap<String, Object> selectYearLogin(String year);
    
    public HashMap<String, Object> selectYearMonthLogin(String year, String month);
    
    public HashMap<String, Object> selectYearMonthDateLogin(String year, String month, String date);
 
    public HashMap<String, Object> selectAverageLogin();
    
    public HashMap<String, Object> selectAverageHolidayLogin();
    
    public HashMap<String, Object> selectOrganLogin(String year, String month, String organ);
    
    
}
```

### 4. Service 작성 및 settingTest.java 코드 추가
* __service 로직 코드__
```java:settingTest.java
    @Autowired
    private StatisticMapper uMapper;
    
    @Override
    public HashMap<String, Object> yearloginNum (String year) {
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.selectYearLogin(year);
            retVal.put("year", year);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("year", year);
            retVal.put("is_success", false);
        }
        
        return retVal;
    }

	@Override
	public HashMap<String, Object> yearmonthloginNum(String year, String month) {
		HashMap<String, Object> retVal = new HashMap<String,Object>();
        
		try {
            retVal = uMapper.selectYearMonthLogin(year, month);
            retVal.put("year", year);
            retVal.put("month", month);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("year", year);
            retVal.put("month", month);
            retVal.put("is_success", false);
        }
        
        return retVal;
	}
	
	@Override
	public HashMap<String, Object> yearmonthdateloginNum(String year, String month, String date) {
		HashMap<String, Object> retVal = new HashMap<String,Object>();
        
		try {
            retVal = uMapper.selectYearMonthDateLogin(year, month, date);
            retVal.put("year", year);
            retVal.put("month", month);
            retVal.put("date", date);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("year", year);
            retVal.put("month", month);
            retVal.put("date", date);
            retVal.put("is_success", false);
        }
        
        return retVal;
	}

	@Override
	public HashMap<String, Object> averageloginNum() {
		HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.selectAverageLogin();
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("is_success", false);
        }
        
        return retVal;
	}

	@Override
	public HashMap<String, Object> organloginNum(String year, String month, String organ) {
		HashMap<String, Object> retVal = new HashMap<String,Object>();
        
		try {
            retVal = uMapper.selectOrganLogin(year, month, organ);
            retVal.put("year", year);
            retVal.put("month", month);
            retVal.put("organ", organ);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("year", year);
            retVal.put("month", month);
            retVal.put("organ", organ);
            retVal.put("is_success", false);
        }
        
        return retVal;
	}

	@Override
	public HashMap<String, Object> averageholidayloginNum() {
		HashMap<String, Object> retVal = new HashMap<String,Object>();
        
		try {
            retVal = uMapper.selectAverageHolidayLogin();
            retVal.put("exclude_holiday", true);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("exclude_holiday", true);
            retVal.put("is_success", false);
        }
        
        return retVal;
	}
 
```
* __settingTest.java 코드__
```java:settingTest.java

@Controller
public class settingTest {
    
 
    @Autowired
    private StatisticService service;
    
    @ResponseBody 
    @RequestMapping("/login/{year}")
    public Map<String, Object> loginsqltest(@PathVariable("year") String year) throws Exception{ 
        
        return service.yearloginNum(year);
    }
    
    @ResponseBody 
    @RequestMapping("/login/{year}/{month}")
    public Map<String, Object> loginsqltest(@PathVariable("year") String year, @PathVariable("month")String month) throws Exception{ 
        
        return service.yearmonthloginNum(year, month);
    }
    
    @ResponseBody 
    @RequestMapping("/login/{year}/{month}/{param}")
    public Map<String, Object> loginsqltest(@PathVariable("year") String year, @PathVariable("month") String month, @PathVariable("param") String param) throws Exception{ 
    	if (param.length()==1) { // organ 
    		return service.organloginNum(year, month, param);
    	} else { // date
    		return service.yearmonthdateloginNum(year, month, param);
    	}
        
    }
    
    @ResponseBody 
    @RequestMapping("/average")
    public Map<String, Object> averagesqltest() throws Exception{ 
        
        return service.averageloginNum();
    }
    
    @ResponseBody 
    @RequestMapping("/average/holiday")
    public Map<String, Object> averageholidaysqltest() throws Exception{ 
    	
    	return service.averageholidayloginNum();
    	
    }
 
    @RequestMapping("/test") 
    public ModelAndView test() throws Exception{ 
        ModelAndView mav = new ModelAndView("test"); 
        mav.addObject("name", "devfunpj"); 
        List<String> resultList = new ArrayList<String>(); 
        resultList.add("!!!HELLO WORLD!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!!!"); 
        resultList.add("설정 TEST!!!!!!"); 
        mav.addObject("list", resultList); 
        return mav; 
    }
 
}
```

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




