package khims.rodion.task1;

public class Dish {
    private int foodCount;

    public Dish(int foodCount) {
        this.foodCount = foodCount;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void increase(int foodCount) {
        this.foodCount += foodCount;
    }

    public boolean decrease(int foodCount) {
        if (foodCount > this.foodCount) {
            return false;
        }
        this.foodCount -= foodCount;
        return true;
    }
}
