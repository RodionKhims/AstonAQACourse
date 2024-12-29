package khims.rodion.task1;

public class Cat extends Animal {
    private static final int RUNNING_DISTANCE_LIMIT = 200;
    private static final int SWIMMING_DISTANCE_LIMIT = 0;

    public Cat(String name) {
        super(RUNNING_DISTANCE_LIMIT, SWIMMING_DISTANCE_LIMIT, name);
    }

    @Override
    protected void running(int distance) {
        System.out.println("Cat " + getName() + " runs " + distance + " m");
    }

    @Override
    protected void swimming(int distance) {
        System.out.println("Cat " + getName() + " can not swim");
    }
}
