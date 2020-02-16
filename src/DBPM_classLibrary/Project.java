package DBPM_classLibrary;

import java.time.LocalDate;
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
        if (!engineers.contains(newEngineer))
            engineers.add(newEngineer);
        if(newEngineer.getProject() != null)
            newEngineer.getProject().removeEngineer(newEngineer);
    }

    public void removeEngineer(Engineer engineer) {
            engineers.remove(engineer);
    }


    public int getEngineersNeedCount() {
        return engineersNeedCount;
    }

    public void setEngineersNeedCount(int engineersNeedCount) {
        this.engineersNeedCount = engineersNeedCount;
    }

    public int getNeededEngineers() {
        return (engineers == null) ? getEngineersNeedCount() : getEngineersNeedCount() - engineers.size();
    }

    public void addDrawing(Drawing drawing) {
        drawings.add(drawing);
    }

    public void deleteDrawing(Drawing drawing) {
        drawings.remove(drawing);
    }

    public void setDrawingDone(Drawing drawingDone) {
        deleteDrawing(drawingDone);
        doneDrawing.add(drawingDone);

    }

    public void done() {
        isArchived = true;
    }

    public boolean isDone() {
        return isArchived;
    }
}
