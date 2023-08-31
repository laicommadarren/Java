public class Bat extends Mammal {
    public Bat() {
        this.setEnergy(300);
    }

    // public void displayEnergy() {
    //     super.displayEnergy();
    // }

    public void fly() {
        if (this.getEnergy() < 50) {
            System.out.printf(
                    "You do not have enough energy to fly. Required energy: 50; Current energy: %d\n",
                    this.getEnergy());
        } else {
            this.setEnergy(this.getEnergy() - 50);
            System.out.printf("The bat flies. Energy decreased by 50. Current energy: %d\n", this.getEnergy());
        }
    }

    public void eatHumans() {
        this.setEnergy(this.getEnergy() + 25);
        System.out.printf("The bat eagerly devours nearby humans and increases its energy by 25. Current energy: %d\n", this.getEnergy());
    }

    public void attackTown() {
        if (this.getEnergy() < 100) {
            System.out.printf(
                    "You do not have enough energy to attack a town. Required energy: 100; Current energy: %d\n",
                    this.getEnergy());
        } else {
            this.setEnergy(this.getEnergy() - 100);
            System.out.printf("The bat lays waste to a nearby town, using 100 energy. Current energy: %d\n", this.getEnergy());
        }
    }

}
