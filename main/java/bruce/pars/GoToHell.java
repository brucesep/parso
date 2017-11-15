//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package bruce.pars;

import bruce.pars.panelCH;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.*;
import javax.swing.text.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GoToHell implements ActionListener {
    panelCH parent;
    String paramKey;
    String paramFile;
    String probel = " ";
    JFrame frame;
    JPanel panel;
    JTextArea textArea;
    StringBuffer content;


    GoToHell(panelCH parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e2) {
        this.paramKey = this.parent.keyText.getText();
        this.paramFile = this.parent.chooseText.getText();

        frame = new JFrame("Final rezults");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        textArea = new JTextArea();
        panel.add(new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
        content = new StringBuffer();
        frame.setSize(600, 400);
        frame.add(panel);


        if (this.paramKey.length() <= 0 && this.paramFile.length() <= 0) {
            JPanel pan1 = new JPanel();
            JLabel text11 = new JLabel("Nothing to do, sorry!");
            pan1.add(text11);
            JOptionPane.showMessageDialog((Component) null, pan1, "Are you seriuosly?", -1);
        } else {
            try {
                DocumentBuilderFactory pan = DocumentBuilderFactory.newInstance();
                DocumentBuilder text1 = pan.newDocumentBuilder();
                Document docum = text1.parse(new File(this.paramFile));

                docum.getDocumentElement().normalize();
                Element root = docum.getDocumentElement();
                String fLine = "Root element is: " + root.getNodeName();
                //System.out.println(fLine);
                content.append(fLine + "\n");
                String sLine = "---------------------------------";
                //System.out.println(sLine);
                content.append(sLine + "\n");
                NodeList noList = docum.getElementsByTagName(this.paramKey);
                parSo(noList);
                //parXpa(docum, paramKey);
                textArea.setText(content.toString());
                textArea.setCaretPosition(0);
                frame.setVisible(true);
            } catch (Exception var7) {
                var7.printStackTrace();
            }
        }
    }

   /* public void parXpa(Document document, String parK) throws DOMException, XPathExpressionException {
        System.out.println("Requested Node: " + parK);
        XPathFactory pFac = XPathFactory.newInstance();
        XPath xPa = pFac.newXPath();
        XPathExpression expr = xPa.compile("//" + parK);

        NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            System.out.println("Value: " + n.getTextContent());
        }
    }*/

    public void parSo(NodeList nnL) {
        for (int i = 0; i < nnL.getLength(); ++i) {
            Node uzelS = nnL.item(i);
            //System.out.print("Requested tag is: " + uzelS.getNodeName() + " ");
            content.append("----------" + "\n");
            content.append("Requested tag is: " + uzelS.getNodeName() + " ");
            NamedNodeMap nodeAtr = uzelS.getAttributes();
            String wwam = "";
            int mMax = nodeAtr.getLength();
            for (int j = 0; j < mMax; j++) {
                Node newNN = nodeAtr.item(j);
                if (j != (mMax - 1)) {
                    wwam = newNN.getNodeName() + " = " + "\"" + newNN.getTextContent() + "\"" + ", ";
                } else {
                    wwam = newNN.getNodeName() + " = " + "\"" + newNN.getTextContent() + "\".";
                }
                //System.out.print(wwam);
                content.append(wwam);
            }
            //System.out.println("");
            content.append("\n" + "----------");
            content.append("\n");
            parSU(uzelS, 0, this.probel);
        }
    }

    public void parSU(Node nodde, int level, String probe2) {
        NodeList parUzla = nodde.getChildNodes();
        probe2 = probe2 + "   ";
        for (int j = 0; j < parUzla.getLength(); ++j) {
            Node samUz = parUzla.item(j);
            if (samUz.getNodeType() == Node.TEXT_NODE) {
                continue;
            }
            //System.out.print(probe2 + samUz.getNodeName() + ": ");
            content.append(probe2 + samUz.getNodeName() + ": ");
            String wam = "";
            if (samUz.hasAttributes()) {
                NamedNodeMap attribs = samUz.getAttributes();
                int max = attribs.getLength();
                for (int k = 0; k < attribs.getLength(); k++) {
                    Node newN = attribs.item(k);
                    if (k != (max - 1)) {
                        wam = newN.getNodeName() + " = " + "\"" + newN.getTextContent() + "\"" + ", ";
                    } else {
                        wam = newN.getNodeName() + " = " + "\"" + newN.getTextContent() + "\"";
                    }
                    //System.out.print(wam);
                    content.append(wam);
                }
            }
            if (samUz.getNodeType() != Node.TEXT_NODE) {
                //System.out.print(" " + samUz.getTextContent());
                content.append(" " + samUz.getTextContent());
            }

            //System.out.println("");
            content.append("\n");
            this.parSU(samUz, level + 1, probe2);
        }
    }
}
