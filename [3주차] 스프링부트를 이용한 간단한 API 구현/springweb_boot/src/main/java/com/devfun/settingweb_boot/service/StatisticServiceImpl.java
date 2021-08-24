package com.devfun.settingweb_boot.service;
 
 
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.devfun.settingweb_boot.dao.StatisticMapper;
 
@Service
public class StatisticServiceImpl implements StatisticService {
    
    
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
 
}