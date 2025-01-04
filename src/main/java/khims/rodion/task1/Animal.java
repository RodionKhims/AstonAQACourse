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

    public abstract void run(int distance);
    public abstract void swim(int distance);

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

    protected boolean isCanRun(int distance) {
        return distance <= runningDistanceLimit;
    }

    protected boolean isCanSwim(int distance) {
        return distance <= swimmingDistanceLimit;
    }
}
