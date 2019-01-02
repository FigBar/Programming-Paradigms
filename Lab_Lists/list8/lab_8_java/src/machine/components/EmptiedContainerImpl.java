package machine.components;

public class EmptiedContainerImpl<T extends Number> implements EmptiedContainer<T>{

    private T zeroAmountValue;
    private T maxSubstanceAmount;
    private Substance substanceType;
    private T actualSubstanceAmount;
    private String unit;

    public EmptiedContainerImpl(T zeroAmountValue, T maxSubstanceAmount, Substance substanceType, T actualSubstanceAmount, String unit) {
        this.zeroAmountValue = zeroAmountValue;
        this.maxSubstanceAmount = maxSubstanceAmount;
        this.substanceType = substanceType;
        this.actualSubstanceAmount = actualSubstanceAmount;
        this.unit = unit;
    }

    @Override
    public Boolean isFull(T amountToAdd) {
        return (actualSubstanceAmount.doubleValue() + amountToAdd.doubleValue() > maxSubstanceAmount.doubleValue());
    }

    @Override
    public void empty() {
        actualSubstanceAmount = zeroAmountValue;
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
