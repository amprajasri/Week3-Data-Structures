class PetrolPump {
    int petrol;
    int distance;
    
    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

class CircularTour {
    public int tour(PetrolPump[] pumps) {
        int totalSurplus = 0;
        int currentSurplus = 0;
        int start = 0;
        
        for (int i = 0; i < pumps.length; i++) {
            totalSurplus += pumps[i].petrol - pumps[i].distance;
            currentSurplus += pumps[i].petrol - pumps[i].distance;
            
            if (currentSurplus < 0) {
                start = i + 1;
                currentSurplus = 0;
            }
        }
        
        return (totalSurplus >= 0) ? start : -1;
    }
}

public class CircularTourTest {
    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5),
            new PetrolPump(5, 2)
        };
        
        CircularTour tour = new CircularTour();
        int start = tour.tour(pumps);
        
        System.out.println("The starting pump is: " + (start != -1 ? start : "No valid starting point"));
    }
}
