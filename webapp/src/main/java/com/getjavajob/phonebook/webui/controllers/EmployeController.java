package com.getjavajob.phonebook.webui.controllers;

import com.getjavajob.phonebook.exeption.ServiceException;
import com.getjavajob.phonebook.model.Employe;
import com.getjavajob.phonebook.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Виталий on 13.10.2014.
 */
@Controller
public class EmployeController {

    public EmployeController() {
    }

    @Autowired
    private EmployeService employeService;


    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        System.out.println("@RequestMapping(\"/try\")");

         return "WEB-INF/jsp/employes.jsp";
      //  return "WEB-INF/jsp/home.jsp";
    }




    @RequestMapping("/employes")
    public String view(
            HttpServletRequest request)
    {
        System.out.println("@RequestMapping(\"/employe\")");
        //try {
            List<Employe> employeList = employeService.getAll();
            int len = employeList.size();
            request.setAttribute("len",len);
            request.setAttribute("employeList", employeList);
        System.out.println(employeList.size());
        //} catch (ServiceException e) {
        //    e.printStackTrace();
       // }
        System.out.println("Before return ");
       return "WEB-INF/jsp/employes.jsp";
       // return "WEB-INF/jsp/home.jsp";
    }

    @RequestMapping("/employeEdit")
    public String employeEdit(HttpServletRequest request)
    {
        //try {
        Employe employe; // how to get id from jsp
        //next we change other values
        // }
        return "WEB-INF/jsp/employe.jsp";
    }
}
