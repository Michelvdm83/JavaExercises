package playersguide.TheLockedDoor;

public class Door {
    enum StateDoor {
        locked,
        closed,
        open
    }

    private int passcode;
    private StateDoor state;

    public Door(int passcode) {
        this.passcode = passcode;
        state = StateDoor.closed;
    }

    public void changeCode(int oldCode, int newCode) {
        if (passcode == oldCode) {
            passcode = newCode;
        } else {
            System.out.println("Wrong passcode!");
        }
    }

    public void unlockDoor(int code) {
        if (state != StateDoor.locked) {
            System.out.println("Door isn't locked.");
        } else if (passcode == code) {
            state = StateDoor.closed;
        } else {
            System.out.println("Wrong passcode!");
        }
    }

    public void lockDoor() {
        if (state == StateDoor.closed) {
            state = StateDoor.locked;
        } else {
            System.out.println("Door can only be locked from closed state.");
        }
    }

    public void openDoor() {
        if (state == StateDoor.closed) {
            state = StateDoor.open;
        } else {
            System.out.println("Door can only be opened from closed state");
        }
    }

    public void closeDoor() {
        if (state == StateDoor.open) {
            state = StateDoor.closed;
        } else {
            System.out.println("Door can only be closed from open state");
        }
    }

    public String getState() {
        return state.toString();
    }
}
