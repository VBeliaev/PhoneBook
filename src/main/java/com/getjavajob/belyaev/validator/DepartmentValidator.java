package com.getjavajob.belyaev.validator;

import com.getjavajob.belyaev.model.Department;
import com.getjavajob.belyaev.model.ModelInterface;

public class DepartmentValidator implements ValidInterface {

    private Department department;

    
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean validate(ModelInterface mi) {
        setDepartment((Department) mi);
        return (department.getDepartmentName().matches("[a-zA-Z0-9]+"));
    }
}
