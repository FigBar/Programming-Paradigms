import machine.CoffeeMachineImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    public static CoffeeMachineImpl machine1 = new CoffeeMachineImpl(5, 250.0, 40.0);
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean toFinish = true;
        while (toFinish) {
            printMenu();
            System.out.println("Choose what you want to do!");
            int choice = getNumberBetween(1, 6);
            switch (choice) {
                case 1:
                    machine1.printOutMenu();
                    int coffeeChoice = getNumberBetween(1, 3);
                    System.out.println(machine1.makeCoffee(coffeeChoice));
                    break;
                case 2:
                    machine1.refillWater();
                    break;
                case 3:
                    machine1.refillMilk();
                    break;
                case 4:
                    machine1.refillCoffee();
                    break;
                case 5:
                    machine1.emptyCoffeeWaste();
                    break;
                case 6:
                    System.out.println("Turning coffee machine off");
                    toFinish = false;
                    break;
                default:
                    System.out.println("Something went wrong. Try again!!!");
                    break;
            }
        }
    }

    private static int getNumberBetween(int lowBorder, int highBorder) {
        int givenNumber;
        do {
            System.out.print("Write a integer between " + lowBorder + " and " + highBorder + ": ");
            try {
                givenNumber = sc.nextInt();
            } catch (InputMismatchException ime) {
                givenNumber = -1;
            }
        } while (givenNumber < lowBorder || givenNumber > highBorder || givenNumber == -1);
        return givenNumber;
    }

    private static void printMenu() {
        System.out.println("########MENU########" + "\n"
        + "1. Make coffee" + "\n"
        + "2. Refill water" + "\n"
        + "3. Refill milk" + "\n"
        + "4. Refill coffee" + "\n"
        + "5. Empty coffee waste container" + "\n"
        + "6. Turn off" + "\n"
        + "####################" + "\n");
    }
}
