package com.getjavajob.phonebook.validator;

import com.getjavajob.phonebook.model.ModelInterface;
import com.getjavajob.phonebook.model.Telephone;

public class PhoneValidator implements ValidInterface{
    private Telephone telephone;

    private void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean validate(ModelInterface mi) {
        setTelephone((Telephone) mi);
        return (telephone.toString().matches("[+][0-9]{1,4}[(][0-9]{1,4}[)][0-9]{6,11}[(].+[)]")&& telephone.getClientId()>0);
    }
}
