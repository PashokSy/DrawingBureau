package DBPM_classLibrary;

import java.time.LocalDate;
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

    public void setMainProject(Project mainProject) {
        this.mainProject = mainProject;
    }

    public void addProject(Project project){
        usedInProjects.add(project);
    }

    public List<Project> getListOfProjects(){
        return usedInProjects;
    }

    @Override
    public String toString() {
        return "Drawing{" +
                "decimalNumber='" + decimalNumber + '\'' +
                ", developer=" + developer +
                ", usedInProjects=" + usedInProjects +
                ", isArchived=" + isArchived +
                ", startDate=" + startDate +
                ", releaseDate=" + releaseDate +
                ", mainProject=" + mainProject +
                '}';
    }
}
