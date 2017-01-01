package net.came20.monopoly.run.player.gui;

import net.came20.monopoly.common.Player;
import net.came20.monopoly.common.event.MoneyStackChangeEvent;
import net.came20.monopoly.common.event.MoneyStackChangeEventHandler;
import net.came20.monopoly.common.event.Side;
import net.came20.monopoly.common.event.Sided;

import javax.swing.*;
import java.awt.event.*;

public class TestDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel moneyCounter;

    public TestDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void setMoneyCounter(long amnt) {
        moneyCounter.setText(Long.toString(amnt));
    }

    private Player player;

    public void addPlayer(Player player) {
        this.player = player;
        this.player.getBankAccount().getEventGroup().addEventHandler(new MoneyStackChangeEventHandler() {
            @Override
            @Sided(Side.PLAYER)
            public void onEvent(MoneyStackChangeEvent e) {
                setMoneyCounter(e.getAmount());
            }
        });
    }
}
