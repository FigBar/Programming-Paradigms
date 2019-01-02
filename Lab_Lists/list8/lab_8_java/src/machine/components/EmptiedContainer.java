package machine.components;

public interface EmptiedContainer <T extends Number> {
    Boolean isFull(T amountToAdd);
    void empty();
}
