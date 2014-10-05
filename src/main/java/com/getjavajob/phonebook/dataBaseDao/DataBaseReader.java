package com.getjavajob.phonebook.dataBaseDao;


import com.getjavajob.phonebook.daoInterfaces.Read;
import com.getjavajob.phonebook.exeption.DataNotFound;
import com.getjavajob.phonebook.model.Department;
import com.getjavajob.phonebook.model.Employe;
import com.getjavajob.phonebook.model.Telephone;
import com.getjavajob.phonebook.service.DepartmentService;
import com.getjavajob.phonebook.service.EmployeService;
import com.getjavajob.phonebook.service.TelephoneService;

import java.sql.*;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseReader implements Read {

    private Connection con = new Connect().connect();

    @Override
    public void read(EmployeService employeService, DepartmentService departmentService, TelephoneService telephoneService) throws Exception {
        readDepartment(departmentService);
        try (Statement s = con.createStatement()) {
            ResultSet rs = s.executeQuery("Select * from Employe");
            while (rs.next()) {
                String name = rs.getString("firstName");
                String surname = rs.getString("surname");
                String ProcName = rs.getString("projectName");
                String department = rs.getString("department");
                String email = rs.getString("email");
                int id = rs.getInt("id");
                TreeSet<Telephone> clientSet = new TreeSet<>();
                try (PreparedStatement ps = con.prepareStatement("Select * from Telephone where clientid = ?")) {
                    ps.setInt(1, id);
                    ResultSet telList = ps.executeQuery();
                    while (telList.next()) {
                        Telephone telephone = new Telephone();
                        telephone.setCountryCode(telList.getInt("codeCountry"));
                        telephone.setCityCode(telList.getInt("codeCity"));
                        telephone.setNumber(telList.getInt("phoneNumber"));
                        telephone.setMobile(telList.getBoolean("mobile"));
                        telephone.setClientId(telList.getInt("clientid"));
                        clientSet.add(telephone);
                        telephoneService.getTelephoneBase().add(telephone);
                    }
                }
                Department dep = findByName(department, departmentService);
                employeService.getEmployeBase().add(new Employe(name, surname, ProcName, dep, clientSet, email, id));
            }

        } catch (DataNotFound ex) {
            Logger.getLogger(DataBaseReader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void readDepartment(DepartmentService departmentService) throws SQLException {
        try (Statement s = con.createStatement()) {
            ResultSet rs = s.executeQuery("Select * from Department");
            while (rs.next()) {
                String department = rs.getString("department");
                int chiefid = rs.getInt("chief_id");
                departmentService.getDepartmentBase().add(new Department(department, chiefid));
            }
        }
    }

    private Department findByName(String departmentName, DepartmentService departmentService) throws DataNotFound {
        for (Department dep : departmentService.getDepartmentBase()) {
            if (dep.getDepartmentName().equals(departmentName)) {
                return dep;
            }
        }
        throw new DataNotFound("department wasn't found");
    }
}
