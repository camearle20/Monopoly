package net.came20.monopoly.common.item;

import net.came20.monopoly.common.data.Benefit;
import net.came20.monopoly.common.data.Expense;
import net.came20.monopoly.common.data.MoneyModifier;
import net.came20.monopoly.common.event.*;

/**
 * Created by cameronearle on 12/27/16.
 */
public class MoneyStack extends Item {
    private long value;

    public MoneyStack(long value) {
        this.value = value;
        setEventGroup(new EventGroup<MoneyStackChangeEventHandler>());
    }

    public long getValue() {
        return value;
    }

    public boolean doExpense(Expense expense) {
        if (expense.getValue() > value) { //If the expense is worth more than we have
            return false;
        } else {
            value = value - expense.getValue(); //Remove the expense from the balance
            getEventGroup().callGroup(new MoneyStackChangeEvent(value));
            return true;
        }
    }

    public boolean doBenefit(Benefit benefit) {
        value = value + benefit.getValue(); //Add the benefit to the balance
        getEventGroup().callGroup(new MoneyStackChangeEvent(value));
        return true;
    }

    public boolean doMoneyModiier(MoneyModifier modifier) {
        if (modifier instanceof Expense) {
            return doExpense((Expense) modifier);
        } else if (modifier instanceof Benefit) {
            return doBenefit((Benefit) modifier);
        } else {
            return false;
        }
    }

    public MoneyStack withdraw(long amount) {
        if (amount > value) {
            return new MoneyStack(0); //Return an empty moneystack
        } else {
            value = value - amount;
            getEventGroup().callGroup(new MoneyStackChangeEvent(value));
            return new MoneyStack(amount);
        }
    }

    public void deposit(MoneyStack moneyStack) {
        value = value + moneyStack.getValue(); //Add their money to our money
        getEventGroup().callGroup(new MoneyStackChangeEvent(value));
        moneyStack.value = 0; //Zero their money so it is no longer usable
    }
}
