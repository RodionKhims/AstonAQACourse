package khims.rodion.task1;

public abstract class Animal {
    private final int runningDistanceLimit;
    private final int swimmingDistanceLimit;
    private final String name;

    public Animal(int runningDistanceLimit, int swimmingDistanceLimit, String name) {
        this.runningDistanceLimit = runningDistanceLimit;
        this.swimmingDistanceLimit = swimmingDistanceLimit;
        this.name = name;
    }

    public void run(int distance) {
        if (distance > runningDistanceLimit) {
            System.out.println(name + " can not run that distance");
            return;
        }
        running(distance);
    }

    public void swim(int distance) {
        if (distance > swimmingDistanceLimit) {
            System.out.println(name + " can not swim that distance");
            return;
        }
        swimming(distance);
    }

    public String getName() {
        return name;
    }

    protected abstract void running(int distance);
    protected abstract void swimming(int distance);
}
