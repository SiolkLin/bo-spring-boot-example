package io.bigobject.demo.ctrl;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.bigobject.demo.bean.Company;
import io.bigobject.demo.bean.User;
import io.bigobject.demo.dao.CompanyRepository;
import io.bigobject.demo.dao.UserRepository;
import io.bigobject.demo.service.IndexService;

@RestController
public class IndexCtrl {
	@Autowired IndexService indexService;
	@RequestMapping("/home")
	public Map<String,Object> home(){
		
		Map<String,Object> data = new LinkedHashMap<String, Object>();
		
		try {
			indexService.addUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data.put("data",indexService.queryUsers());
		return data;			
	}
	
	@RequestMapping("/home2")
	public Map<String,Object> home2(){
		
		Map<String,Object> data = new LinkedHashMap<String, Object>();
		
		try {
			indexService.addUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data.put("data",indexService.queryUsersByNativeSql());
		return data;			
	}
	
	@RequestMapping("/testSql")
	public Map<String,Object> testSql(HttpServletRequest req){
		String sql = req.getParameter("sql");
		Map<String,Object> data = new LinkedHashMap<String, Object>();
		data.put("data",indexService.list(sql));
		return data;			
	}
}
