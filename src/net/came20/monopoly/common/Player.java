package net.came20.monopoly.common;

import net.came20.monopoly.common.item.MoneyStack;
import net.came20.monopoly.common.item.TitleDeed;
import net.came20.monopoly.common.item.TitleDeedStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cameronearle on 12/27/16.
 */
public class Player {
    private MoneyStack bankAccount = new MoneyStack(15000000); //Start each player with 15 million dollars
    private TitleDeedStack realEstateBank = new TitleDeedStack();
    private String token = Tokenizer.nextToken();
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public Player(Player oldPlayer) { //Full clone a player, we need to do this to re-initialize it when the server sends a new one
        this.bankAccount = oldPlayer.bankAccount;
        this.realEstateBank = oldPlayer.realEstateBank;
        this.token = oldPlayer.token;
        this.name = oldPlayer.name;
    }

    public String getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public MoneyStack getBankAccount() {
        return bankAccount;
    }

    public TitleDeedStack getRealEstateBank() {
        return realEstateBank;
    }

}
