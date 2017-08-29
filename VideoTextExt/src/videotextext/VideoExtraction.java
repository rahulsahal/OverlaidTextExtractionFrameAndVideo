package videotextext;
//import static LoadingAllImages.dir;
import java.awt.BorderLayout;
import java.awt.Color;
import videotextext.MainHomeGUI;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

class VideoExtraction extends JFrame {

    JTextField tf;
    JTextPane tp;
    JButton click, show, clear;
    StyledDocument doc;
    SimpleAttributeSet attr;
    static final File dir = new File(System.getProperty("user.dir")+"\\VideoTextExt\\output");
    static final String[] EXTENSIONS = new String[]{
        "gif", "png", "jpg" // and other formats you need
    };
    // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    
    static final File dir2= new File(System.getProperty("user.dir")+"\\VideoTextExt\\OcrRes");
    static final String[] EXTENSIONS2 = new String[]{
        "gif", "png", "jpg" // and other formats you need
    };
    // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER2 = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS2) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    public void createAndShowGUI() {
        setTitle("Video Text Extraction");
        setBounds(0,0, 1500, 1000);
        //tf = new JTextField(10);
        tp = new JTextPane();
        click = new JButton("Result");
        show = new JButton("OCR");
        clear = new JButton("Clear");
        //show.setBounds(200, 200, 100, 100);
        doc = tp.getStyledDocument();
        attr = new SimpleAttributeSet();
        JScrollPane pane = new JScrollPane(tp);
        JPanel nPanel = new JPanel();
        // nPanel.add(tf);
        nPanel.add(click);
        nPanel.add(show);
        nPanel.add(clear);

        Container c = getContentPane();
        c.add(nPanel, BorderLayout.NORTH);
        c.add(pane);
        tp.setBackground(Color.cyan);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        click.setBackground(Color.PINK);
        show.setBackground(Color.PINK);
        clear.setBackground(Color.PINK);
        
        click.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        click.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                tp.setText("");
                if (dir.isDirectory()) { // make sure it's a directory
                    for (final File f : dir.listFiles(IMAGE_FILTER)) {
                        BufferedImage img = null;

                        try {
                            img = ImageIO.read(f);
                            //System.out.println("img value is"+img);
                            
                            String in=f.getName();
                            // you probably want something more involved here
                            // to display in your UI
                            System.out.println("image: " + f.getName());
                            System.out.println(" width : " + img.getWidth());
                            System.out.println(" height: " + img.getHeight());
                            System.out.println(" size  : " + f.length());
                            
                            //tp.setText("");
                            JLabel label = new JLabel(new ImageIcon(System.getProperty("user.dir")+"\\output\\"+in));
                            label.setOpaque(true);
                            label.setBackground(Color.gray);
                            label.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                            tp.setCaretPosition(tp.getDocument().getLength());
                            tp.insertComponent(label);
                        } catch (final IOException ex) {
                            // handle errors here
                        }
                    }
                }

            }

        });
        show.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                
                
                tp.setText("");
                if (dir2.isDirectory()) { // make sure it's a directory
                    for (final File f2 : dir2.listFiles(IMAGE_FILTER2)) {
                        BufferedImage img2 = null;

                        try {
                            img2 = ImageIO.read(f2);
                            //System.out.println("img value is"+img);
                            
                            String in2=f2.getName();
                            // you probably want something more involved here
                            // to display in your UI
                            System.out.println("image: " + f2.getName());
                            System.out.println(" width : " + img2.getWidth());
                            System.out.println(" height: " + img2.getHeight());
                            System.out.println(" size  : " + f2.length());
                            
                           // tp.setText("");
                            JLabel label = new JLabel(new ImageIcon(System.getProperty("user.dir")+"\\OcrRes\\"+in2));
                            label.setOpaque(true);
                            label.setBackground(Color.gray);
                            label.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                            tp.setCaretPosition(tp.getDocument().getLength());
                            tp.insertComponent(label);
                        } catch (final IOException ex) {
                            // handle errors here
                        }
                    }
                }

            }

        });
        clear.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                tp.setText("");

            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VideoExtraction lta = new VideoExtraction();
                lta.createAndShowGUI();
            }
        });
    }
   public void main1() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VideoExtraction lta = new VideoExtraction();
                lta.createAndShowGUI();
            }
        });
    }
}
