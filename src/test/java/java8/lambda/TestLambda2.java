package java8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @program: java8
 * @description:
 * @author: ChenYu
 * @create: 2018-10-13 18:37
 **/

/*  左侧：Lambda 表达式参数列表
*   右侧：Lambda  表达式所需执行的功能 即 Lambda 体
*
*   多用于匿名内部类
*   语法格式一 ： 无参数，无返回值
*   （）->System.out.println("Hello Lambda!");
*
*    语法格式二： 一个参数，无返回值
*        只有一个参数 小括号 可以不写
*
*   语法格式三：多个参数,有返回值  并且Lambda 体中有多条语句
*
*       Comparator<Integer> com = (o1, o2) -> {
*          System.out.println("函数式接口");
*          return o1.compareTo(o2);
*       };
*
*      语法格式四： 若 Lambda 体只有一条语句 return 和 大括号都可以不写
*
*       语法格式五： 若 Lambda 表达式 的参数列表 的数据类型 可以省略不写，因为JAVA JVM 可以
*       通过上下文推断出 数据类型 即 “类型推断”
*
*       二.Lambda 表达式 需要“函数式接口” 的支持
*       函数式接口： 接口中只有一个抽象方法的接口 ， 称为 函数式接口 可以使用注解
*         @FunctionalInterface 修饰 可以检查接口是否是函数式接口
*
* */

public class TestLambda2 {

    @Test
    public void test1(){
        int num = 0;  // jdk 1.7前  必须final  1.8 后系统默认加上

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World !" + num);
            }
        };
        r.run();

        System.out.println("================");
        Runnable r1 = () -> System.out.println("Hello Lambda");
        r1.run();

    }


    @Test
    public void test2(){
        Consumer<String> con = (x) -> System.out.println("x");
        con.accept("Hello World");
        Consumer<String> con2 = x -> System.out.println("x");
        con2.accept("Hello World");
    }

    @Test
    public void test3(){
        Comparator<Integer> com = (o1, o2) -> {
          System.out.println("函数式接口");
          return o1.compareTo(o2);
        };
    }


    @Test
    public void test4(){
        Integer num2 =  operation(100,num -> num * num);
        Integer num3 =  operation(100,num -> {return num * num;});
        System.out.println(num2);
        System.out.println(num3);
    }

    public Integer operation(Integer num ,MyFun myFun){
        return myFun.getValue(num);
    }


    @Test
    public void test5(){

    }



}
