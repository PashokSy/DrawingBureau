package DBPM_classLibrary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private LocalDate releaseDate;
    private List<Engineer> engineers;
    private double materialsCost;
    private List<Drawing> drawings;
    private List<Drawing> doneDrawing;
    private int engineersNeedCount;
    private boolean isArchived;

    public Project(String name, LocalDate releaseDate, int engineersNeedCount) {
        setName(name);
        setReleaseDate(releaseDate);
        setEngineersNeedCount(engineersNeedCount);

        engineers = new ArrayList<>();
        drawings = new ArrayList<>();
        doneDrawing = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate newReleaseDate) {
        this.releaseDate = newReleaseDate;
    }

    public double getMaterialsCost() {
        return materialsCost;
    }

    public void setMaterialsCost(double materialsCost) {
        this.materialsCost = materialsCost;
    }

    public void addEngineer(Engineer newEngineer) {
        if (!engineers.contains(newEngineer) && getEngineersNeedCount() != 0) {
            newEngineer.getProject().removeEngineer(newEngineer);
            engineers.add(newEngineer);
            newEngineer.setProject(this);
        }
    }

    public void removeEngineer(Engineer engineer) {
        engineers.remove(engineer);
        engineer.setProject(null);
    }


    private int getEngineersNeedCount() {
        return (engineers == null) ? engineersNeedCount : engineersNeedCount - engineers.size();
    }

    public void setEngineersNeedCount(int engineersNeedCount) {
        this.engineersNeedCount = engineersNeedCount;
    }

    public void addDrawing(Drawing drawing) {
        if (!drawings.contains(drawing))
            drawings.add(drawing);
    }

    public void deleteDrawing(Drawing drawing) {
        drawings.remove(drawing);
    }

    public void setDrawingDone(Drawing drawingDone) {
        if(drawings.contains(drawingDone)) {
            deleteDrawing(drawingDone);
            doneDrawing.add(drawingDone);
        }
    }

    public void done() {
        isArchived = true;
    }

    public boolean isDone() {
        return isArchived;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        if (isDone()) {
            return "Project " + '\'' + getName() + '\'' + " is done";
        }

        string.append("Project name: ").append('\'').append(getName()).append('\'').append('\n');
        string.append("Release Date: ").append(getReleaseDate().toString()).append('\n');
        string.append("Materials Cost: ").append(getMaterialsCost()).append("$").append('\n');
        string.append("Engineers count need: ").append(getEngineersNeedCount()).append('\n');

        if (isArchived)
            string.append("Project in archive").append('\n');

        if (engineers == null || engineers.isEmpty()) {
            string.append("There is no engineers");
        } else {
            string.append("Engineers: ");
            for (Employee engineer : engineers) {
                string.append(engineer.getName()).append(' ')
                        .append(engineer.getSecondName())
                        .append("; ");
            }
            string.append('\n');
        }

        if (drawings == null || drawings.isEmpty()) {
            string.append("There is no drawings");
        } else {
            string.append("Drawings: ");
            for (Drawing drawing : drawings) {
                string.append(drawing.getDecimalNumber()).append("; ");
            }
            string.append('\n');
        }

        if (doneDrawing == null || doneDrawing.isEmpty()) {
            string.append("There is no finished drawings");
        } else {
            string.append("Finished drawings: ");
            for (Drawing drawing : doneDrawing) {
                string.append(drawing.getDecimalNumber()).append("; ");
            }
            string.append('\n');
        }

        return string.toString();
    }

    public static void main(String[] args) {
        Project project = new Project("Protazan", LocalDate.of(2021, 6, 21), 7);
        Project project1 = new Project("Spis", LocalDate.of(2022, 3, 12), 7);
        project.setMaterialsCost(1300.13);

        Department dp = new Department(94, "Mechanical department");
        Engineer engineer1 = new Engineer("Vasya", "Anekdotov", dp, project);
        Engineer engineer2 = new Engineer("Petya", "Pyatochkin", dp, project);
        Engineer engineer3 = new Engineer("Petya1", "Pyatochkin", dp, project);
        Engineer engineer4 = new Engineer("Petya2", "Pyatochkin", dp, project);
        Engineer engineer5 = new Engineer("Petya3", "Pyatochkin", dp, project);
        Engineer engineer6 = new Engineer("Petya4", "Pyatochkin", dp, project);
        Engineer engineer7 = new Engineer("Petya5", "Pyatochkin", dp, project);
        Engineer engineer8 = new Engineer("Petya6", "Pyatochkin", dp, project);
        Engineer engineer9 = new Engineer("Petya7", "Pyatochkin", dp, project);

        project1.addEngineer(engineer1);
        Engineer engineer10 = new Engineer("Petya8", "Pyatochkin", dp, project);

        Drawing drawing = new Drawing("PMYE385.568432.001", LocalDate.of(2021, 6, 21), project);
        Drawing drawing1 = new Drawing("PMYE385.568432.002", LocalDate.of(2021, 6, 21), project);
        project.addDrawing(drawing);
        project.addDrawing(drawing);
        project.addDrawing(drawing1);

        System.out.println(project);
        System.out.println();
        System.out.println(project1);

        project1.done();
        System.out.println();
        System.out.println(project1);

        project.setDrawingDone(drawing);
        project.addDrawing(drawing1);
        System.out.println();
        System.out.println(project);
    }
}
