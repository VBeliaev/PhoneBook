/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getjavajob.phonebook.validator;

import com.getjavajob.phonebook.model.ModelInterface;
import org.springframework.stereotype.Component;


/**
 *
 * @author Виталий
 */
@Component
public interface ValidInterface {
    
    boolean validate(ModelInterface mi);
    
}
