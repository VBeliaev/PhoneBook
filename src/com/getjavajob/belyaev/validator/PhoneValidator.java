package com.getjavajob.belyaev.validator;

import com.getjavajob.belyaev.model.ModelInterface;
import com.getjavajob.belyaev.model.Telephone;

public class PhoneValidator implements ValidInterface{
    private Telephone telephone;

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean validate(ModelInterface mi) {
        setTelephone((Telephone) mi);
        String[] arr = telephone.showNumber().split(" ");
        return ((arr.length==4) && arr[0].matches("[0-9]{1,4}") && arr[1].matches("[0-9]{1,4}") && arr[2].matches("[0-9]{6}") && arr[3].matches("[tf][ra][ul][es].*"));
    }
}
