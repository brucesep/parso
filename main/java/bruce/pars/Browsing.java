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
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Browsing implements ActionListener {
    panelCH parent;
    String path;
    File file;
    JFileChooser fileOp;

    Browsing(panelCH parent) {
        this.parent = parent;
    }

    public void actionPerformed(ActionEvent e1) {
        this.fileOp = new JFileChooser();
        //this.fileOp.setFileFilter(new Browsing.FileFilterE("json", "*.json"));
        this.fileOp.setFileFilter(new Browsing.FileFilterE("xml", "*.xml"));
        this.fileOp.setFileFilter(new FileNameExtensionFilter("xml/json", new String[]{"xml", "json"}));
        int ret = this.fileOp.showDialog((Component)null, "Choose it");
        if(ret == 0) {
            this.file = this.fileOp.getSelectedFile();
            this.path = this.file.getPath();
        }

        this.parent.chooseText.setText(this.path);
    }

    class FileFilterE extends FileFilter {
        String extention;
        String extension2;
        String description;

        FileFilterE(String extention, String descr) {
            this.extention = extention;
            this.description = descr;
        }

        public boolean accept(File file) {
            return file != null?(file.isDirectory()?true:(this.extention == null?this.extention.length() == 0:file.getName().endsWith(this.extention))):false;
        }

        public String getDescription() {
            return this.description;
        }
    }
}
