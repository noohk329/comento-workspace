package com.devfun.settingweb_boot.test;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
import com.devfun.settingweb_boot.dao.StatisticMapper;
import com.devfun.settingweb_boot.service.StatisticService;
 
 
 
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