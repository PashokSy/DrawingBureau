package DBPM_classLibrary;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends Employee {
    private Project project;
    private List<Drawing> doneDrawings;
    private List<Drawing> undoneDrawings;
    private List<Drawing> archivedDrawings;
    private String rank;
    private int rankNumber;

    public Engineer(String name, String secondName, Department department, Project project) {
        super(name, secondName, department);
        setProject(project);
        setRank(3);
        this.rankNumber = 3;

        project.addEngineer(this);
    }

    public Engineer(String name, String secondName, Department department, Project project, int rankNumber) {
        super(name, secondName, department);
        setProject(project);
        setRank(rankNumber);
        this.rankNumber = rankNumber;

        project.addEngineer(this);
    }

    protected Engineer(String name, String secondName, Department department){
        super(name, secondName, department);
    }

    @Override
    public Project getProject() {
        return project;
    }

    @Override
    public void setProject(Project project) {
        this.project = project;
    }

    public List<Drawing> getDoneDrawings() {
        return doneDrawings;
    }

    public void setDoneDrawings(List<Drawing> doneDrawings) {
        this.doneDrawings = doneDrawings;
    }

    public List<Drawing> getUndoneDrawings() {
        return undoneDrawings;
    }

    public void setUndoneDrawings(List<Drawing> undoneDrawings) {
        this.undoneDrawings = undoneDrawings;
    }

    public List<Drawing> getArchivedDrawings() {
        return archivedDrawings;
    }

    public void setArchivedDrawings(List<Drawing> archivedDrawings) {
        this.archivedDrawings = archivedDrawings;
    }

    public List<Drawing> getAllDrawings() {
        List<Drawing> allDrawings = new ArrayList<>();
        allDrawings.addAll(doneDrawings);
        allDrawings.addAll(undoneDrawings);
        allDrawings.addAll(archivedDrawings);
        return allDrawings;
    }

    public void addDrawing(Drawing drawing) {
        undoneDrawings.add(drawing);
    }

    public void completeDrawing(Drawing drawing) {
        doneDrawings.add(drawing);
    }

    public void takeDrawingFromArchive(Drawing drawing) {
        archivedDrawings.add(drawing);
    }

    public String getRank() {
        return "Engineer " + rankNumber + " category";
    }

    public void setRank(int rankNumber) {
        this.rankNumber = rankNumber;
        rank = "Engineer " + rankNumber + " category";
    }
}
