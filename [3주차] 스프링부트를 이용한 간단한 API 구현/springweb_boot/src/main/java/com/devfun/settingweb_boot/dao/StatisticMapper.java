package com.devfun.settingweb_boot.dao;
import java.util.HashMap;
 
import com.devfun.settingweb_boot.dto.StatisticDto;
 
public interface  StatisticMapper {
    public HashMap<String, Object> selectYearLogin(String year);
    
    public HashMap<String, Object> selectYearMonthLogin(String year, String month);
    
    public HashMap<String, Object> selectYearMonthDateLogin(String year, String month, String date);
 
    public HashMap<String, Object> selectAverageLogin();
    
    public HashMap<String, Object> selectAverageHolidayLogin();
    
    public HashMap<String, Object> selectOrganLogin(String year, String month, String organ);
    
    
}