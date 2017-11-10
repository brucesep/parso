//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package bruce.pars;

import bruce.pars.panelCH;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GoToHell implements ActionListener {
    panelCH parent;
    String paramKey;
    String paramFile;
    String probel = " ";

    GoToHell(panelCH parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e2) {
        this.paramKey = this.parent.keyText.getText();
        this.paramFile = this.parent.chooseText.getText();
        if(this.paramKey.length() <= 0 && this.paramFile.length() <= 0) {
            JPanel pan1 = new JPanel();
            JLabel text11 = new JLabel("Nothing to do, sorry!");
            pan1.add(text11);
            JOptionPane.showMessageDialog((Component)null, pan1, "Are you seriuosly?", -1);
        } else {
            try {
                DocumentBuilderFactory pan = DocumentBuilderFactory.newInstance();
                DocumentBuilder text1 = pan.newDocumentBuilder();
                Document docum = text1.parse(new File(this.paramFile));
                docum.getDocumentElement().normalize();
                Element root = docum.getDocumentElement();
                System.out.println("Root element is: " + root.getNodeName());
                System.out.println("---------------------------------");
                System.out.println("---------------------------------");
                NodeList noList = docum.getElementsByTagName(this.paramKey);
                this.parSo(noList);
            } catch (Exception var7) {
                var7.printStackTrace();
            }
        }

    }

    public void parSo(NodeList nnL) {
        for(int i = 0; i < nnL.getLength(); ++i) {
            Node uzelS = nnL.item(i);
            System.out.println("Requested tag is: " + uzelS.getNodeName());
            this.parSU(uzelS, 0, this.probel);
        }

    }

    public void parSU(Node nodde, int level, String probe2) {
        NodeList parUzla = nodde.getChildNodes();
        probe2 = probe2 + " ";

        for(int j = 0; j < parUzla.getLength(); ++j) {
            Node samUz = parUzla.item(j);
            System.out.println(probe2 + samUz.getNodeName() + " " + samUz.getTextContent());
            this.parSU(samUz, level + 1, probe2);
        }

    }
}
