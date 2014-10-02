

package com.getjavajob.belyaev.service;

import com.getjavajob.belyaev.exeption.WrongDataEntered;
import com.getjavajob.belyaev.model.Employe;
import com.getjavajob.belyaev.model.Telephone;
import com.getjavajob.belyaev.validator.Validator;

import java.util.TreeSet;

/**
 * @author Виталий
 */
public class TelephoneService {
    private  TreeSet<Telephone> telephoneBase = new TreeSet<>();

    public  TreeSet<Telephone> getTelephoneBase() {
        return telephoneBase;
    }

    public  void add(int country, int city, int number, boolean isMobile, Employe employe) throws WrongDataEntered {
        Telephone tel = new Telephone(country, city, number, isMobile, employe.getId());
        if (new Validator().validate(tel)) {
            employe.addTelephone(tel);
            telephoneBase.add(tel);
        }else{
            throw new WrongDataEntered("Phone validate failure");
        }
    }

    public void add(String phone, int id) throws WrongDataEntered {
        Telephone telephone = new Telephone().fromString(phone, id);
        if(new Validator().validate(telephone)){
            telephoneBase.add(telephone);
        }else{
            throw new WrongDataEntered("Phone validate failure");
        }
    }

    public  void add(Telephone telephone) throws WrongDataEntered {
        if(new Validator().validate(telephone)) {
            telephoneBase.add(telephone);
        }else{
            throw new WrongDataEntered("Phone validate failure");
        }
    }

    public void add(TreeSet<Telephone> phones) throws WrongDataEntered {
        for(Telephone telephone: phones){
            add(telephone);
        }
    }
}
