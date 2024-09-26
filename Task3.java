import java.util.ArrayList;
import java.util.List;

public class Task3 {
    private static final ArrayList<Employee> employeesExample = new ArrayList<>(
            List.of(
                    new Employee("Иван", 45, "Завод", 15_000.0),
                    new Employee("Сергей", 27, "Разработка", 200_000.0),
                    new Employee("Анна", 30, "Маникюр", 170_000.0),
                    new Employee("Денчик", 56, "Госдума", 11_000_000.0),
                    new Employee("Анатолий", 25, "Газета", 50_000.0)
            )
    );

    public static void main(String[] args) {
        int age = 30;
        List<Employee> filteredEmployees = filterEmployeesByAge(employeesExample, age);
        
        filteredEmployees.forEach(System.out::println);
    }

    public static List<Employee> filterEmployeesByAge(List<Employee> employees, int age) {
        return employees
                .stream()
                .filter(employee -> employee.getAge() > age)
                .toList();
    }
}


class Employee {
    private String fullName;
    private Integer age;
    private String department;
    private Double salary;

    public Employee(String fullName, Integer age, String department, Double salary) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}