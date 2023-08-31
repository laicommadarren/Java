public class Phone extends Device {
    
    public void makeCall() {
        if (this.battery >= 5) {
        this.battery -= 5;
        System.out.printf("Making a call... remaining battery: %d\n", this.battery);
        }
        else System.out.printf("Not enough battery to make a call. Calling requires 5 battery. Your battery: %d", this.battery);
    }

    public void playGame() {
        if (this.battery >= 20) {
        this.battery -= 20;
        System.out.printf("Playing game... remaining battery %d\n", this.battery);
        }
        else System.out.printf("Not enough battery to play game. Playing game requires 20 battery. Your battery: %d", this.battery);
    }

    public void charge() {
        this.battery += 50;
        if (this.battery > 100) this.battery = 100;
        System.out.printf("Charged battery. Battery level is now %d.\n", this.battery);
    }
}
