package java8inaction;

import java.util.function.Predicate;

public class FucntionCase {



    public static <T> boolean testPredicate(Predicate<T> p, T t) {

        return p.test(t);
    }

}
