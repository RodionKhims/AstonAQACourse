package khims.rodion.task1;

public class Dog extends Animal {
    private static final int RUNNING_DISTANCE_LIMIT = 500;
    private static final int SWIMMING_DISTANCE_LIMIT = 10;

    public Dog(String name) {
        super(RUNNING_DISTANCE_LIMIT, SWIMMING_DISTANCE_LIMIT, name);
    }

    @Override
    public void run(int distance) {
        if (!isCanRun(distance)) {
            System.out.println(getName() + " can not run that distance");
            return;
        }
        System.out.println("Dog " + getName() + " runs " + distance + " m");
    }

    @Override
    public void swim(int distance) {
        if (!isCanSwim(distance)) {
            System.out.println(getName() + " can not swim that distance");
            return;
        }
        System.out.println("Dog " + getName() + " swims " + distance + " m");
    }
}
