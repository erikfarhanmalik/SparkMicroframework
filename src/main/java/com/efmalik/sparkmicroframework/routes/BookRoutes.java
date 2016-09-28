package com.efmalik.sparkmicroframework.routes;

import com.efmalik.sparkmicroframework.dao.BookDao;

/**
 *
 * @author erik
 */
public class BookRoutes extends BaseRoutes {

    public BookRoutes() {
        setBase("book");
        setDao(new BookDao());
    }

}
