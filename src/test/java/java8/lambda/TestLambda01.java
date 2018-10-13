package java8.lambda;

import org.junit.Test;

import java.util.*;

/**
 * @program: java8
 * @description:
 * @author: ChenYu
 * @create: 2018-10-13 16:11
 **/
public class TestLambda01 {

    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    @Test
    public void test2(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
    }

    List<Employee> employees = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );


    // 最原始写法

    public List<Employee> filterByAge(List<Employee> list){
        List<Employee> emps = new ArrayList<>();
        for (Employee employee: list) {
            if(employee.age >= 35){
                emps.add(employee);
            }
        }
        return emps;
    }

    public List<Employee> filterBySalary(List<Employee> list){
        List<Employee> emps = new ArrayList<>();
        for (Employee employee: list) {
            if(employee.salary >= 5000){
                emps.add(employee);
            }
        }
        return emps;
    }



    @Test
    public void mytest(){
        List<Employee> emps = filterByAge(employees);
        for (Employee e: emps) {
            System.out.println(e);
        }
        System.out.println("-------------------");
        emps = filterBySalary(employees);
        for (Employee e: emps) {
            System.out.println(e);
        }
    }



    // 优化方式 1  策略设计模式
    // 缺点 类太多
    // 提取共同代码
    public List<Employee> filterEmployee(List<Employee> list,MyPredicate<Employee> mp){
        List<Employee> emps = new ArrayList<>();
        for (Employee employee: list) {
            if(mp.test(employee)){
                emps.add(employee);
            }
        }
        return emps;
    }


    @Test
    public void test4(){
        List<Employee> emps = filterEmployee(employees,new FilterEmployeeByAge());
        for (Employee e: emps) {
            System.out.println(e);
        }
        System.out.println("-----------------------");
        emps = filterEmployee(employees,new FilterEmployeeBySalary());
        for (Employee e: emps) {
            System.out.println(e);
        }

    }

    // 优化方式二  匿名内部类
    @Test
    public void test5(){
        List<Employee> emps = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.age>=30;
            }
        });
        for (Employee e: emps) {
            System.out.println(e);
        }
        System.out.println("-----------------------");
        emps = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.salary>=3000;
            }
        });
        for (Employee e: emps) {
            System.out.println(e);
        }
    }


    // 优化方式三  lanbda 表达式

    @Test
    public void test6(){
        List<Employee> emps = filterEmployee(employees,(e) -> e.getAge()>=30);
        emps.forEach(System.out::println);
        System.out.println("-----------------------");
        emps = filterEmployee(employees,employee -> employee.getSalary()>=5000);
        emps.forEach(System.out::println);
    }



    // 优化方式四  stream API
    @Test
    public void test7(){
        employees.stream().filter((employee -> employee.getAge()>=30)).forEach(System.out::println);
        System.out.println("===================");
        employees.stream().filter((employee -> employee.getSalary()>=5000)).forEach(System.out::println);
        System.out.println("==================");
        employees.stream().filter((employee -> employee.getSalary()>=5000)).limit(2).forEach(System.out::println);
    }












    @Test
    public void test(){
        System.out.println("Hello World");
    }



}
