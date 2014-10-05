package com.getjavajob.phonebook.validator;

import com.getjavajob.phonebook.model.Employe;
import com.getjavajob.phonebook.model.ModelInterface;

public class EmployeValidator implements ValidInterface {

    private Employe employe;

    public EmployeValidator() {
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    @Override
    public boolean validate(ModelInterface mi) {
        setEmploye((Employe) mi);
        return (emailValidate() && nameValidate() && surnameValidate() && projectValidate());
    }

    private boolean projectValidate() {
        String project = employe.getProjectName();
        return (project.matches("[a-zA-Z0-9]+"));
    }

    private boolean nameValidate() {
        return (employe.getName().matches("[a-zA-Z]+"));
    }

    private boolean surnameValidate() {
        return (employe.getSurname().matches("[a-zA-Z]+"));
    }

    private boolean emailValidate() {
        String email = employe.getEmail();
        return (email.matches(".+@.+[.].*"));
    }

}
