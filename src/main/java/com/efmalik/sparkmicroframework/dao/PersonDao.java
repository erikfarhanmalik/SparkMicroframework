package com.efmalik.sparkmicroframework.dao;

import com.efmalik.sparkmicroframework.model.Person;

/**
 *
 * @author erik
 */
public class PersonDao extends BaseDao {

    public PersonDao() {
        setClassObject(Person.class);
    }

}
