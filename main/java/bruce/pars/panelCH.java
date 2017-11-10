//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package bruce.pars;

import bruce.pars.Browsing;
import bruce.pars.GoToHell;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class panelCH {
    JPanel mainForm = new JPanel();
    JLabel labelKey;
    JLabel labelValue;
    JLabel labelRem;
    JTextField chooseText;
    JTextField keyText;
    JTextField valueText;
    JButton browsButt;
    JButton goButt;

    panelCH() {
        this.mainForm.setLayout((LayoutManager)null);
        this.browsButt = new JButton("Choose file (xml/json)");
        this.browsButt.setBounds(10, 10, 160, 20);
        this.labelKey = new JLabel("Specify the key: ");
        this.labelKey.setBounds(10, 35, 150, 20);
        this.chooseText = new JTextField(400);
        this.chooseText.setBounds(175, 10, 400, 20);
        this.keyText = new JTextField(150);
        this.keyText.setBounds(175, 35, 150, 20);
        this.goButt = new JButton("GO!");
        this.goButt.setBounds(500, 60, 75, 20);
        this.mainForm.add(this.labelKey);
        this.mainForm.add(this.browsButt);
        this.mainForm.add(this.chooseText);
        this.mainForm.add(this.keyText);
        this.mainForm.add(this.goButt);
        JFrame parsFrame = new JFrame("Parsing");
        parsFrame.setContentPane(this.mainForm);
        parsFrame.setSize(600, 150);
        parsFrame.setVisible(true);
        parsFrame.setDefaultCloseOperation(3);
        Browsing bR = new Browsing(this);
        this.browsButt.addActionListener(bR);
        GoToHell gToH = new GoToHell(this);
        this.goButt.addActionListener(gToH);
    }
}
