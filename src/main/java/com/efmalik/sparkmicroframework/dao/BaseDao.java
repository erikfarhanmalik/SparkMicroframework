package com.efmalik.sparkmicroframework.dao;

import com.efmalik.sparkmicroframework.util.DummyCreatorUtil;

/**
 *
 * @author erik
 */
public class BaseDao {

    private Class classObject;

    public Object list() {
        return new DummyCreatorUtil().generateListDummy(classObject, 10);
    }

    public Object get(Integer id) {
        return new DummyCreatorUtil().createDummy(classObject);
    }

    public Class getClassObject() {
        return classObject;
    }

    public void setClassObject(Class classObject) {
        this.classObject = classObject;
    }

}
