package layout;

import javax.swing.SwingUtilities;

public class Demo {
    public static void main(String[] args) {
        BankFrame bankFrame = new BankFrame();
        SwingUtilities.invokeLater(bankFrame::showFrame);
    }
}
