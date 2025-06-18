package com.ctrip.dal.demo.dao;

import com.ctrip.dal.demo.pojo.Persons;
import com.ctrip.platform.dal.dao.DalHints;
import com.ctrip.platform.dal.dao.base.DalTableOperations;
import com.ctrip.platform.dal.dao.base.SQLArg;
import com.ctrip.platform.dal.dao.base.SQLArgList;
import com.ctrip.platform.dal.dao.base.SQLResult;
import com.ctrip.platform.dal.dao.client.DalOperationsFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zh
 * Created on 2022/12/28
 */
@Component
public class PersonsDao {
    private final DalTableOperations<Persons> DAL_TABLE_OPERATIONS = DalOperationsFactory.getDalTableOperations(Persons.class);

    public List<Persons> pageSelect(int pageNo, int pageSize) throws SQLException {
        return DAL_TABLE_OPERATIONS.query("", new DalHints(), SQLResult.page(pageNo, pageSize));
    }

    public Persons selectOneByAddress(String address) throws SQLException {
        return DAL_TABLE_OPERATIONS.queryObject("Address = ?", new DalHints(), address);
    }

    public List<Persons> selectListBy(String firstName, String lastName, String address) throws SQLException {
        StringBuilder sql = new StringBuilder();
        SQLArgList args = SQLArg.list();
        if (StringUtils.isNotBlank(firstName)){
            sql.append(" FirstName = ? ");
            args.add(firstName);
        }

        if (StringUtils.isNotBlank(lastName)){
            sql.append(" LastName = ? ");
            args.add(lastName);
        }

        if (StringUtils.isNotBlank(address)){
            sql.append(" Address = ? ");
            args.add(address);
        }
        return DAL_TABLE_OPERATIONS.query(sql.toString(), new DalHints(), args);
    }

    public Number selectCount() throws SQLException {
        return DAL_TABLE_OPERATIONS.count("", new DalHints());
    }

    public int insertOne(Persons persons) throws SQLException {
        return DAL_TABLE_OPERATIONS.insert(new DalHints(), persons);
    }
}
