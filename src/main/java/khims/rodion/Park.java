package khims.rodion;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private final List<Attraction> attractions = new ArrayList<>();

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public class Attraction {
        private final String title;
        private final String workTime;
        private final double price;

        public Attraction(String title, String workTime, double price) {
            this.title = title;
            this.workTime = workTime;
            this.price = price;
        }

        public String getTitle() {
            return title;
        }

        public String getWorkTime() {
            return workTime;
        }

        public double getPrice() {
            return price;
        }
    }
}
