package khims.rodion.task1;

import java.util.function.Consumer;

public abstract class Animal {
    private final int runningDistanceLimit;
    private final int swimmingDistanceLimit;
    private final Consumer<Integer> runConsumer;
    private final Consumer<Integer> swimConsumer;
    private final String name;
    private boolean satiety;

    public Animal(int runningDistanceLimit, int swimmingDistanceLimit, Consumer<Integer> runConsumer, Consumer<Integer> swimConsumer, String name) {
        this.runningDistanceLimit = runningDistanceLimit;
        this.swimmingDistanceLimit = swimmingDistanceLimit;
        this.runConsumer = runConsumer;
        this.swimConsumer = swimConsumer;
        this.name = name;
    }

    public void run(int distance) {
        if (!isCanRun(distance)) {
            System.out.println(name + " can not run that distance");
            return;
        }
        runConsumer.accept(distance);
    }

    public void swim(int distance) {
        if (!isCanSwim(distance)) {
            System.out.println(name + " can not swim that distance");
            return;
        }
        swimConsumer.accept(distance);
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

    private boolean isCanRun(int distance) {
        return distance <= runningDistanceLimit;
    }

    private boolean isCanSwim(int distance) {
        return distance <= swimmingDistanceLimit;
    }
}
