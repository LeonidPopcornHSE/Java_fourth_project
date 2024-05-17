public class Building {
    private Elevator elevator1;
    private Elevator elevator2;
    private final int numFloors;

    public Building(int numFloors) {
        this.elevator1 = new Elevator();
        this.elevator2 = new Elevator();
        this.numFloors = numFloors;
    }

    public Elevator getElevator1() {
        return elevator1;
    }

    public Elevator getElevator2() {
        return elevator2;
    }

    public void requestElevator(int targetFloor) {
        Elevator closestElevator = getClosestElevator(targetFloor);
        closestElevator.setTargetFloor(targetFloor);
    }
    
    public int requestedElevatorCurrentFloor(int targetFloor) {
        Elevator closestElevator = getClosestElevator(targetFloor);
        return closestElevator.getCurrentFloor();
    }
    
    private Elevator getClosestElevator(int floor) {
        int distance1 = Math.abs(elevator1.getCurrentFloor() - floor);
        int distance2 = Math.abs(elevator2.getCurrentFloor() - floor);
        return distance1 <= distance2 ? elevator1 : elevator2;
    }

    public void moveElevators() {
        elevator1.move();
        elevator2.move();
    }

    public void display() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = numFloors - 1; i >= 0; i--) {
            char elev1Char = elevator1.getCurrentFloor() == i ? '1' : ' ';
            char elev2Char = elevator2.getCurrentFloor() == i ? '2' : ' ';
            System.out.printf("|%c %c|\n", elev1Char, elev2Char);
        }
        System.out.println("=====");
    }
}
