package com.getjavajob.belyaev.validator;

import com.getjavajob.belyaev.model.ModelInterface;
import com.getjavajob.belyaev.model.Telephone;

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
