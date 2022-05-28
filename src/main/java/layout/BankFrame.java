package layout;

import entity.BankAccount;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * 1. JFrame, container
 * 2. UI controls
 * 3. LayoutManager
 */
public class BankFrame extends JFrame {

    private JLabel fromAccountLabel = new JLabel("From:");
    private JLabel toAccountLabel = new JLabel("To:");
    private JLabel amountLabel = new JLabel("Amount:");
    private JComboBox<BankAccount> fromAccountComboBox = new JComboBox<>();
    private JComboBox<BankAccount> toAccountComboBox = new JComboBox<>();
    private JTextField amountTextField = new JTextField(10);
    private JButton transferAmountButton = new JButton("Transfer money");

    public BankFrame() {
        setTitle("Bank account transfer screen");
        setSize(400, 250);
        setLayout(new GridLayout(4, 1));
        //panel-> labela:komponenta
        JPanel fromPanel = new JPanel();
        fromPanel.add(fromAccountLabel);
        fromPanel.add(fromAccountComboBox);
        add(fromPanel);
        JPanel toPanel = new JPanel();
        toPanel.add(toAccountLabel);
        toPanel.add(toAccountComboBox);
        add(toPanel);
        JPanel amountPanel = new JPanel();
        amountPanel.add(amountLabel);
        amountPanel.add(amountTextField);
        add(amountPanel);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(transferAmountButton);
        add(buttonPanel);
        //filling with bank account object combo boxes
        fillBankAccountComboBoxes();
        transferAmountButton.addActionListener(this::transferMoney);
    }

    private void fillBankAccountComboBoxes() {

        //
        List<BankAccount> bankAccounts = BankAccount.loadAll();
        for (BankAccount bankAccount : bankAccounts) {
            fromAccountComboBox.addItem(bankAccount);
            toAccountComboBox.addItem(bankAccount);
        }
    }

    private void transferMoney(ActionEvent e) {
        //Ažuriramo bazu
        BankAccount fromBankAccount = (BankAccount) fromAccountComboBox.getSelectedItem();
        BankAccount toBankAccount = (BankAccount) toAccountComboBox.getSelectedItem();
        Double amount = Double.parseDouble(amountTextField.getText());
        BankAccount.transferMoney(fromBankAccount, toBankAccount, amount);
        //REFRESH UI
        fromAccountComboBox.removeAllItems();
        toAccountComboBox.removeAllItems();
        fillBankAccountComboBoxes();
        fromAccountComboBox.setSelectedItem(fromBankAccount);
        toAccountComboBox.setSelectedItem(toBankAccount);
        amountTextField.setText("");
    }

    public void showFrame() {
        pack();
        setVisible(true);
    }
}

