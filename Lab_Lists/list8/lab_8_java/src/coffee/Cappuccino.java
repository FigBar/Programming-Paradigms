package coffee;

public class Cappuccino extends Coffee {

    public Cappuccino() {
        this.type = this.getClass().getSimpleName();
        this.coffeeTaste = Taste.SWEET;
        this.doesContainMilk = true;
    }

    @Override
    public String toString() {
        return "Cappuccino{" +
                "type='" + type + '\'' +
                ", coffeeTaste=" + coffeeTaste +
                ", doesContainMilk=" + doesContainMilk +
                '}';
    }
}
