package DBPM_classLibrary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Employee {
    private IdCard idCard;
    private String name;
    private String secondName;
    private Department department;
    private Room room;
    private Project project;

    public Employee(){}

    public Employee(String name, String secondName, Department department) {
        setName(name);
        setSecondName(secondName);
        setDepartment(department);
        department.addEmployee(this);
    }

    public Employee(String name, String secondName) {
        setName(name);
        setSecondName(secondName);
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setRoom(int number) {
        this.setRoom(new Room(number));
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void moveToProject(Project project) {
        this.project = project;
    }

    public boolean isOnProject() {
        return (this.project != null);
    }

    public void moveToRoom(Room room) {
        this.setRoom(room);
    }

    public void moveToRoom(int number) {
        this.setRoom(number);
    }

    public void moveToDepartment(Department department) {
        this.setDepartment(department);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Name: ").append(getName()).append('\n');
        string.append("Second name: ").append(getSecondName()).append('\n');

        string.append("Department: ");
        if (getDepartment() == null) {
            string.append("no department").append('\n');
        } else {
            string.append(getDepartment().getNumber()).append('\n');
        }

        string.append("Room: ");
        if (getRoom() == null) {
            string.append("no room");
        } else {
            string.append(getRoom().getNumber()).append('\n');
        }

        string.append("IdCard: ");
        if (getIdCard() == null) {
            string.append("no id card");
        } else {
            string.append(getIdCard().getNumber()).append('\n');
        }

        if (isOnProject()) {
            string.append("Project: ").append(project.getName()).append('\n');
        }

        return string.toString();
    }

    public static void main(String[] args) {
        IdCard card = new IdCard(482);
        Room room = new Room(74);
        Department dp = new Department(94, "Mechanical department");
        Department dp2 = new Department(14, "Metrology department");

        Employee employee = new Employee("Vasya", "Pyatochkin", dp);
        employee.moveToRoom(45);

        Employee employee1 = new Employee("Petya", "Proshkin", dp);
        employee1.setRoom(95);
        employee1.moveToRoom(room);
        employee1.setIdCard(card);
        employee1.moveToProject(
                new Project("Protazan", LocalDate.of(2021, 6, 21), 7)
        );

        Employee employee2 = new Employee("Lesha", "Hzshkin", dp);
        employee2.setRoom(13);

        System.out.println(dp);

        Employee employee3 = new Employee("Kolya", "Vasilev");
        employee3.setRoom(room);
        employee3.setIdCard(new IdCard(322));
        employee3.moveToDepartment(dp);
        employee3.moveToDepartment(dp2);
        employee.moveToDepartment(dp2);

        ArrayList<Employee> e = new ArrayList<>();
        e.add(employee);
        e.add(employee1);
        e.add(employee2);
        e.add(employee3);

        for (int i = 0; i < e.size(); i++) {
            System.out.println("Emplyee " + i);
            System.out.println(e.get(i));
            System.out.println();
        }
    }
}
