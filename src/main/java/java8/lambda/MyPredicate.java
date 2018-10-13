package java8.lambda;

/**
 * @program: java8
 * @description:
 * @author: ChenYu
 * @create: 2018-10-13 16:52
 **/
@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
