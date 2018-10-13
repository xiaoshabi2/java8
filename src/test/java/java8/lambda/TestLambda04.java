package java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @program: java8
 * @description:
 * @author: ChenYu
 * @create: 2018-10-13 20:24
 **/
/*
    java 内置的四大核心函数式接口

     1.Consumer<T> :消费型接口
            void accept(T t);

     2.Supplier<T> :供给型接口
            T get();

     3.Function<T,R> :函数型接口
            R apply(T t);

     4. Predicate<T> : 断言型接口
            boolean test(T t);

* */
public class TestLambda04 {


    /*
         1.Consumer<T> :消费型接口
          void accept(T t);
    * */
    @Test
    public void test(){
        happy(10000,(x) -> System.out.println("消费 " + x +  "元"));
    }
    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }


    /*
     2.Supplier<T> :供给型接口
     T get();
    */

    /* 产生指定个数的整数 并放入 集合中*/
    @Test
    public void test2(){
        List<Integer> list = getNumList(10,() -> (int) (Math.random() * 100));
        list.stream().forEach(System.out::println);
    }

    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }




    /*
        3.Function<T,R> :函数型接口
        R apply(T t);
    */

    /*
       用于处理字符串
    * */
    @Test
    public void test3(){
        System.out.println(strHandler("\t\t\t Hello World ", str -> str.replaceAll(" ", "")));
        System.out.println(strHandler("  \t\t\t Hello World  ", str -> str.trim()));
        System.out.println(strHandler(" add \t\t\t Hello World  ", str -> str.toUpperCase()));
        System.out.println(strHandler(" add \t\t\t Hello World  ", str -> str.substring(0,4)));
    }

    public String strHandler(String str, Function<String,String> function){
        return function.apply(str);
    }


   /*

     4. Predicate<T> : 断言型接口
          boolean test(T t);
    */

    /*
       把满足条件的字符串放入集合中
    * */
    @Test
    public void test4(){
        List<String> list = Arrays.asList("hello","test","aaa","www","ok");
        List<String> resList = filterStr(list,s -> s.length()>=3);
        resList.stream().forEach(System.out::println);
    }

    public List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> reslist = new ArrayList<>();
        for (String s : list) {
            if(predicate.test(s)){
                reslist.add(s);
            }
        }
        return reslist;
    }




}
