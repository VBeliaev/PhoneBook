package com.getjavajob.belyaev.csvDao;

import com.getjavajob.belyaev.daoInterfaces.Read;
import com.getjavajob.belyaev.exeption.DataNotFound;
import com.getjavajob.belyaev.exeption.WrongDataEntered;
import com.getjavajob.belyaev.model.Department;
import com.getjavajob.belyaev.model.Employe;
import com.getjavajob.belyaev.model.Telephone;
import com.getjavajob.belyaev.service.DepartmentService;
import com.getjavajob.belyaev.service.EmployeService;
import com.getjavajob.belyaev.service.TelephoneService;
import com.getjavajob.belyaev.validator.Validator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/**
 * Created by ${Виталий} on ${27.09.2014.}
 */
public class CsvReader implements Read {

    private Validator validator = new Validator();

    @Override
    public void read(EmployeService employeService, DepartmentService departmentService, TelephoneService telephoneService) throws Exception {

    }

    private void readEmploye(EmployeService employeService, DepartmentService departmentService,TelephoneService telephoneService){
        try(BufferedReader br= new BufferedReader(new FileReader("Employe.csv"))){
            String buf;
            while((buf=br.readLine())!=null){
                String[] splitString = buf.split(" ");
                Employe employe = new Employe();
                employe.setId(Integer.parseInt(splitString[0]));
                employe.setName(splitString[1]);
                employe.setSurname(splitString[2]);
                employe.setProjectName(splitString[3]);
                employe.setDepartment(departmentService.getDepartament(splitString[4]));
                employe.setEmail(splitString[5]);
                if (splitString.length>5) {
                    TreeSet<Telephone> set = addPhones(employe,splitString);
                    employe.setTelephone(set);
                    telephoneService.add(set);
                }
            }
        } catch (IOException | WrongDataEntered e) {
            e.printStackTrace();
        }
    }
    private void readDepartment(DepartmentService departmentService) {
        try (BufferedReader br = new BufferedReader(new FileReader("Department.csv"))) {
            String buf;
            while ((buf = br.readLine()) != null) {
                String[] splitString = buf.split(" ");
                Department department = new Department();
                if (splitString.length != 3) {
                    throw new DataNotFound("File was corrupted");
                } else {
                    department.setDepartmentName(splitString[0]);
                    department.setChiefID(Integer.parseInt(splitString[2]));
                    departmentService.add(department);
                }
            }
        } catch (IOException | DataNotFound | WrongDataEntered e) {
            e.printStackTrace();
        }
    }
        private TreeSet<Telephone> addPhones(Employe employe, String[] splitString) {
            Validator validator = new Validator();
            Telephone telephone = new Telephone();
            TreeSet<Telephone> setPhone = new TreeSet<>();
            for (int i = 6; i < splitString.length; i++) {
                telephone = telephone.fromString(splitString[i], employe.getId());
                if (validator.validate(telephone)) {
                    setPhone.add(telephone);
                }
            }
            return setPhone;
        }
    }