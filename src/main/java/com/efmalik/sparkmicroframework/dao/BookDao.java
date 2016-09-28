package com.efmalik.sparkmicroframework.dao;

import com.efmalik.sparkmicroframework.model.Book;

/**
 *
 * @author erik
 */
public class BookDao extends BaseDao {

    public BookDao() {
        setClassObject(Book.class);
    }

}
