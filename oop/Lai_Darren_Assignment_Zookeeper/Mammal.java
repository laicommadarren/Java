public class Mammal {
    private int energy = 100;

    public void displayEnergy() {
        System.out.printf("Energy level: %d\n", energy);
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    
}