package khims.rodion.task1;

public abstract class Animal {
    private final int runningDistanceLimit;
    private final int swimmingDistanceLimit;
    private final String name;
    private boolean satiety;

    public Animal(int runningDistanceLimit, int swimmingDistanceLimit, String name) {
        this.runningDistanceLimit = runningDistanceLimit;
        this.swimmingDistanceLimit = swimmingDistanceLimit;
        this.name = name;
    }

    public void run(int distance) {
        if (!isCanRun(distance)) {
            System.out.println(name + " can not run that distance");
            return;
        }
        innerRun(distance);
    }

    public void swim(int distance) {
        if (!isCanSwim(distance)) {
            System.out.println(name + " can not swim that distance");
            return;
        }
        innerSwim(distance);
    }

    public void eat(Dish dish, int foodCount) {
        if (satiety) {
            return;
        }

        if (dish.decrease(foodCount)) {
            satiety = true;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    protected abstract void innerRun(int distance);
    protected abstract void innerSwim(int distance);

    private boolean isCanRun(int distance) {
        return distance <= runningDistanceLimit;
    }

    private boolean isCanSwim(int distance) {
        return distance <= swimmingDistanceLimit;
    }
}
