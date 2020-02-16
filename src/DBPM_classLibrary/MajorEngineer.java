package DBPM_classLibrary;

import java.util.List;

public class MajorEngineer extends Engineer {
    private List<Project> projects;
    private List<Project> doneProjects;
    private List<Engineer> subordinates;

    public MajorEngineer(String name, String secondName, Department department) {
        super(name, secondName, department);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void deleteProject(Project project) {
        projects.remove(project);
    }

    public void finishProject(Project project) {
        projects.remove(project);
        doneProjects.add(project);
    }

    public void addSubordinate(Engineer subordinate) {
        subordinates.add(subordinate);
    }

    public void deleteSubordinate(Engineer subordinate) {
        subordinates.remove(subordinate);
    }

    public void putEngineerOnProject(Project project, Engineer engineer) {
        if (subordinates.contains(engineer))
            project.addEngineer(engineer);
    }

    public void removeEngineerFromProject(Project project, Engineer engineer){
        if(subordinates.contains(engineer))
            project.removeEngineer(engineer);
    }
}
