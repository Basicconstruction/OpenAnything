package boostUp;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {
    public MainFrame() {
        super();
        setTitle("Open Anything");
        setBounds(400,300,500,200);
        Clipboard cb = this.getToolkit().getSystemClipboard();
        JPanel j1 = new JPanel();
        setContentPane(j1);
        j1.setLayout(null);
        JTextField jf1 = new JTextField();
        jf1.setBounds(0,0,500,40);
        j1.add(jf1);
        JButton jb1 = new JButton("打开");
        jb1.setBounds(200,100,100,70);
        j1.add(jb1);
        jb1.addActionListener(e -> {
            String s = jf1.getText();
            Desktop dek = Desktop.getDesktop();
            if(dek.isSupported(Desktop.Action.OPEN)){
                try {
                    dek.open(new File(s));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JButton jb2 = new JButton("粘贴并打开");
        jb2.setBounds(40,70,100,40);
        j1.add(jb2);
        jb2.addActionListener(e->{
            Transferable content = cb.getContents(this);

            try {
                if (content.getTransferData(DataFlavor.stringFlavor) instanceof String) {
                    jf1.setText((String)content.getTransferData(DataFlavor.stringFlavor));
                }
            } catch (IOException | UnsupportedFlavorException var5) {
                var5.printStackTrace();
            }
            String s = jf1.getText();
            Desktop dek = Desktop.getDesktop();
            if(dek.isSupported(Desktop.Action.OPEN)){
                try {
                    dek.open(new File(s));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JButton jb3 = new JButton("粘贴");
        jb3.setBounds(360,70,100,40);
        j1.add(jb3);
        jb3.addActionListener(e->{
            Transferable content = cb.getContents(this);

            try {
                if (content.getTransferData(DataFlavor.stringFlavor) instanceof String) {
                    jf1.setText((String)content.getTransferData(DataFlavor.stringFlavor));
                }
            } catch (IOException | UnsupportedFlavorException var5) {
                var5.printStackTrace();
            }
        });
    }
}
