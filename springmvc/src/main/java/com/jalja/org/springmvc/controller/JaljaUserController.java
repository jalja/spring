package com.jalja.org.springmvc.controller;

import com.github.pagehelper.PageInfo;
import com.jalja.org.springmvc.model.JaljaUser;
import com.jalja.org.springmvc.service.JaljaUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class JaljaUserController {
	
	
    @Autowired
    private JaljaUserService jaljaUserService;

    
    @GetMapping(value = "getArticle")
    public String getArticle() throws Exception{
        return "/article/index";
    }
    @GetMapping(value = "getDetails")
    public String getDetails(Long id,Model model) throws Exception{
    	model.addAttribute("deta", jaljaUserService.getDetails(id));
        return "/article/details";
    }
    
    
    
    @GetMapping(value = "getJaljaUsers")
    public String getJaljaUsers(Integer pageNum,Integer pageSize,Model model) throws Exception{
        PageInfo<JaljaUser> pageInfo=jaljaUserService.getJaljaUsers(pageNum,pageSize);
        List<JaljaUser> lists=pageInfo.getList();
        model.addAttribute("lists",lists);
        return "/index";
    }
   
    @GetMapping(value = "addUser")
    @ResponseBody
    public boolean addUser(){
        return jaljaUserService.addUser();
    }
    @GetMapping(value = "getSearch")
    @ResponseBody
    public Object getSearch(String search,Date time,Integer pageNum,Integer pageSize) {
    	pageNum=(pageNum==null || pageNum==0)==true?0:pageNum;
    	pageSize=(pageSize==null || pageSize==0)==true?0:pageSize;
		return jaljaUserService.getSearch(search,pageNum,pageSize);
    	
    }
}
