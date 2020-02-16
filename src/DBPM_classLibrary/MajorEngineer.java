package DBPM_classLibrary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MajorEngineer extends Engineer {
    private List<Project> projects;
    private List<Project> doneProjects;
    private List<Engineer> subordinates;

    public MajorEngineer(String name, String secondName, Department department) {
        super(name, secondName, department);

        projects = new ArrayList<>();
        doneProjects = new ArrayList<>();
        subordinates = new ArrayList<>();
    }

    public void addProject(Project project) {
        if (!projects.contains(project))
            projects.add(project);
    }

    public void deleteProject(Project project) {
        projects.remove(project);
    }

    public void finishProject(Project project) {
        projects.remove(project);
        if (!doneProjects.contains(project))
            doneProjects.add(project);
    }

    public void addSubordinate(Engineer subordinate) {
        if (!subordinates.contains(subordinate))
            subordinates.add(subordinate);
    }

    public void deleteSubordinate(Engineer subordinate) {
        subordinates.remove(subordinate);
    }

    public void putEngineerOnProject(Project project, Engineer engineer) {
        if (subordinates.contains(engineer))
            project.addEngineer(engineer);
    }

    public void removeEngineerFromProject(Project project, Engineer engineer) {
        if (subordinates.contains(engineer))
            project.removeEngineer(engineer);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Major engineer: ").append('\n');
        string.append("Name: ").append(getName()).append('\n');
        string.append("Second name: ").append(getSecondName()).append('\n');

        if (!projects.isEmpty()) {
            string.append("Projects: ");
            for (Project project : projects)
                string.append(project.getName()).append("; ");
            string.append('\n');
        }

        if (!doneProjects.isEmpty()) {
            string.append("Done projects: ");
            for (Project project : doneProjects)
                string.append(project.getName()).append("; ");
            string.append('\n');
        }

        if (!subordinates.isEmpty()) {
            string.append("Subordinates: ");
            for (Engineer engineer : subordinates)
                string.append(engineer.getName()).append(' ').append(engineer.getSecondName()).append("; ");
            string.append('\n');
        }

        return string.toString();
    }

    public static void main(String[] args) {
        Department dp = new Department(94, "Mechanical department");
        MajorEngineer majorEngineer = new MajorEngineer("Vasya", "Zhostich", dp);
        Project project = new Project("Protazan", LocalDate.of(2021, 6, 21), 7);
        Project project1 = new Project("Spis", LocalDate.of(2021, 6, 21), 7);
        Engineer engineer1 = new Engineer("Vasya", "Anekdotov", dp, project, 22);
        Engineer engineer2 = new Engineer("Petya", "Anekdotov", dp, project, 2);

        majorEngineer.addProject(project);
        majorEngineer.addProject(project);
        majorEngineer.addProject(project1);
        majorEngineer.addSubordinate(engineer1);
        majorEngineer.addSubordinate(engineer1);
        majorEngineer.addSubordinate(engineer2);

        System.out.println(majorEngineer);
        System.out.println();

        majorEngineer.deleteProject(project);
        majorEngineer.deleteSubordinate(engineer1);
        majorEngineer.finishProject(project1);
        System.out.println(majorEngineer);

        System.out.println();
        majorEngineer.putEngineerOnProject(project1, engineer2);
        System.out.println(engineer2);

        System.out.println();
        majorEngineer.removeEngineerFromProject(project1, engineer2);
        System.out.println(engineer2);
    }
}
