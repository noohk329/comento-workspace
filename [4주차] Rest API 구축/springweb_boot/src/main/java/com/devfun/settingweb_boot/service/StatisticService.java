package com.devfun.settingweb_boot.service;
 
import java.util.HashMap;
 
public interface StatisticService {
    public HashMap<String,Object> yearloginNum (String year);
    
    public HashMap<String,Object> yearmonthloginNum (String year, String month);
    
    public HashMap<String,Object> yearmonthdateloginNum (String year, String month, String date);
    
    public HashMap<String,Object> averageloginNum ();
    
    public HashMap<String,Object> averageholidayloginNum ();
    
    public HashMap<String,Object> organloginNum (String year, String month, String organ);
    
}