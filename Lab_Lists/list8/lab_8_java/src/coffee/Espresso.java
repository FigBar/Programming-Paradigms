package coffee;

public class Espresso extends Coffee {

    public Espresso() {
        this.type = this.getClass().getSimpleName();
        this.coffeeTaste = Taste.SOUR;
        this.doesContainMilk = false;
    }

    @Override
    public String toString() {
        return "Espresso{" +
                "type='" + type + '\'' +
                ", coffeeTaste=" + coffeeTaste +
                ", doesContainMilk=" + doesContainMilk +
                '}';
    }
}
