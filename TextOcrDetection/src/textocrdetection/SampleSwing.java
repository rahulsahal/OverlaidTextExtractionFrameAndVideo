
package textocrdetection;




import DetectText.Detection;
import Graphs.Out;
import Input.Inp;
import Mser.MserOut;
import OcrText.Ocrres;
import Videoin.Vin;
//import OcrOut.Ocrres;
import Preprocessing.Preprocess;
import Regions.SearchReg;
import Textarea.Text;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
//import static textocrdetection.HomeGUI2.IMAGE_FILTER;
//import static textocrdetection.HomeGUI2.n;
//import static textocrdetection.HomeGUI2.str;

public class SampleSwing extends JFrame {

    
    Object[] obj1 = new Object[40];
    Object[] obj2 = new Object[100];
    Object[] obj3 = new Object[100];
    Object[] obj4 = new Object[100];
    Object[] obj5 = new Object[100];
    Object[] obj6 = new Object[100];
    Object[] obj7 = new Object[100];
    
    private JPanel contentPane;
    public static JFileChooser chooser = new JFileChooser();
    public File[] files;
    public static File clfile;
    public String name1, name2, name3, path1, path2, path3;
    public static int count = 0;
    final JTextPane pa = new JTextPane();
    JScrollPane jsp=new JScrollPane(pa);
    
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    OutputStream os = null;
    ServerSocket servsock = null;
    Socket sock = null;
    JLabel header;
    JFrame frame;
    BufferedImage image;
    StyledDocument doc;
    SimpleAttributeSet attr;
    public static int n = 0;
    public static Date date1;
    File OutputDir;
    File f;
    public static File fa = new File("testkeydata");
    public static long ji;
    public static String FileName;
    JLabel label,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11;
    

    static String[] EXTENSIONS = new String[]{
        "gif", "png", "bmp", "jpeg", "jpg" // and other formats you need
    };
    static FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(File dir, String name) {
            for (String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };
  
    public void ChooseTargetFile() {
       
        chooser.setMultiSelectionEnabled(true);
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif", "png","tif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(SampleSwing.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            files = chooser.getSelectedFiles();
            System.out.println("files is" + files);

             
                path1 = files[0].getAbsolutePath();
                //path2 = files[1].getAbsolutePath();
              
                System.out.println("path is\n" + path1);

                ImageIcon img1 = new ImageIcon(path1);
                ImageIcon img2 = new ImageIcon(path2);
                ImageIcon img3 = new ImageIcon(path1);
                ImageIcon img4 = new ImageIcon(path1);
                ImageIcon img5 = new ImageIcon(path1);
                ImageIcon img6 = new ImageIcon(path1);
                ImageIcon img7 = new ImageIcon(path1);
                ImageIcon img8 = new ImageIcon(path1);
                ImageIcon img9 = new ImageIcon(path1);
                ImageIcon img10 = new ImageIcon(path1);
                ImageIcon img11 = new ImageIcon(path1);
                ImageIcon img12= new ImageIcon(path1);
                //ImageIcon img3 = new ImageIcon(path3);

                label = new JLabel(img1);
                label2 = new JLabel(img2);
                label3 = new JLabel(img2);
                label4 = new JLabel(img2);
                label5 = new JLabel(img2);
                label6 = new JLabel(img2);
                label7 = new JLabel(img2);
                label8 = new JLabel(img2);
                label9 = new JLabel(img2);
                label10 = new JLabel(img2);
                label11 = new JLabel(img2);
                
                
                
                
                //JLabel label3 = new JLabel(img3);

                label.setOpaque(true);
                //label.setPreferredSize(new Dimension(500,200));
                //label.setMinimumSize(new Dimension(10, 10));
                label.setMaximumSize(new Dimension(5, 5));
                label.setBackground(Color.gray);
                label.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                pa.setCaretPosition(pa.getDocument().getLength());
                pa.insertComponent(label);

                label2.setOpaque(true);
                //label2.setPreferredSize(new Dimension(500,200));
                //label2.setMaximumSize(new Dimension(50, 50));
                label2.setMaximumSize(new Dimension(5, 5));
                //label2.setMinimumSize(new Dimension(10, 10));
                label2.setBackground(Color.gray);
                label2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                pa.setCaretPosition(pa.getDocument().getLength());
                pa.insertComponent(label2);
                
                label3.setOpaque(true);
                //label.setPreferredSize(new Dimension(500,200));
                //label.setMinimumSize(new Dimension(10, 10));
                label3.setMaximumSize(new Dimension(20, 20));
                label3.setBackground(Color.gray);
                label3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                pa.setCaretPosition(pa.getDocument().getLength());
                pa.insertComponent(label3);
                
                label4.setOpaque(true);
                //label.setPreferredSize(new Dimension(500,200));
                //label.setMinimumSize(new Dimension(10, 10));
                label4.setMaximumSize(new Dimension(20, 20));
                label4.setBackground(Color.gray);
                label4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                pa.setCaretPosition(pa.getDocument().getLength());
                pa.insertComponent(label4);
                
                label5.setOpaque(true);
                //label.setPreferredSize(new Dimension(500,200));
                //label.setMinimumSize(new Dimension(10, 10));
                label5.setMaximumSize(new Dimension(20, 20));
                label5.setBackground(Color.gray);
                label5.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                pa.setCaretPosition(pa.getDocument().getLength());
                pa.insertComponent(label5);
                
                label6.setOpaque(true);
                //label.setPreferredSize(new Dimension(500,200));
                //label.setMinimumSize(new Dimension(10, 10));
                label6.setMaximumSize(new Dimension(20, 20));
                label6.setBackground(Color.gray);
                label6.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                pa.setCaretPosition(pa.getDocument().getLength());
                pa.insertComponent(label6);
                
                label7.setOpaque(true);
                //label.setPreferredSize(new Dimension(500,200));
                //label.setMinimumSize(new Dimension(10, 10));
                label7.setMaximumSize(new Dimension(20, 20));
                label7.setBackground(Color.gray);
                label7.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                pa.setCaretPosition(pa.getDocument().getLength());
                pa.insertComponent(label7);
                
                label8.setOpaque(true);
                //label.setPreferredSize(new Dimension(500,200));
                //label.setMinimumSize(new Dimension(10, 10));
                label8.setMaximumSize(new Dimension(20, 20));
                label8.setBackground(Color.gray);
                label8.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                pa.setCaretPosition(pa.getDocument().getLength());
                pa.insertComponent(label8);
                
                label9.setOpaque(true);
                //label.setPreferredSize(new Dimension(500,200));
                //label.setMinimumSize(new Dimension(10, 10));
                label9.setMaximumSize(new Dimension(20, 20));
                label9.setBackground(Color.gray);
                label9.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                pa.setCaretPosition(pa.getDocument().getLength());
                pa.insertComponent(label9);
                
                label10.setOpaque(true);
                //label.setPreferredSize(new Dimension(500,200));
                //label.setMinimumSize(new Dimension(10, 10));
                label10.setMaximumSize(new Dimension(20, 20));
                label10.setBackground(Color.gray);
                label10.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                pa.setCaretPosition(pa.getDocument().getLength());
                pa.insertComponent(label10);
                
                label11.setOpaque(true);
                //label.setPreferredSize(new Dimension(500,200));
                //label.setMinimumSize(new Dimension(10, 10));
                label11.setMaximumSize(new Dimension(20, 20));
                label11.setBackground(Color.gray);
                label11.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                pa.setCaretPosition(pa.getDocument().getLength());
                pa.insertComponent(label11);
                     
                try {
                Inp or = new Inp();
                obj1 = or.Function1(1, path1);
                JOptionPane.showMessageDialog(null, "Perform Next Operation......");
               

            } catch (Exception e) {
                System.out.println(e);
            } 
                
            }
        }

    public void videoGenerator() {
        try {
            Vin v = new Vin();

            v.Videoproc(1);
            
//            obj2 = g.Function2(1, obj1);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    
    
public void preProcess() {
        try {
            Preprocess g = new Preprocess();
            obj2 = g.Function2(1, obj1);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void textArea() {
        try {
            Text vv = new Text();
            obj3 = vv.Function3(1, obj2);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void mSER() {
        try {
            MserOut ss1 = new MserOut();
            obj4 = ss1.Function4(1,obj3);
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void searchRegion() {
        try {
            SearchReg ss = new SearchReg();
            obj5 = ss.Function5(1, obj4);
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void DetectText() {
        try {

            Detection cr = new Detection();
            obj6=cr.Function6(1, obj5);
           // obj6 = cr.Function6(1, obj5);
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
     public void showResult() {
        try {

            Out o=new Out();
            o.Function8();
           // obj6 = cr.Function6(1, obj5);
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
     public void createOCRFile() {
        try {

               
            
            
                Ocrres ocr=new Ocrres();
                 ocr.Function7(1, obj6);
           
              //txt.candidateregion(1, obj4);
              System.out.println("OCR file value is printed");
//            Detection cr = new Detection();
//            cr.Function6(1, obj6);
//           // obj6 = cr.Function6(1, obj5);
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

//    public void ocrOut() {
//        try {
//            Ocrres oc = new Ocrres();
//            obj7 = oc.Function7(1, obj6);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SampleSwing frame = new SampleSwing();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
   

    public SampleSwing() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1500, 1000);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JButton f1,vb,f2, f3, f4, f5, f6, f7,show;
        
        JButton browse;
        
        JButton mic;
        JButton tiles;
        JLabel secret;
        JLabel target;
        
        final JLabel label;
        final JLabel label1;
        ImageIcon imgicn = new ImageIcon(System.getProperty("user.dir")+"\\Header.jpg");
        ImageIcon imgicn2 = new ImageIcon("C:/Users/User3/Documents/NetBeansProjects/secret sharing scheme/Header.jpg");
        
        

        doc = pa.getStyledDocument();
        attr = new SimpleAttributeSet();

        label = new JLabel();
        label1 = new JLabel();
        JLabel title = new JLabel(imgicn2);
        header = new JLabel(imgicn);
         secret=new JLabel("Secret");
        target=new JLabel("Target");

        header.setVerticalTextPosition((int) CENTER_ALIGNMENT);
        header.setForeground(Color.red);
        header.setBackground(Color.MAGENTA);
         f1 = new JButton("Browse");
        vb=new JButton("BVideo");
        f2 = new JButton("PProcessing");
        f3 = new JButton("TextArea");
        f4 = new JButton("MSER");
        f5 = new JButton("Regions");
        f6 = new JButton("DetectText");
       JButton d=new JButton("OCRResult");
        f7 = new JButton("OCR");
        show=new JButton("Result");

        pa.setBounds(100, 300, 1200, 400);
        contentPane.add(pa);
        contentPane.setBackground(Color.PINK);
        //pa.disable();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        pa.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        //head.setBounds(775, 100, 150, 20);
        // header.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
        header.setBounds(300, 55, 900, 140);
        //  secret.setBounds(350,200,100,30);
        f1.setBounds(250, 200, 100, 30);
        vb.setBounds(450, 200, 100, 30);
        f2.setBounds(600, 200, 100, 30);
        f3.setBounds(750, 200, 100, 30);
        f4.setBounds(900, 200, 100, 30);
        f5.setBounds(450, 250, 100, 30);
        f6.setBounds(600, 250, 100, 30);
        
        f7.setBounds(800, 250, 100, 30);
        d. setBounds(700, 250, 100, 30);
        show.setBounds(900, 250, 100, 30);
        
        //f6.setBounds(300, 100, 900, 100);
        //title.setBounds(300, 100, 900, 100);
        //***********************************Adding Images to JTextPane************************
        // pa.insertIcon(new ImageIcon(files.getAbsolutePath()));

        // jt.insertIcon(new ImageIcon(file.getAbsolutePath()));
        f1.setBackground(Color.white);
        vb.setBackground(Color.white);
        f2.setBackground(Color.white);
        f3.setBackground(Color.white);
        f4.setBackground(Color.WHITE);
        f5.setBackground(Color.white);
        f6.setBackground(Color.white);
        f7.setBackground(Color.white);
        d.setBackground(Color.white);
        show.setBackground(Color.white);
        
        //header.setBackground(Color.LIGHT_GRAY);
        header.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        contentPane.add(f1);
        contentPane.add(vb);
        contentPane.add(f2);
        contentPane.add(f3);
        contentPane.add(f4);
        contentPane.add(f5);
        contentPane.add(f6);
        contentPane.add(f7);
        contentPane.add(d);
        
        contentPane.add(show);
        contentPane.add(header);
        //contentPane.add(f5);
        //contentPane.add(title);
        
        //pane.setLayout(new GridLayout(4,4));
        f1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        f1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChooseTargetFile();
                //label1.setText("Selected File :-");
                //label.setText(file.getName());

            }
        });
        
        vb.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        vb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               videoGenerator();

            }
        });
        

        f2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        f2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                preProcess();
               
                n=1;
                pa.setText("");
                int fi;
                File folder = new File(System.getProperty("user.dir")+"\\output");
                System.out.println("Folder is"+folder);
                File[] listOfFiles = folder.listFiles();
                System.out.println("List Of files is"+listOfFiles);
               // String inputImagePath = System.getProperty("user.dir") + "\\decode\\out" + n + ".jpg";
                
                for (fi = 0; fi < listOfFiles.length; fi++) {
                    if (listOfFiles[fi].isFile()) {
                        System.out.println("File " + listOfFiles[fi].getName());
                        //String inputImagePath = System.getProperty("user.dir") + "\\decode\\" +listOfFiles[fi];
                         // String inputImagePath=folder.toString();
                          //System.out.println("inputImagePath"+inputImagePath);
                          String inputImagePath=listOfFiles[fi].toString();
                          System.out.println("inputImagePath2"+inputImagePath);
                          //String inputImagePath3=inputImagePath2;
                          //System.out.println("input image path is"+inputImagePath3);
                        functionSize(inputImagePath);
                    } 
                   
                }
             JOptionPane.showMessageDialog(null, "Pre-Processing Successfully......");
             
            try {
              
                   
//                    File da = new File(System.getProperty("user.dir") + "\\resize\\out1.jpg");
//                    BufferedImage extractImage;
//                    ImageIcon extractIcon;
//                    if (da.isDirectory()) // make sure it's a directory
//                    {
//                       
//                        for (File extf : da.listFiles(IMAGE_FILTER)) {
//                           
//                            extractImage = ImageIO.read(extf);
//                            extractIcon = new ImageIcon(extractImage);
//                            pa.insertIcon(extractIcon);
//                        }
//                    }
                    //*************start image one******************
                     pa.setText("");
                    File da = new File(System.getProperty("user.dir") + "\\resize\\out2.jpg");
                    BufferedImage extractImage;
                    ImageIcon extractIcon;
                    //if (da.isDirectory()) // make sure it's a directory
                    //{
                       
                        //for (File extf : da.listFiles(IMAGE_FILTER)) {
                           
                            extractImage = ImageIO.read(da);
                            extractIcon = new ImageIcon(extractImage);
                            pa.insertIcon(extractIcon);
                       // }
                    //}
                    
                    //*************end image one******************
                     //*************start image two******************
                    File da2 = new File(System.getProperty("user.dir") + "\\resize\\out3.jpg");
                    BufferedImage extractImage2;
                    ImageIcon extractIcon2;
                    
                            extractImage2 = ImageIO.read(da2);
                            extractIcon2 = new ImageIcon(extractImage2);
                            pa.insertIcon(extractIcon2);
                     
                    
                    //*************end image two******************
                    
                    
                    
                    
                    
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }  
           
            }
            public void functionSize(String inputimagepath) {
                try {

                    File file = new File(inputimagepath);

                    
                    String inputImagePath = file.getAbsolutePath();
                    String outputImagePath1 = System.getProperty("user.dir") + "\\resize\\out" + n + ".jpg";
                    int scaledWidth = 400;
                    int scaledHeight = 300;
                    resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);
                    
                     pa.setText("");
                    File da = new File(System.getProperty("user.dir") + "\\resize");
                    BufferedImage extractImage;
                    ImageIcon extractIcon;
                    if (da.isDirectory()) // make sure it's a directory
                    {
                        System.out.print("in if of extract");
                        for (File extf : da.listFiles(IMAGE_FILTER)) {
                            System.out.print("in for loop of extract");
                            extractImage = ImageIO.read(extf);
                            extractIcon = new ImageIcon(extractImage);
                            
                            //pa.insertIcon(extractIcon);
                        }
                    }
                     n++;
                    
                } catch (IOException ex) {
                    Logger.getLogger(SampleSwing.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        

            private void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight) throws IOException {

                // reads input image
                File inputFile = new File(inputImagePath);
                BufferedImage inputImage = ImageIO.read(inputFile);

                // creates output image
                BufferedImage outputImage = new BufferedImage(scaledWidth,
                        scaledHeight, inputImage.getType());

                // scales the input image to the output image
                Graphics2D g2d = outputImage.createGraphics();
                g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
                g2d.dispose();

                // extracts extension of output file
                String formatName = outputImagePath.substring(outputImagePath
                        .lastIndexOf(".") + 1);

                // writes to output file
                ImageIO.write(outputImage, formatName, new File(outputImagePath));

            }
                //JOptionPane.showMessageDialog(null," OCR Generation successfully...");
            
        });

           
        f3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        f3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    textArea();
                    n=1;
                pa.setText("");
                int fi;
                File folder = new File(System.getProperty("user.dir")+"\\output");
                System.out.println("Folder is"+folder);
                File[] listOfFiles = folder.listFiles();
                System.out.println("List Of files is"+listOfFiles);
               // String inputImagePath = System.getProperty("user.dir") + "\\decode\\out" + n + ".jpg";
                
                for (fi = 0; fi < listOfFiles.length; fi++) {
                    if (listOfFiles[fi].isFile()) {
                        System.out.println("File " + listOfFiles[fi].getName());
                        //String inputImagePath = System.getProperty("user.dir") + "\\decode\\" +listOfFiles[fi];
                         // String inputImagePath=folder.toString();
                          //System.out.println("inputImagePath"+inputImagePath);
                          String inputImagePath=listOfFiles[fi].toString();
                          System.out.println("inputImagePath2"+inputImagePath);
                          //String inputImagePath3=inputImagePath2;
                          //System.out.println("input image path is"+inputImagePath3);
                        functionSize(inputImagePath);
                    } 
                   
                }
                    JOptionPane.showMessageDialog(null, "Text area Processing Successfully......");
                    
                    try {
                    //*************start image one******************
                     pa.setText("");
                    File da4 = new File(System.getProperty("user.dir") + "\\resize\\out4.jpg");
                    BufferedImage extractImage4;
                    ImageIcon extractIcon4;
                   
                            extractImage4 = ImageIO.read(da4);
                            extractIcon4 = new ImageIcon(extractImage4);
                            pa.insertIcon(extractIcon4);
                     
                    //*************end image one******************
                     //*************start image two******************
                    File da5 = new File(System.getProperty("user.dir") + "\\resize\\out5.jpg");
                    BufferedImage extractImage5;
                    ImageIcon extractIcon5;
                    
                            extractImage5 = ImageIO.read(da5);
                            extractIcon5 = new ImageIcon(extractImage5);
                            pa.insertIcon(extractIcon5);
                     
                    
                    //*************end image two******************
                    
                    } catch (Exception ex) {
                    ex.printStackTrace();
                }
                    
                    
                    
            }
            public void functionSize(String inputimagepath) {
                try {

                    File file = new File(inputimagepath);

                    
                    String inputImagePath = file.getAbsolutePath();
                    String outputImagePath1 = System.getProperty("user.dir") + "\\resize\\out" + n + ".jpg";
                    int scaledWidth = 400;
                    int scaledHeight = 300;
                    resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);
                    
                     pa.setText("");
                    File da = new File(System.getProperty("user.dir") + "\\resize");
                    BufferedImage extractImage;
                    ImageIcon extractIcon;
                    if (da.isDirectory()) // make sure it's a directory
                    {
                        System.out.print("in if of extract");
                        for (File extf : da.listFiles(IMAGE_FILTER)) {
                            System.out.print("in for loop of extract");
                            extractImage = ImageIO.read(extf);
                            extractIcon = new ImageIcon(extractImage);
                            
                            //pa.insertIcon(extractIcon);
                        }
                    }
                     n++;
                    
                } catch (IOException ex) {
                    Logger.getLogger(SampleSwing.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        
            
            private void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight) throws IOException {

                // reads input image
                File inputFile = new File(inputImagePath);
                BufferedImage inputImage = ImageIO.read(inputFile);

                // creates output image
                BufferedImage outputImage = new BufferedImage(scaledWidth,
                        scaledHeight, inputImage.getType());

                // scales the input image to the output image
                Graphics2D g2d = outputImage.createGraphics();
                g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
                g2d.dispose();

                // extracts extension of output file
                String formatName = outputImagePath.substring(outputImagePath
                        .lastIndexOf(".") + 1);

                // writes to output file
                ImageIO.write(outputImage, formatName, new File(outputImagePath));

            }
        });
        f4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        f4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               mSER();
               n=1;
                pa.setText("");
                int fi;
                File folder = new File(System.getProperty("user.dir")+"\\output");
                System.out.println("Folder is"+folder);
                File[] listOfFiles = folder.listFiles();
                System.out.println("List Of files is"+listOfFiles);
               // String inputImagePath = System.getProperty("user.dir") + "\\decode\\out" + n + ".jpg";
                
                for (fi = 0; fi < listOfFiles.length; fi++) {
                    if (listOfFiles[fi].isFile()) {
                        System.out.println("File " + listOfFiles[fi].getName());
                        //String inputImagePath = System.getProperty("user.dir") + "\\decode\\" +listOfFiles[fi];
                         // String inputImagePath=folder.toString();
                          //System.out.println("inputImagePath"+inputImagePath);
                          String inputImagePath=listOfFiles[fi].toString();
                          System.out.println("inputImagePath2"+inputImagePath);
                          //String inputImagePath3=inputImagePath2;
                          //System.out.println("input image path is"+inputImagePath3);
                        functionSize(inputImagePath);
                    } 
                   
                }
                JOptionPane.showMessageDialog(null, "MSER Successfully......");
                
                try {
                    //*************start image one******************
                     pa.setText("");
                    File da6 = new File(System.getProperty("user.dir") + "\\resize\\out6.jpg");
                    BufferedImage extractImage6;
                    ImageIcon extractIcon6;
                   
                            extractImage6 = ImageIO.read(da6);
                            extractIcon6 = new ImageIcon(extractImage6);
                            pa.insertIcon(extractIcon6);
                     
                    //*************end image one******************
//                     //*************start image two******************
//                    File da7 = new File(System.getProperty("user.dir") + "\\resize\\out7.jpg");
//                    BufferedImage extractImage7;
//                    ImageIcon extractIcon7;
//                    
//                            extractImage7 = ImageIO.read(da7);
//                            extractIcon7 = new ImageIcon(extractImage7);
//                            pa.insertIcon(extractIcon7);
//                     
//                    
//                    //*************end image two******************
                    
                    
                    
                    
                    
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                    

            }
            public void functionSize(String inputimagepath) {
                try {

                    File file = new File(inputimagepath);

                    
                    String inputImagePath = file.getAbsolutePath();
                    String outputImagePath1 = System.getProperty("user.dir") + "\\resize\\out" + n + ".jpg";
                    int scaledWidth = 400;
                    int scaledHeight = 300;
                    resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);
                    
                     pa.setText("");
                    File da = new File(System.getProperty("user.dir") + "\\resize");
                    BufferedImage extractImage;
                    ImageIcon extractIcon;
                    if (da.isDirectory()) // make sure it's a directory
                    {
                        System.out.print("in if of extract");
                        for (File extf : da.listFiles(IMAGE_FILTER)) {
                            System.out.print("in for loop of extract");
                            extractImage = ImageIO.read(extf);
                            extractIcon = new ImageIcon(extractImage);
                            
                            //pa.insertIcon(extractIcon);
                        }
                    }
                     n++;
                    
                } catch (IOException ex) {
                    Logger.getLogger(SampleSwing.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        
            
            private void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight) throws IOException {

                // reads input image
                File inputFile = new File(inputImagePath);
                BufferedImage inputImage = ImageIO.read(inputFile);

                // creates output image
                BufferedImage outputImage = new BufferedImage(scaledWidth,
                        scaledHeight, inputImage.getType());

                // scales the input image to the output image
                Graphics2D g2d = outputImage.createGraphics();
                g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
                g2d.dispose();

                // extracts extension of output file
                String formatName = outputImagePath.substring(outputImagePath
                        .lastIndexOf(".") + 1);

                // writes to output file
                ImageIO.write(outputImage, formatName, new File(outputImagePath));

            }
        });

        f5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        f5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchRegion();
                
                n=1;
                pa.setText("");
                int fi;
                File folder = new File(System.getProperty("user.dir")+"\\output");
                System.out.println("Folder is"+folder);
                File[] listOfFiles = folder.listFiles();
                System.out.println("List Of files is"+listOfFiles);
               // String inputImagePath = System.getProperty("user.dir") + "\\decode\\out" + n + ".jpg";
                
                for (fi = 0; fi < listOfFiles.length; fi++) {
                    if (listOfFiles[fi].isFile()) {
                        System.out.println("File " + listOfFiles[fi].getName());
                        //String inputImagePath = System.getProperty("user.dir") + "\\decode\\" +listOfFiles[fi];
                         // String inputImagePath=folder.toString();
                          //System.out.println("inputImagePath"+inputImagePath);
                          String inputImagePath=listOfFiles[fi].toString();
                          System.out.println("inputImagePath2"+inputImagePath);
                          //String inputImagePath3=inputImagePath2;
                          //System.out.println("input image path is"+inputImagePath3);
                        functionSize(inputImagePath);
                    } 
                   
                }
                JOptionPane.showMessageDialog(null, "Regions Processing Successfully......");

                try {
                    //*************start image one******************
                     pa.setText("");
                    File da8 = new File(System.getProperty("user.dir") + "\\resize\\out7.jpg");
                    BufferedImage extractImage8;
                    ImageIcon extractIcon8;
                   
                            extractImage8 = ImageIO.read(da8);
                            extractIcon8 = new ImageIcon(extractImage8);
                            pa.insertIcon(extractIcon8);
                     
                    //*************end image one******************
//                     //*************start image two******************
//                    File da9 = new File(System.getProperty("user.dir") + "\\resize\\out9.jpg");
//                    BufferedImage extractImage9;
//                    ImageIcon extractIcon9;
//                    
//                            extractImage9 = ImageIO.read(da9);
//                            extractIcon9 = new ImageIcon(extractImage9);
//                            pa.insertIcon(extractIcon9);
//                     
//                    
//                    //*************end image two******************
//                    
                    
                    
                    
                    
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                    
                
            }
            public void functionSize(String inputimagepath) {
                try {

                    File file = new File(inputimagepath);

                    
                    String inputImagePath = file.getAbsolutePath();
                    String outputImagePath1 = System.getProperty("user.dir") + "\\resize\\out" + n + ".jpg";
                    int scaledWidth = 400;
                    int scaledHeight = 300;
                    resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);
                    
                     pa.setText("");
                    File da = new File(System.getProperty("user.dir") + "\\resize");
                    BufferedImage extractImage;
                    ImageIcon extractIcon;
                    if (da.isDirectory()) // make sure it's a directory
                    {
                        System.out.print("in if of extract");
                        for (File extf : da.listFiles(IMAGE_FILTER)) {
                            System.out.print("in for loop of extract");
                            extractImage = ImageIO.read(extf);
                            extractIcon = new ImageIcon(extractImage);
                            
                            //pa.insertIcon(extractIcon);
                        }
                    }
                     n++;
                    
                } catch (IOException ex) {
                    Logger.getLogger(SampleSwing.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        
            
            private void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight) throws IOException {

                // reads input image
                File inputFile = new File(inputImagePath);
                BufferedImage inputImage = ImageIO.read(inputFile);

                // creates output image
                BufferedImage outputImage = new BufferedImage(scaledWidth,
                        scaledHeight, inputImage.getType());

                // scales the input image to the output image
                Graphics2D g2d = outputImage.createGraphics();
                g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
                g2d.dispose();

                // extracts extension of output file
                String formatName = outputImagePath.substring(outputImagePath
                        .lastIndexOf(".") + 1);

                // writes to output file
                ImageIO.write(outputImage, formatName, new File(outputImagePath));

            }
        });

        f6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        f6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 createOCRFile();
                DetectText();
               
                n=1;
                pa.setText("");
                int fi;
                File folder = new File(System.getProperty("user.dir")+"\\output");
                System.out.println("Folder is"+folder);
                File[] listOfFiles = folder.listFiles();
                System.out.println("List Of files is"+listOfFiles);
               // String inputImagePath = System.getProperty("user.dir") + "\\decode\\out" + n + ".jpg";
                
                for (fi = 0; fi < listOfFiles.length; fi++) {
                    if (listOfFiles[fi].isFile()) {
                        System.out.println("File " + listOfFiles[fi].getName());
                        //String inputImagePath = System.getProperty("user.dir") + "\\decode\\" +listOfFiles[fi];
                         // String inputImagePath=folder.toString();
                          //System.out.println("inputImagePath"+inputImagePath);
                          String inputImagePath=listOfFiles[fi].toString();
                          System.out.println("inputImagePath2"+inputImagePath);
                          //String inputImagePath3=inputImagePath2;
                          //System.out.println("input image path is"+inputImagePath3);
                        functionSize(inputImagePath);
                    } 
                   
                }
                JOptionPane.showMessageDialog(null, "Detect Text Processing Successfully......");

                   try {
                    //*************start image one******************
                     pa.setText("");
                    File da10= new File(System.getProperty("user.dir") + "\\resize\\out8.jpg");
                    BufferedImage extractImage10;
                    ImageIcon extractIcon10;
                   
                            extractImage10 = ImageIO.read(da10);
                            extractIcon10 = new ImageIcon(extractImage10);
                            pa.insertIcon(extractIcon10);
                     
                    //*************end image one******************
                     //*************start image two******************
                    File da11 = new File(System.getProperty("user.dir") + "\\resize\\out9.jpg");
                    BufferedImage extractImage11;
                    ImageIcon extractIcon11;
                    
                            extractImage11 = ImageIO.read(da11);
                            extractIcon11 = new ImageIcon(extractImage11);
                            pa.insertIcon(extractIcon11);
                     
                    
                    //*************end image two******************
                    //*************start image two******************
                    File da12 = new File(System.getProperty("user.dir") + "\\resize\\out10.jpg");
                    BufferedImage extractImage12;
                    ImageIcon extractIcon12;
                    
                            extractImage12 = ImageIO.read(da12);
                            extractIcon12 = new ImageIcon(extractImage12);
                            pa.insertIcon(extractIcon12);
                     
                    
                    //*************end image two******************
                    
              
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                    
            }
            public void functionSize(String inputimagepath) {
                try {

                    File file = new File(inputimagepath);

                    
                    String inputImagePath = file.getAbsolutePath();
                    String outputImagePath1 = System.getProperty("user.dir") + "\\resize\\out" + n + ".jpg";
                    int scaledWidth = 400;
                    int scaledHeight = 300;
                    resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);
                    
                     pa.setText("");
                    File da = new File(System.getProperty("user.dir") + "\\resize");
                    BufferedImage extractImage;
                    ImageIcon extractIcon;
                    if (da.isDirectory()) // make sure it's a directory
                    {
                        System.out.print("in if of extract");
                        for (File extf : da.listFiles(IMAGE_FILTER)) {
                            System.out.print("in for loop of extract");
                            extractImage = ImageIO.read(extf);
                            extractIcon = new ImageIcon(extractImage);
                            
                            //pa.insertIcon(extractIcon);
                        }
                    }
                     n++;
                    
                } catch (IOException ex) {
                    Logger.getLogger(SampleSwing.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        
            
            private void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight) throws IOException {

                // reads input image
                File inputFile = new File(inputImagePath);
                BufferedImage inputImage = ImageIO.read(inputFile);

                // creates output image
                BufferedImage outputImage = new BufferedImage(scaledWidth,
                        scaledHeight, inputImage.getType());

                // scales the input image to the output image
                Graphics2D g2d = outputImage.createGraphics();
                g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
                g2d.dispose();

                // extracts extension of output file
                String formatName = outputImagePath.substring(outputImagePath
                        .lastIndexOf(".") + 1);

                // writes to output file
                ImageIO.write(outputImage, formatName, new File(outputImagePath));

            }
        });
        
        
        
        d.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                    File da12 = new File(System.getProperty("user.dir") + "\\output\\10_ocr.jpg");
                    BufferedImage extractImage12 = null;
                    ImageIcon extractIcon12;
                    
                try {
                    extractImage12 = ImageIO.read(da12);
                } catch (IOException ex) {
                    Logger.getLogger(SampleSwing.class.getName()).log(Level.SEVERE, null, ex);
                }
                            extractIcon12 = new ImageIcon(extractImage12);
                            pa.insertIcon(extractIcon12);
                
//                            F:\AnilProject\Rahul Sahal\TextOcrDetection\
                     File da13 = new File(System.getProperty("user.dir") + "\\output\\11_ocr.jpg");
                    BufferedImage extractImage13 = null;
                    ImageIcon extractIcon13;
                    
                try {
                    extractImage12 = ImageIO.read(da12);
                } catch (IOException ex) {
                    Logger.getLogger(SampleSwing.class.getName()).log(Level.SEVERE, null, ex);
                }
                            extractIcon12 = new ImageIcon(extractImage12);
                            pa.insertIcon(extractIcon12);
                
                
                
            }
        });
        
        
        
        f7.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        f7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
               
               createOCRFile();
               pa.setText("");
               pa.setText("Detected OCR Text Display Here");
               
               String textvalue = System.getProperty("user.dir");
                    String otherFolder = textvalue + "\\ocr.txt";
                    
                   // C:\Destop\Rahul Sahal\TextOcrDetection
                    textvalue = otherFolder;

                    try {
                        FileReader r = new FileReader(textvalue);
                        pa.read(r, "");
                        System.out.println("value of ocr file is"+r);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
            }
           
    });

         show.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
         show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                
                showResult();
                
                
            }
           
//                try {
//              
//                    pa.setText("");
//                    File da = new File(System.getProperty("user.dir") + "\\resize");
//                    BufferedImage extractImage;
//                    ImageIcon extractIcon;
//                    if (da.isDirectory()) // make sure it's a directory
//                    {
//                       
//                        for (File extf : da.listFiles(IMAGE_FILTER)) {
//                           
//                            extractImage = ImageIO.read(extf);
//                            extractIcon = new ImageIcon(extractImage);
//                            pa.insertIcon(extractIcon);
//                        }
//                    }
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
        });
    }

}

