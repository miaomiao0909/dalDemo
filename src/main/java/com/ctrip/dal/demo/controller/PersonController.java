package com.ctrip.dal.demo.controller;

import com.ctrip.dal.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zh
 * Created on 2022/12/28
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/run")
    public Object run() {
        try {
            return personService.run();
        } catch (Exception e){
            return String.format("Run Error. Exception is %s", e.getMessage());
        }
    }
}
