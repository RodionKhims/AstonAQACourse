package khims.rodion.task1;

public class Dog extends Animal {
    private static final int RUNNING_DISTANCE_LIMIT = 500;
    private static final int SWIMMING_DISTANCE_LIMIT = 10;

    public Dog(String name) {
        super(RUNNING_DISTANCE_LIMIT, SWIMMING_DISTANCE_LIMIT, name);
    }

    @Override
    protected void animalRun(int distance) {
        System.out.println("Dog " + getName() + " runs " + distance + " m");
    }

    @Override
    protected void animalSwim(int distance) {
        System.out.println("Dog " + getName() + " swims " + distance + " m");
    }
}
