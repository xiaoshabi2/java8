package java8.lambda;

/**
 * @program: java8
 * @description:
 * @author: ChenYu
 * @create: 2018-10-13 16:57
 **/
public class FilterEmployeeBySalary implements  MyPredicate<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.salary>=5000;
    }
}
