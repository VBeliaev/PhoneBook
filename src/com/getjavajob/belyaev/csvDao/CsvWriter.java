package com.getjavajob.belyaev.csvDao;

import com.getjavajob.belyaev.daoInterfaces.Write;
import com.getjavajob.belyaev.model.Department;
import com.getjavajob.belyaev.model.Employe;
import com.getjavajob.belyaev.model.Telephone;
import com.getjavajob.belyaev.service.DepartmentService;
import com.getjavajob.belyaev.service.EmployeService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Виталий on 27.09.2014.
 */
public class CsvWriter implements Write {

    private DepartmentService departmentService;
    private EmployeService employeService;

    @Override
    public void write(EmployeService employeService, DepartmentService departmentService) {
        this.departmentService=departmentService;
        this.employeService=employeService;

    }

    private void writeEmployer(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Employe.emp"))){
            for(Employe employe: employeService.getEmployeBase()){
                bw.write(employe.getId() + " " + employe.getName() + " " + employe.getSurname() + " " + " " + employe.getProjectName() +" " + employe.getDepartment().getDepartmentName() + " " + employe.getEmail());
                for(Telephone telephone: employe.getTelephone()){
                    bw.write(" " + telephone.toString());
                }
                 bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void wrireDepartment(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Department.csv"))){
            for (Department department :  departmentService.getDepartmentBase()){
                bw.write(department.getDepartmentName()+ " " + department.getChief().getName() + " " + department.getChief().getId());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
