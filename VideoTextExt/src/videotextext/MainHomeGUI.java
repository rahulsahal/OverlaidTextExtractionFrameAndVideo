/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videotextext;


import AllVideo.Out;
import videotextext.VideoExtraction;
import com.mathworks.toolbox.javabuilder.MWException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;



public class MainHomeGUI extends JFrame {

    private JPanel contentPane;
    public static JFileChooser chooser = new JFileChooser();
    public static File file;
    public static File clfile;
    public static String str;
    public static int count = 0;
    final JTextField pa = new JTextField();

    
    public JFrame myscreen;

  
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainHomeGUI frame = new MainHomeGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainHomeGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0, 1500,1000);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel header;
        JButton sbmt=new JButton("Submit");
        // textarea
        ImageIcon imgicn = new ImageIcon(System.getProperty("user.dir")+"\\Header.jpg");
        header = new JLabel(imgicn);
        pa.setBounds(650, 250, 200, 100);
        contentPane.add(pa);
        contentPane.setBackground(Color.cyan);
        //pa.disable();
        Border border = BorderFactory.createLineBorder(Color.ORANGE);
        pa.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        
        header.setBounds(250, 60, 900, 100);
        sbmt.setBounds(700, 400, 60, 30);
        header.setBackground(Color.yellow);

        contentPane.add(header);
        contentPane.add(sbmt);
        
        
        
         sbmt.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
         sbmt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String nframe=pa.getText();
               int fn=Integer.parseInt(nframe);
               System.out.println("value of nframe is"+fn);
                try {
                    Out o=new Out();
                    o.Allprocess(1, fn);
                    
                    VideoExtraction ve=new VideoExtraction();
                    ve.main1();
                    
                    
                    
                    
                } catch (MWException ex) {
                    Logger.getLogger(MainHomeGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
       
    }

}
