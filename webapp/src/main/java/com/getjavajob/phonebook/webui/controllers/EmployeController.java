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

    @Autowired
    private EmployeService employeService;

    @RequestMapping("/employe")
    public String view(
            HttpServletRequest request)
    {
        //try {
            List<Employe> employeList = employeService.getAll();
            int len = employeList.size();
            request.setAttribute("len",len);
            request.setAttribute("employeList", employeList);
        //} catch (ServiceException e) {
        //    e.printStackTrace();
       // }
        return "/WEB-INF/jsp/employe.jsp";
    }
}
