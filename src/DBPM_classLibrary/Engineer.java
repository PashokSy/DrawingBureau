package DBPM_classLibrary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Engineer extends Employee {
    private Project project;
    private List<Drawing> doneDrawings;
    private List<Drawing> undoneDrawings;
    private List<Drawing> archivedDrawings;
    private String rank;
    private int rankNumber;

    public Engineer(){}

    public Engineer(String name, String secondName, Department department, Project project) {
        super(name, secondName, department);
        setProject(project);
        setRank(3);
        this.rankNumber = 3;

        doneDrawings = new ArrayList<>();
        undoneDrawings = new ArrayList<>();
        archivedDrawings = new ArrayList<>();

        project.addEngineer(this);
    }

    public Engineer(String name, String secondName, Department department, Project project, int rankNumber) {
        super(name, secondName, department);
        setProject(project);

        if (rankNumber > 3)
            rankNumber = 3;
        if (rankNumber < 1)
            rankNumber = 1;
        setRank(rankNumber);
        this.rankNumber = rankNumber;

        doneDrawings = new ArrayList<>();
        undoneDrawings = new ArrayList<>();
        archivedDrawings = new ArrayList<>();

        project.addEngineer(this);
    }

    protected Engineer(String name, String secondName, Department department) {
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
        if (!archivedDrawings.contains(drawing))
            archivedDrawings.add(drawing);
    }

    public String getRank() {
        return rank;
    }

    public void setRank(int rankNumber) {
        this.rankNumber = rankNumber;
        switch (this.rankNumber) {
            case 1:
                rank = "Engineer " + rankNumber + "-st category";
                break;
            case 2:
                rank = "Engineer " + rankNumber + "-nd category";
                break;
            case 3:
                rank = "Engineer " + rankNumber + "-rd category";
                break;
            default:
                rank = "Engineer";
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append(rank).append('\n');
        string.append("Name: ").append(getName()).append('\n');
        string.append("Second name: ").append(getSecondName()).append('\n');

        if (project != null)
            string.append("Project: ").append(getProject().getName()).append('\n');

        if (!doneDrawings.isEmpty()) {
            string.append("Done drawings: ");
            for (Drawing drawing : getDoneDrawings())
                string.append(drawing.getDecimalNumber()).append("; ");
            string.append('\n');
        }

        if (!undoneDrawings.isEmpty()) {
            string.append("Drawings in process: ");
            for (Drawing drawing : getUndoneDrawings())
                string.append(drawing.getDecimalNumber()).append("; ");
            string.append('\n');
        }

        if (!archivedDrawings.isEmpty()) {
            string.append("Archived drawings: ");
            for (Drawing drawing : getArchivedDrawings())
                string.append(drawing.getDecimalNumber()).append("; ");
            string.append('\n');
        }

        return string.toString();
    }

    public static void main(String[] args) {
        Project project = new Project("Protazan", LocalDate.of(2021, 6, 21), 7);
        Project project1 = new Project("Spis", LocalDate.of(2021, 6, 21), 7);
        Department dp = new Department(94, "Mechanical department");
        Engineer engineer1 = new Engineer("Vasya", "Anekdotov", dp, project, 22);
        Engineer engineer2 = new Engineer("Petya", "Anekdotov", dp, project, 2);
        Drawing drawing = new Drawing("PMYE385.568432.001", LocalDate.of(2021, 6, 21), project);
        Drawing drawing1 = new Drawing("PMYE385.568432.002", LocalDate.of(2021, 6, 21), project);
        engineer1.completeDrawing(drawing);
        engineer1.addDrawing(drawing1);

        ArrayList<Drawing> drawingsArr = new ArrayList<>();
        drawingsArr.add(drawing);
        drawingsArr.add(drawing1);
        engineer2.setDoneDrawings(drawingsArr);
        engineer2.setUndoneDrawings(drawingsArr);
        engineer2.setArchivedDrawings(drawingsArr);
        Drawing drawing3 = new Drawing("PMYE385.568432.003", LocalDate.of(2021, 6, 21), project);
        engineer2.takeDrawingFromArchive(drawing3);

        System.out.println(engineer1);
        System.out.println();
        System.out.println(engineer2.getRank());
        System.out.println(engineer2);
        System.out.println(engineer2.getAllDrawings());
    }
}
