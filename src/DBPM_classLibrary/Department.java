package DBPM_classLibrary;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private int number;
    private String name;
    private List<Employee> employees;

    public Department(int number, String name) {
        setNumber(number);
        setName(name);
        employees = new ArrayList<Employee>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int newNumber) {
        number = newNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void addEmployee(Employee newEmployee) {
        employees.add(newEmployee);
        newEmployee.setDepartment(this);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Department number: ").append(getNumber()).append('\n');
        string.append("Department name: ").append(getName()).append('\n');
        string.append("Employees in department: ").append('\n');
        if (employees.isEmpty()) {
            string.append("There is no employees in the department ").append(number).append('\n');
        } else {
            int i = 1;
            for (Employee employee : employees) {
                string.append(i).append(": ");
                string.append(employee.getName()).append(' ')
                        .append(employee.getSecondName())
                        .append('\n');
                i++;
            }
        }
        return string.toString();
    }

    public static void main(String[] args) {
        Department dp = new Department(94, "Mechanical department");
        Employee employee = new Employee("Vasya", "Pyatochkin", dp);
        Employee employee1 = new Employee("Petya", "Proshkin", dp);
        Employee employee2 = new Employee("Lesha", "Hzshkin", dp);

        System.out.println(dp);

//        dp.removeEmployee(employee1);
//        System.out.println(dp);

//        System.out.println();
//        System.out.println(dp.getEmployees());
    }
}
