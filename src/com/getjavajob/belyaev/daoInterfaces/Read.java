/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.getjavajob.belyaev.daoInterfaces;

import com.getjavajob.belyaev.service.DepartmentService;
import com.getjavajob.belyaev.service.EmployeService;
import com.getjavajob.belyaev.service.TelephoneService;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Виталий
 */
public interface Read {
     public void read(EmployeService employe,DepartmentService departmentBase, TelephoneService telephoneBase) throws FileNotFoundException, IOException, Exception;
}
