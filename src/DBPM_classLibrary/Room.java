package DBPM_classLibrary;

public class Room {
    private int number;

    public Room(){}

    public Room(int number) {
        setNumber(number);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int newNumber) {
        number = newNumber;
    }

    @Override
    public String toString() {
        return "Room number: " + number;
    }

    public static void main(String[] args) {
        Room room = new Room(59);

        System.out.println(room.getNumber());
        System.out.println(room);
    }
}
