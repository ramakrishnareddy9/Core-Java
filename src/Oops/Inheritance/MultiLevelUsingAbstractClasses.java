package Oops.Inheritance;

abstract class Payment {
    abstract void validate();
    abstract void pay();
}

abstract class CardPayment extends Payment {
    String cardNumber;

    CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    void validate() {
        if (cardNumber.length() == 16) {
            System.out.println("Card number is valid.");
        } else {
            System.out.println("Invalid card number.");
        }
    }
    // pay() not implemented → so CardPayment must remain abstract
}

class CreditCardPayment extends CardPayment {
    double amount;

    CreditCardPayment(String cardNumber, double amount) {
        super(cardNumber);
        this.amount = amount;
    }

    @Override
    void pay() {
        System.out.println("Paid " + amount + " using Credit Card ending with " + cardNumber.substring(cardNumber.length() - 4));
    }
}

public class MultiLevelUsingAbstractClasses {
    public static void main(String[] args) {
        Payment p = new CreditCardPayment("1234567812345678", 5000.00);
        p.validate();  // from CardPayment
        p.pay();       // from CreditCardPayment
    }
}
