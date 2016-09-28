package com.efmalik.sparkmicroframework.util;

import com.efmalik.sparkmicroframework.model.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.dummycreator.ClassBindings;
import org.dummycreator.ClassUsageInfo;
import org.dummycreator.DummyCreator;
import org.dummycreator.dummyfactories.DummyFactory;

/**
 *
 * @author erik
 */
public class DummyCreatorUtil {

    public class InputStreamBinding extends DummyFactory<FileInputStream> {

        @Override
        public FileInputStream createDummy(Type[] types, Map<String, ClassUsageInfo<?>> map, ClassBindings cb, List<Exception> list) {
            try {
                return new FileInputStream("/home/erik/Documents/KPM_2016_UP_UI - Compensation_Bonus.pdf");
            } catch (FileNotFoundException ex) {
                return null;
            }
        }

    }

    public DummyCreator createDummyCreator() {
        ClassBindings cb = ClassBindings.defaultBindings();
        cb.add(InputStream.class, new InputStreamBinding());
        DummyCreator dummyCreator = new DummyCreator(cb);
        return dummyCreator;
    }

    public Object createDummy(Class c) {
        return createDummyCreator().create(c);
    }

    public List generateListDummy(Class<Book> c, int i) {
        List list = new ArrayList();
        for (int j = 0; j < i; j++) {
            list.add(createDummy(c));
        }
        return list;
    }
}
