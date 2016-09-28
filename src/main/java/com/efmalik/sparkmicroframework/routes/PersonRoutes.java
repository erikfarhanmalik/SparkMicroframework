package com.efmalik.sparkmicroframework.routes;

import com.efmalik.sparkmicroframework.dao.PersonDao;

/**
 *
 * @author erik
 */
public class PersonRoutes extends BaseRoutes {

    public PersonRoutes() {
        setBase("person");
        setDao(new PersonDao());
    }

}
