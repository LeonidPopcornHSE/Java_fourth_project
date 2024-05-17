import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int NUM_FLOORS = 10;
        Building building = new Building(NUM_FLOORS);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            building.display();
            System.out.print("Enter target floor (0-" + (NUM_FLOORS - 1) + ") or -1 to quit: ");
            int floor = scanner.nextInt();
            int currentFloor;

            if (floor == -1) {
                break;
            } else if (floor >= 0 && floor < NUM_FLOORS) {
                building.requestElevator(floor);
                currentFloor = building.requestedElevatorCurrentFloor(floor);
                for (int i = 0; i < Math.abs(floor - currentFloor); i++) {
                    building.moveElevators();
                    building.display();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Invalid floor. Please enter a number between 0 and " + (NUM_FLOORS - 1) + ".");
            }
        }
        scanner.close();
    }
}
