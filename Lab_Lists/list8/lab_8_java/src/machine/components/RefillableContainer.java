package machine.components;

public interface RefillableContainer<T extends Number> {

    Boolean isEmpty(T takenAmount);

    void refill();
}

