package java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: java8
 * @description:
 * @author: ChenYu
 * @create: 2018-10-13 19:57
 **/
public class TestLamba03 {

    List<Employee> employees = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );



    @Test
    public void test1(){
        Collections.sort(employees,(e1,e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return e1.getAge() - e2.getAge();
            }
        });
        for (Employee e: employees) {
            System.out.println(e);
        }
    }


    @Test
    public void test2(){
        System.out.println(strHandler("\t\t\t Hello World ", str -> str.replaceAll(" ", "")));
        System.out.println(strHandler("  \t\t\t Hello World  ", str -> str.trim()));
        System.out.println(strHandler(" add \t\t\t Hello World  ", str -> str.toUpperCase()));
        System.out.println(strHandler(" add \t\t\t Hello World  ", str -> str.substring(0,4)));
    }

    public String strHandler(String str,MyFunction mf){
        return mf.getValue(str);
    }

    // 需求 ： 对两个 long 型数据进行处理
    public void op (Long l1,Long l2,MyFunction2<Long,Long> m){
        System.out.println(m.getValue(l1,l2));
    }
    @Test
    public void test3(){
        op(100l,200l,(x,y) -> x+y);
        op(100l,200l,(x,y) -> x-y);
        op(100l,200l,(x,y) -> x*y);
    }
}
