package DBPM_classLibrary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Drawing {
    private String decimalNumber;
    private Engineer developer;
    private List<Project> usedInProjects;
    private boolean isArchived;
    private LocalDate startDate;
    private LocalDate releaseDate;
    private Project mainProject;

    public Drawing(String decimalNumber, LocalDate releaseDate, Project mainProject) {
        setDecimalNumber(decimalNumber);
        setReleaseDate(releaseDate);
        setMainProject(mainProject);
        setStartDate(LocalDate.now());

        usedInProjects = new ArrayList<>();
    }

    public String getDecimalNumber() {
        return decimalNumber;
    }

    public void setDecimalNumber(String decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    public Engineer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Engineer developer) {
        this.developer = developer;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Project getMainProject() {
        return mainProject;
    }

    public void setMainProject(Project newMainProject) {
        this.mainProject = newMainProject;

        if (getListOfProjects() != null && !getListOfProjects().contains(newMainProject))
            addProject(newMainProject);
    }

    public void addProject(Project project) {
        if (!usedInProjects.contains(project))
            usedInProjects.add(project);
    }

    public List<Project> getListOfProjects() {
        return usedInProjects;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append("Drawing ").append(getDecimalNumber()).append('\n');

        if (getDeveloper() != null)
            string.append("Developer: ").append(getDeveloper().getName()).append(' ').append(getDeveloper().getSecondName()).append('\n');

        if (usedInProjects.isEmpty()) {
            string.append("Does not using in any projects").append('\n');
        } else {
            string.append("Projects: ");
            for (Project project : usedInProjects) {
                string.append(project.getName()).append("; ");
            }
            string.append('\n');
        }

        if (isArchived()) {
            string.append("Drawing in archived").append('\n');
        }

        string.append("Start date: ").append(getStartDate()).append('\n');
        string.append("Release date: ").append(getReleaseDate()).append('\n');
        string.append("Main project: ").append(getMainProject().getName()).append('\n');

        return string.toString();
    }

    public static void main(String[] args) {
        Project project = new Project("Protazan", LocalDate.of(2021, 6, 21), 7);
        Project project1 = new Project("Spis", LocalDate.of(2021, 6, 21), 7);
        Drawing drawing = new Drawing("PMYE385.568432.001", LocalDate.of(2021, 6, 21), project);
        Drawing drawing1 = new Drawing("PMYE385.568432.002", LocalDate.of(2021, 6, 21), project);
        Department dp = new Department(94, "Mechanical department");
        Engineer engineer1 = new Engineer("Vasya", "Anekdotov", dp, project);
        Engineer engineer2 = new Engineer("Petya", "Anekdotov", dp, project);

        drawing.setDeveloper(engineer1);
        drawing.setMainProject(project);
        drawing.setMainProject(project);
        drawing.addProject(project);
        drawing.addProject(project1);
        drawing.setMainProject(project1);
        drawing.setArchived(false);

        System.out.println(drawing);
    }
}
