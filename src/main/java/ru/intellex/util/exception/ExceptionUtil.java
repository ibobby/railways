package ru.intellex.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by b.istomin on 20.05.2015.
 */
public class ExceptionUtil {

    private static Logger LOG = LoggerFactory.getLogger(ExceptionUtil.class);

    public static void check(boolean found, int id) {
        check(found, "id = " + id);
    }

    public static void check(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException(msg);
        }
    }

    public static <T> T check(T object, int id) {
        return check(object, "id = " + id);
    }

    public static <T> T check(T object, String msg) {
        if (object == null) {
            throw new NotFoundException("Not found entity for " + msg);
        }
        return object;
    }

}
