package net.came20.monopoly.common.event;

/**
 * Created by cameronearle on 12/28/16.
 */
public class MoneyStackChangeEvent implements Event {
    private long amount;

    public MoneyStackChangeEvent(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }
}
