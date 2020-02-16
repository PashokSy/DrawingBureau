package DBPM_classLibrary;

import java.time.LocalDate;

public class IdCard {
    private int number;
    private String dateExpire;

    public IdCard(){}

    public IdCard(int number) {
        String date = LocalDate.now().plusDays(365).toString();

        setNumber(number);
        setDateExpire(date);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int newNumber) {
        number = newNumber;
    }

    public String getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(String newDate) {
        dateExpire = newDate;
    }

    @Override
    public String toString() {
        return "IdCard number: " + number + "\n" +
                "IdCard date expire: " + dateExpire;
    }

    public static void main(String[] args) {
        IdCard card = new IdCard(482);

        System.out.println(card.getNumber());
        System.out.println(card.getDateExpire());
        System.out.println(card);
    }
}
