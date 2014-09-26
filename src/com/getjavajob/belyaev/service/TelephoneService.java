

package com.getjavajob.belyaev.service;

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

    public  void addTelephone(int country, int city, int number, boolean isMobile, Employe employe) {
        Telephone tel = new Telephone(country, city, number, isMobile, employe.getId());
        if (new Validator().validate(tel)) {
            employe.addTelephone(tel);
            telephoneBase.add(tel);
        }
    }

    public  void addTelephone(Telephone telephone){
        telephoneBase.add(telephone);
    }
}
