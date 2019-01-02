package coffee;

public class FlatWhite extends Coffee{

    public FlatWhite() {
        this.type = this.getClass().getSimpleName();
        this.coffeeTaste = Taste.GENTLE;
        this.doesContainMilk = true;
    }

    @Override
    public String toString() {
        return "FlatWhite{" +
                "type='" + type + '\'' +
                ", coffeeTaste=" + coffeeTaste +
                ", doesContainMilk=" + doesContainMilk +
                '}';
    }
}
