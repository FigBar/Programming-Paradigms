package machine.components;

public class RefillableContainerImpl<T extends Number> implements RefillableContainer<T> {
    private T lowSubstanceAmount;
    private T maxSubstanceAmount;
    private Substance substanceType;
    private T actualSubstanceAmount;
    private String unit;

    public RefillableContainerImpl(T lowSubstanceAmount, T maxSubstanceAmount, Substance substanceType, T actualSubstanceAmount, String unit) {
        this.lowSubstanceAmount = lowSubstanceAmount;
        this.maxSubstanceAmount = maxSubstanceAmount;
        this.substanceType = substanceType;
        this.actualSubstanceAmount = actualSubstanceAmount;
        this.unit = unit;
    }

    @Override
    public Boolean isEmpty(T takenAmount) {
        return (actualSubstanceAmount.doubleValue() - takenAmount.doubleValue() < lowSubstanceAmount.doubleValue());
    }

    @Override
    public void refill() {
        this.actualSubstanceAmount = maxSubstanceAmount;
    }

    @Override
    public T getActualSubstanceAmount() {
        return actualSubstanceAmount;
    }

    @Override
    public void setActualSubstanceAmount(T actualSubstanceAmount) {
        this.actualSubstanceAmount = actualSubstanceAmount;
    }

    public Substance getSubstanceType() {
        return substanceType;
    }

    public String getUnit() {
        return unit;
    }
}
