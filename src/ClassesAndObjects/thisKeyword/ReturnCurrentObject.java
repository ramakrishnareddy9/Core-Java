package ClassesAndObjects.thisKeyword;

class Account {
    int balance;

    Account deposit(int amount) {
        balance += amount;
        return this; // returns current object
    }

    Account withdraw(int amount) {
        balance -= amount;
        return this; // returns current object
    }

    void showBalance() {
        System.out.println("Balance: " + balance);
    }
}

public class ReturnCurrentObject {
    public static void main(String[] args) {
        Account acc = new Account();
        acc.deposit(1000).withdraw(200).showBalance(); // method chaining
    }
}