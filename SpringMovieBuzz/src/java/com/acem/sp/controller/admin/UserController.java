/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acem.sp.controller.admin;


import com.acem.sp.dao.UserDAO;

import com.acem.sp.entity.User;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author AshwinKArki
 */
@Controller
@RequestMapping(value="/user/*")
public class UserController {
     
  
   
   @Autowired
   private UserDAO userDAO;
   
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String index(){
        return "user/index";
    }
    
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String save(@RequestParam("email") String email,@RequestParam("password") String password,HttpServletRequest request,HttpSession session){
     
       for(User a:userDAO.getAll()){
           if(email.equalsIgnoreCase(a.getUserEmail()) && password.equalsIgnoreCase(a.getUserPassword())){
           request.getSession().setAttribute("loggedin",true);
           session.setAttribute("name",a.getUserEmail());
           
            return "redirect:/user/dashboard";
       }
       }
       return "redirect:/user/login?error";
    }
    
    @RequestMapping(value="/dashboard",method=RequestMethod.GET)
    public String adminPage(HttpServletRequest request,Model model){
       HttpSession session=request.getSession(false);
        if(session!=null && session.getAttribute("loggedin")!=null && (boolean)session.getAttribute("loggedin")){
             
                      return "user/dashboard";
         }
        return "redirect:/user/login?error";
    }
    
     
   
    
     
      
        
    }
