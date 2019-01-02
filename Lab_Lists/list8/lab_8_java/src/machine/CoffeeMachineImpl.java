package machine;

import coffee.Cappuccino;
import coffee.Espresso;
import coffee.FlatWhite;
import machine.components.*;

public class CoffeeMachineImpl implements CoffeeMachine {

    private EmptiedContainerImpl coffeeWaste;
    private RefillableContainerImpl milkContainer;
    private RefillableContainerImpl waterContainer;
    private RefillableContainerImpl coffeeBeansContainer;
    private int coffeeBeansPortion;
    private double waterPortion;
    private double milkPortion;

    public CoffeeMachineImpl(int coffeeBeansPortion, double waterPortion, double milkPortion) {
        this.coffeeBeansPortion = coffeeBeansPortion;
        this.waterPortion = waterPortion;
        this.milkPortion = milkPortion;

        this.coffeeWaste = new EmptiedContainerImpl<>(0, 10,
                Substance.PRESSED_COFFEE_TRASH, 0, "piece");
        this.milkContainer = new RefillableContainerImpl<>(50.0, 1000.0,
                Substance.MILK, 900.0, "ml");
        this.waterContainer = new RefillableContainerImpl<>(100.0, 2000.0,
                Substance.WATER, 1900.0, "ml");
        this.coffeeBeansContainer = new RefillableContainerImpl<>(20, 500,
                Substance.COFFEE_BEAN, 400, "bean");
    }

    @Override
    public void frothMilk() {
        if (checkMilkContainer()) {
            milkContainer.setActualSubstanceAmount(milkContainer.getActualSubstanceAmount().doubleValue() - milkPortion);
            System.out.println("Frothing milk!");
        }
    }

    private Boolean checkMilkContainer() {
        if (!milkContainer.isEmpty(milkPortion)) {
            return true;
        } else {
            System.out.println("Refill milk container!");
            return false;
        }
    }

    @Override
    public void boilWater() {
        if (!waterContainer.isEmpty(waterPortion)) {
            waterContainer.setActualSubstanceAmount(waterContainer.getActualSubstanceAmount().doubleValue() - waterPortion);
            System.out.println("Boiling water!");
        }
    }

    private Boolean checkWaterContainer() {
        if (!waterContainer.isEmpty(waterPortion)) {
            return true;
        } else {
            System.out.println("Refill water container!");
            return false;
        }
    }

    @Override
    @SuppressWarnings("Duplicates")
    public String makeCoffee(int choice) {
        switch (choice) {
            case 1: //espresso
                if (checkWasteContainer() && checkWaterContainer() && checkCoffeeContainer()) {
                    boilWater();
                    grindCoffee();
                    disposeWaste();
                    return new Espresso().toString();
                }
                break;
            case 2:
                if (checkWasteContainer() && checkWaterContainer() && checkMilkContainer() && checkCoffeeContainer()) {
                    boilWater();
                    grindCoffee();
                    frothMilk();
                    disposeWaste();
                    return new Cappuccino().toString();
                }
                break;
            case 3:
                if (checkWasteContainer() && checkWaterContainer() && checkMilkContainer() && checkCoffeeContainer()) {
                    boilWater();
                    grindCoffee();
                    frothMilk();
                    disposeWaste();
                    return new FlatWhite().toString();
                }
                break;
        }
        return null;
    }

    private void grindCoffee() {
        coffeeBeansContainer.setActualSubstanceAmount(coffeeBeansContainer.getActualSubstanceAmount().intValue() - coffeeBeansPortion);
        System.out.println("Grinding coffee!");
    }

    private Boolean checkCoffeeContainer() {
        if (!coffeeBeansContainer.isEmpty(coffeeBeansPortion)) {
            return true;
        } else {
            System.out.println("Refill coffee beans container!");
            return false;
        }
    }


    private void disposeWaste() {
        coffeeWaste.setActualSubstanceAmount(coffeeWaste.getActualSubstanceAmount().intValue() + 1);
        System.out.println("Waste disposal!");
    }

    private Boolean checkWasteContainer() {
        if (!coffeeWaste.isFull(1)) {
            return true;
        } else {
            System.out.println("Empty coffee waste container!");
            return false;
        }
    }

    public void refillWater() {
        this.waterContainer.refill();
        System.out.println("Water container has been refilled");
    }

    public void refillMilk() {
        this.milkContainer.refill();
        System.out.println("Milk container has been refilled");
    }

    public void refillCoffee() {
        this.coffeeBeansContainer.refill();
        System.out.println("Coffee beans container has been refilled");
    }

    public void emptyCoffeeWaste() {
        this.coffeeWaste.empty();
        System.out.println("The coffee waste container has been emptied");
    }

    public void printOutMenu() {
        System.out.println("#####COFFEE_MENU#####" + "\n"
                + "1. Espresso" + "\n"
                + "2. Cappuccino" + "\n"
                + "3. Flat White" + "\n"
        );
    }


}
