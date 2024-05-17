public class Elevator {
    private int currentFloor;
    private int targetFloor;
    private boolean movingUp;

    public Elevator() {
        this.currentFloor = 0;
        this.targetFloor = 0;
        this.movingUp = true;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
        this.movingUp = targetFloor > currentFloor;
    }

    public void move() {
        if (currentFloor < targetFloor) {
            currentFloor++;
        } else if (currentFloor > targetFloor) {
            currentFloor--;
        }
    }

    public boolean isIdle() {
        return currentFloor == targetFloor;
    }
}
