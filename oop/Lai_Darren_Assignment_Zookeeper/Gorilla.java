public class Gorilla extends Mammal {
    
    // public void displayEnergy() {
    //     super.displayEnergy();
    // }
    
    public void throwSomething() {
        if (this.getEnergy() < 5) {
            System.out.printf("You do not have enough energy to throw something. Required energy: 5; Current energy: %d\n", this.getEnergy());
        }
        else {
            this.setEnergy(this.getEnergy() - 5);
            System.out.printf("Throwing something. Your energy decreased by 5. Current energy: %d\n", this.getEnergy());
        }
    }

    public void eatBanana() {
        this.setEnergy(this.getEnergy() + 10);
        System.out.printf("You are happy to eat a banana. Energy has increased by 10. Current energy: %d\n", this.getEnergy());
    }

    public void climb() {
        if (this.getEnergy() < 10) {
            System.out.printf("You do not have enough energy to climb. Required energy: 10; Current energy: %d\n", this.getEnergy());
        }
        else {
            this.setEnergy(this.getEnergy() - 10);
            System.out.printf("You have climbed a tree. Energy has decreased by 10. Current energy: %d\n", this.getEnergy());
        }
    }
}
