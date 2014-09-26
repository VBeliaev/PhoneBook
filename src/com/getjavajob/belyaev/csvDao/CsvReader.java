package com.getjavajob.belyaev.csvDao;

import com.getjavajob.belyaev.daoInterfaces.Read;
import com.getjavajob.belyaev.exeption.DataNotFound;
import com.getjavajob.belyaev.model.Department;
import com.getjavajob.belyaev.model.Employe;
import com.getjavajob.belyaev.service.DepartmentService;
import com.getjavajob.belyaev.service.EmployeService;
import com.getjavajob.belyaev.service.TelephoneService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Виталий on 27.09.2014.
 */
public class CsvReader implements Read {

    @Override
    public void read(EmployeService employeService, DepartmentService departmentService, TelephoneService telephoneService) throws Exception {

    }

    public void readDepartment(DepartmentService departmentService){
        try(BufferedReader br = new BufferedReader(new FileReader("Department.csv"))) {
            String buf;
            while ((buf=br.readLine())!=null){
                String[] splitString = buf.split(" ");
                Department department = new Department();
                if (splitString.length!=3){
                    throw new DataNotFound("File was corrupted");
                }else{
                    department.setDepartmentName(splitString[0]);
                    department.setChiefID(Integer.parseInt(splitString[2]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DataNotFound dataNotFound) {
            dataNotFound.printStackTrace();
        }
    }
}
