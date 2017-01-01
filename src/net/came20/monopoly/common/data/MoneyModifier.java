package net.came20.monopoly.common.data;

/**
 * Created by cameronearle on 12/27/16.
 */
public class MoneyModifier {
    private long value;

    public MoneyModifier(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
