/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.getjavajob.phonebook.daoInterfaces;

import com.getjavajob.phonebook.service.DepartmentService;
import com.getjavajob.phonebook.service.EmployeService;
import com.getjavajob.phonebook.service.TelephoneService;

/**
 *
 * @author Виталий
 */
public interface Read {
     public void read(EmployeService employe,DepartmentService departmentBase, TelephoneService telephoneBase) throws Exception;
}
