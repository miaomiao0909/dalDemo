package com.ctrip.dal.demo.service;

import com.ctrip.dal.demo.dao.PersonsDao;
import com.ctrip.dal.demo.pojo.Persons;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zh
 * Created on 2022/12/28
 */
@Service
public class PersonService {
    @Autowired
    private PersonsDao personsDao;

    public Map<String, Object> run() throws SQLException {
        HashMap<String, Object> result = Maps.newHashMap();
        List<Persons> personsAtPage1 = personsDao.pageSelect(1, 20);
        Number total = personsDao.selectCount();

        result.put("personsAtPage1", personsAtPage1);
        result.put("total", total);

        return result;

    }
}
