package com.getjavajob.phonebook.validator;

import com.getjavajob.phonebook.model.Department;
import com.getjavajob.phonebook.model.ModelInterface;
import org.springframework.stereotype.Component;

@Component
public class DepartmentValidator implements ValidInterface {

    private Department department;

    public DepartmentValidator() {
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean validate(ModelInterface mi) {
        setDepartment((Department) mi);
        return (department.getDepartmentName().matches("[a-zA-Z0-9]+"));
    }
}
