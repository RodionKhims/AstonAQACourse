package khims.rodion.task1;

public class Cat extends Animal {
    private static final int RUNNING_DISTANCE_LIMIT = 200;
    private static final int SWIMMING_DISTANCE_LIMIT = 0;

    public Cat(String name) {
        super(RUNNING_DISTANCE_LIMIT, SWIMMING_DISTANCE_LIMIT, name);
    }

    @Override
    public void run(int distance) {
        if (!isCanRun(distance)) {
            System.out.println(getName() + " can not run that distance");
            return;
        }
        System.out.println("Cat " + getName() + " runs " + distance + " m");
    }

    @Override
    public void swim(int distance) {
        if (!isCanSwim(distance)) {
            System.out.println(getName() + " can not swim that distance");
            return;
        }
        System.out.println("Cat " + getName() + " can not swim");
    }
}
