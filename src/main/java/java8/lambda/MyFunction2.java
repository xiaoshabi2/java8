package java8.lambda;

/**
 * @program: java8
 * @description:
 * @author: ChenYu
 * @create: 2018-10-13 20:16
 **/
@FunctionalInterface
public interface MyFunction2<T,R> {
    R getValue(T t1,T t2);
}
