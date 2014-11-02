package com.getjavajob.phonebook.service;

import com.getjavajob.phonebook.dataBaseDao.DepartmentDao;
import com.getjavajob.phonebook.model.Department;
import com.getjavajob.phonebook.validator.Validator;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private Validator validator;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Transactional
    public Department add(Department department) throws ServiceException {
        if (validator.validate(department)) {
            return departmentDao.add(department);
        } else {
            throw new ServiceException("Fall at departmentAdd");
        }
    }

    @Transactional
    public Department get(String name) throws ServiceException {
        try {
            return departmentDao.get(name);
        } catch (Exception e) {
            throw new ServiceException("Fall at departmentGet", e);
        }
    }

    @Transactional
    public Department update(Department department) throws ServiceException {
        if (validator.validate(department)) {
            return departmentDao.update(department);
        } else {
            throw new ServiceException("Fall at departmentUpdate");
        }
    }

    @Transactional
    public void delete(String name) throws ServiceException {
        try {
            departmentDao.delete(name);
        } catch (Exception e) {
            throw new ServiceException("Fall at departmentDelete", e);
        }
    }

    @Transactional
    public List<Department> getAll() throws ServiceException {
        try {
            return departmentDao.getAll();
        } catch (Exception e) {
            throw new ServiceException("Fall at departmentGetAll");
        }
    }

    {

/*

    private  TreeSet<Department> departmentBase = new TreeSet<>();

    public void setDepartmentBase(TreeSet<Department> departmentBase) {
        this.departmentBase = departmentBase;
    }

    public void setDepartmentBase(List<Department> departmentBase){
        for(Department department: departmentBase){
            this.departmentBase.add(department);
        }
    }

    public TreeSet<Department> getDepartmentBase() {
        return departmentBase;
    }

    public void addDepartment(String name) throws WrongDataEntered {

        Department department = new Department(name);
        if (new Validator().validate(department)) {
            departmentBase.add(department);
        } else {
            throw new WrongDataEntered("Failed at DepartmentValidation");
        }
    }

    public Department getDepartament(String depart) throws WrongDataEntered {
        for (Department department : departmentBase) {
            if (department.getDepartmentName().equals(depart)) {
                return department;
            }
        }
        throw new WrongDataEntered("ThereIsNoSuchDepartment");
    }

    public void setDepartmetChief(Department department , Employe employe) {
        department.setChief(employe);
    }

    public void setAllChiefsById(EmployeService employeService){
        for(Department department: departmentBase){
            try {
                department.setChief(employeService.get(department.getChiefID()));
            } catch (DataNotFound dataNotFound) {
                dataNotFound.printStackTrace();
            }
        }
    }

    public void add(Department department) throws WrongDataEntered {
        if(new Validator().validate(department)){
            departmentBase.add(department);
        }else{
            throw new WrongDataEntered("Department validate failure");
        }
    }
*/
}// old code  delete at final rewiew
}

