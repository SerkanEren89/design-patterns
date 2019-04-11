package singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton design pattern
 *
 * @author eren
 */
public class SingletonExample {

    private static List<String> stringList;

    private SingletonExample() {}

    public static synchronized List<String> getInstance() {
        if (stringList == null) {
            stringList = new ArrayList<>();
        }
        return stringList;
    }
}
