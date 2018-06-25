package SGUI;

import server.Windows1251Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;

public class PassFrame extends JFrame {
    Locale locale = Locale.getDefault();
    ResourceBundle rb = ResourceBundle.getBundle("locale.Resources", locale, new Windows1251Control());
    public PassFrame(JFrame frame) {
        super();
        setTitle(rb.getString("EnterPassword"));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(e.getComponent(), rb.getString("GoFinish"), rb.getString("Exit"), JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
                    System.exit(0);
                }
            }
        });
        JTextField textField = new JTextField();
        setLayout(new FlowLayout());
        add(textField);
        textField.setPreferredSize(new Dimension(150, 30));
        JButton ok = new JButton("OK");
        add(ok);

        ok.addActionListener((e) -> {
            if (textField.getText().equals("p")) {
                frame.setVisible(true);
                dispose();
            } else
                JOptionPane.showMessageDialog(this, rb.getString("Incorr"), rb.getString("Error"), JOptionPane.ERROR_MESSAGE);
        });
        setMinimumSize(new Dimension(250, 70));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}