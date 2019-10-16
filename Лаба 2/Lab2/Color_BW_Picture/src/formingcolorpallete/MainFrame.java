package formingcolorpallete;

import java.awt.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class MainFrame extends javax.swing.JFrame {

    Robot robot;
    Color col;
    double step;
    double code;
    Image[] files;
    Image openedImage;
    boolean isRead = false;
    int drawnImage1;
    int drawnImage2;

    public MainFrame() throws IOException, InterruptedException {
        super("Color pallete");
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        step = (double) 16384 / ColorPallete.getWidth();
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class PaintPanel extends JPanel {

        @Override
        public void paint(Graphics g) {
            int partPallete = ColorPallete.getWidth() / 5;
            int height = this.getHeight();
            int count = 0;
            for (int i = 0; i < ColorPallete.getWidth(); ++i) {
                if (i <= partPallete) {
                    g.setColor(new Color(0, 0, count++));
                    if (count == 256) {
                        count = 1;
                    }
                }
                if (i > partPallete & i <= 2 * partPallete) {
                    g.setColor(new Color(0, count++, 255));
                    if (count == 256) {
                        count = 254;
                    }
                }
                if (i > 2 * partPallete & i <= 3 * partPallete) {
                    g.setColor(new Color(0, 255, count--));
                    if (count == -1) {
                        count = 1;
                    }
                }
                if (i > 3 * partPallete & i <= 4 * partPallete) {
                    g.setColor(new Color(count++, 255, 0));
                    if (count == 256) {
                        count = 254;
                    }
                }
                if (i > 4 * partPallete & i <= 5 * partPallete) {
                    g.setColor(new Color(255, count--, 0));
                }
                g.drawLine(i, 0, i, height);
            }
        }
    }

    class ColorPanel1 extends JPanel {

        @Override
        public void paint(Graphics g) {
            if (!isRead & drawnImage1 != -1) {
                return;
            }
            g.setColor(new Color(240, 240, 240));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            short[][] im;
            if (drawnImage1 > -1) {
                im = files[drawnImage1].image;
            } else {
                im = openedImage.image;
            }
            for (int h = 0; h < im.length; h++) {
                for (int w = 0; w < im[h].length; w++) {
                    g.setColor(getColor(im[h][w]));
                    g.drawOval(w, h, 1, 1);
                }
            }
        }
    }

    class ColorPanel2 extends JPanel {

        @Override
        public void paint(Graphics g) {
            if (!isRead) {
                return;
            }
            g.setColor(new Color(240, 240, 240));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            short[][] im = files[drawnImage2].image;
            for (int h = 0; h < im.length; h++) {
                for (int w = 0; w < im[h].length; w++) {
                    g.setColor(getColor(im[h][w]));
                    g.drawOval(w, h, 1, 1);
                }
            }
        }
    }

    class BWPanel1 extends JPanel {

        @Override
        public void paint(Graphics g) {
            if (!isRead & drawnImage1 != -1) {
                return;
            }
            g.setColor(new Color(240, 240, 240));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            short[][] im;
            if (drawnImage1 > -1) {
                im = files[drawnImage1].image;
            } else {
                im = openedImage.image;
            }
            for (int h = 0; h < im.length; h++) {
                for (int w = 0; w < im[h].length; w++) {
                    g.setColor(getGrayColor(getColor(im[h][w])));
                    g.drawOval(w, h, 1, 1);
                }
            }
        }
    }

    class BWPanel2 extends JPanel {

        @Override
        public void paint(Graphics g) {
            if (!isRead) {
                return;
            }
            g.setColor(new Color(240, 240, 240));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            short[][] im = files[drawnImage2].image;
            for (int h = 0; h < im.length; h++) {
                for (int w = 0; w < im[h].length; w++) {
                    g.setColor(getGrayColor(getColor(im[h][w])));
                    g.drawOval(w, h, 1, 1);
                }
            }
        }
    }

    private boolean isDigit(String s) {
        int num = Integer.parseInt(s);
        return !(num > 50 | num < 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ColorPallete = new PaintPanel();
        jPanel1 = new javax.swing.JPanel();
        RedText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        GreenText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BlueText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        RGBrepres = new javax.swing.JTextField();
        SelectedColorPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SearchButton = new javax.swing.JButton();
        SearchText = new javax.swing.JTextField();
        FindedColorPanel = new javax.swing.JPanel();
        Scroll = new javax.swing.JPanel();
        BWImage1 = new BWPanel1();
        ColorImage1 = new ColorPanel1();
        BWImage2 = new BWPanel2();
        ColorImage2 = new ColorPanel2();
        pic1text = new javax.swing.JTextField();
        pic2text = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        DownloadDefaultFiles = new javax.swing.JMenuItem();
        OpenFile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        ColorPallete.setEnabled(false);
        ColorPallete.setPreferredSize(new java.awt.Dimension(1280, 105));
        ColorPallete.setRequestFocusEnabled(false);
        ColorPallete.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ColorPalleteMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout ColorPalleteLayout = new javax.swing.GroupLayout(ColorPallete);
        ColorPallete.setLayout(ColorPalleteLayout);
        ColorPalleteLayout.setHorizontalGroup(
            ColorPalleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1276, Short.MAX_VALUE)
        );
        ColorPalleteLayout.setVerticalGroup(
            ColorPalleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        RedText.setEditable(false);

        jLabel2.setText("RED:");

        GreenText.setEditable(false);

        jLabel3.setText("GREEN:");

        BlueText.setEditable(false);

        jLabel4.setText("BLUE:");

        jLabel5.setText("14 - bit representation:");

        RGBrepres.setEditable(false);

        SelectedColorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 123, 123)));

        javax.swing.GroupLayout SelectedColorPanelLayout = new javax.swing.GroupLayout(SelectedColorPanel);
        SelectedColorPanel.setLayout(SelectedColorPanelLayout);
        SelectedColorPanelLayout.setHorizontalGroup(
            SelectedColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        SelectedColorPanelLayout.setVerticalGroup(
            SelectedColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jLabel6.setText("Selected color:");

        jLabel7.setText("Find color:");

        SearchButton.setText("Search");
        SearchButton.setFocusable(false);
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        SearchText.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                SearchTextCaretUpdate(evt);
            }
        });

        FindedColorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(123, 123, 123)));

        javax.swing.GroupLayout FindedColorPanelLayout = new javax.swing.GroupLayout(FindedColorPanel);
        FindedColorPanel.setLayout(FindedColorPanelLayout);
        FindedColorPanelLayout.setHorizontalGroup(
            FindedColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        FindedColorPanelLayout.setVerticalGroup(
            FindedColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(GreenText, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                .addComponent(BlueText))
                            .addComponent(RedText, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(SelectedColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FindedColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RGBrepres, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 9, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(FindedColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(GreenText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(SelectedColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BlueText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(RGBrepres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SearchButton)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        Scroll.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Scroll.setPreferredSize(new java.awt.Dimension(870, 590));

        BWImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BWImage1.setPreferredSize(new java.awt.Dimension(384, 288));

        javax.swing.GroupLayout BWImage1Layout = new javax.swing.GroupLayout(BWImage1);
        BWImage1.setLayout(BWImage1Layout);
        BWImage1Layout.setHorizontalGroup(
            BWImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );
        BWImage1Layout.setVerticalGroup(
            BWImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        ColorImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ColorImage1.setPreferredSize(new java.awt.Dimension(384, 288));

        javax.swing.GroupLayout ColorImage1Layout = new javax.swing.GroupLayout(ColorImage1);
        ColorImage1.setLayout(ColorImage1Layout);
        ColorImage1Layout.setHorizontalGroup(
            ColorImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );
        ColorImage1Layout.setVerticalGroup(
            ColorImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        BWImage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BWImage2.setPreferredSize(new java.awt.Dimension(384, 288));

        javax.swing.GroupLayout BWImage2Layout = new javax.swing.GroupLayout(BWImage2);
        BWImage2.setLayout(BWImage2Layout);
        BWImage2Layout.setHorizontalGroup(
            BWImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );
        BWImage2Layout.setVerticalGroup(
            BWImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        ColorImage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ColorImage2.setPreferredSize(new java.awt.Dimension(384, 288));

        javax.swing.GroupLayout ColorImage2Layout = new javax.swing.GroupLayout(ColorImage2);
        ColorImage2.setLayout(ColorImage2Layout);
        ColorImage2Layout.setHorizontalGroup(
            ColorImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );
        ColorImage2Layout.setVerticalGroup(
            ColorImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        pic1text.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pic1text.setPreferredSize(new java.awt.Dimension(80, 21));
        pic1text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pic1textKeyReleased(evt);
            }
        });

        pic2text.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pic2text.setPreferredSize(new java.awt.Dimension(80, 21));
        pic2text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pic2textKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout ScrollLayout = new javax.swing.GroupLayout(Scroll);
        Scroll.setLayout(ScrollLayout);
        ScrollLayout.setHorizontalGroup(
            ScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScrollLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(ScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ColorImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ColorImage2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(ScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pic2text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pic1text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(ScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BWImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BWImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );
        ScrollLayout.setVerticalGroup(
            ScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScrollLayout.createSequentialGroup()
                .addGroup(ScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ColorImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BWImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ScrollLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(pic1text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ColorImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BWImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ScrollLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(pic2text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        MenuFile.setText("Файл");

        DownloadDefaultFiles.setText("Загрузить файлы по умолчанию");
        DownloadDefaultFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownloadDefaultFilesActionPerformed(evt);
            }
        });
        MenuFile.add(DownloadDefaultFiles);

        OpenFile.setText("Открыть файл");
        OpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileActionPerformed(evt);
            }
        });
        MenuFile.add(OpenFile);

        jMenuBar1.add(MenuFile);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ColorPallete, javax.swing.GroupLayout.PREFERRED_SIZE, 1276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ColorPallete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ColorPallete.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private Color getColor(int posX) {
        if (posX >= 0 & posX <= 255) {
            return new Color(0, 0, posX);
        }
        if (posX > 255 & posX <= 510) {
            return new Color(0, posX - 255, 255);
        }
        if (posX > 510 & posX <= 765) {
            return new Color(0, 255, 255 - (posX - 510));
        }
        if (posX > 765 & posX <= 1020) {
            return new Color(posX - 765, 255, 0);
        }
        if (posX > 1020 & posX <= 1275) {
            return new Color(255, 255 - (posX - 1020), 0);
        }
        return null;
    }

    private Color getGrayColor(Color c) {
        int pixel = c.getRGB();
        int R = (pixel & 0x00FF0000) >> 16;
        int G = (pixel & 0x0000FF00) >> 8;
        int B = pixel & 0x000000FF;
        R = G = B = (R + G + B) / 3;
        return new Color(R, G, B);
    }

    private short getNum(byte[] buf) {
        short tmp, res;
        res = (short) Math.abs(buf[0]);
        tmp = (short) (Math.abs(buf[1]) << 8);
        res += tmp;
        res = (short) (res & 0x3FFF);
        return res;
    }

    private void set14BinaryCodeOfRGB(int posX, int width) {
        code = (width - (width - (posX))) * step;
        if (posX == ColorPallete.getWidth() - 1) {
            code = 16383;
        }
        String s = Integer.toBinaryString((int) code);
        while (s.length() < 14) {
            s = "0" + s;
        }
        RGBrepres.setText(s);
    }

    private void ColorPalleteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColorPalleteMouseMoved
        col = robot.getPixelColor(evt.getXOnScreen(), evt.getYOnScreen());
        RedText.setText(String.valueOf(col.getRed()));
        GreenText.setText(String.valueOf(col.getGreen()));
        BlueText.setText(String.valueOf(col.getBlue()));
        set14BinaryCodeOfRGB(evt.getX(), ColorPallete.getWidth());
        SelectedColorPanel.setBackground(col);
    }//GEN-LAST:event_ColorPalleteMouseMoved

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        if (SearchText.getText().trim().length() != 14 | !isBinary(SearchText.getText())) {
            JOptionPane.showMessageDialog(rootPane, "The code must have a 14-bit representation.", "Error", 0);
            return;
        }
        int posX = (int) (Integer.parseInt(SearchText.getText().trim(), 2) / step);
        if (posX == ColorPallete.getWidth()) {
            posX = ColorPallete.getWidth() - 1;
        }
        col = robot.getPixelColor(super.getX() + posX + 3, super.getY() + super.getHeight() - ColorPallete.getHeight() / 2);
        robot.mouseMove(super.getX() + posX + 3, super.getY() + super.getHeight() - ColorPallete.getHeight() / 2);
        FindedColorPanel.setBackground(col);
    }//GEN-LAST:event_SearchButtonActionPerformed

    private boolean isBinary(String s) {
        return Pattern.compile("[01]").matcher(s).find();
    }

    private void SearchTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_SearchTextCaretUpdate
        if (SearchText.getText().length() != 14 & SearchText.getBackground() == Color.GREEN) {
            SearchText.setBackground(Color.WHITE);
        } else if (SearchText.getText().length() == 14) {
            SearchText.setBackground(Color.GREEN);
        }
    }//GEN-LAST:event_SearchTextCaretUpdate

    private void pic1textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pic1textKeyReleased
        if (evt.getKeyCode() != 10) {
            return;
        }
        if (!isRead) {
            JOptionPane.showMessageDialog(rootPane, "Download default files!", "Attention", 1);
            return;
        }
        if (!isDigit(pic1text.getText().trim())) {
            return;
        }
        drawnImage1 = Integer.parseInt(pic1text.getText().trim()) - 1;
        ColorImage1.repaint();
        BWImage1.repaint();
    }//GEN-LAST:event_pic1textKeyReleased

    private void readOpenedFile(String path) throws IOException {
        openedImage = new Image(path);
        drawnImage1 = -1;
        ColorImage1.repaint();
        BWImage1.repaint();
    }

    private void DownloadDefaultFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownloadDefaultFilesActionPerformed
        try {
            readFiles();
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DownloadDefaultFilesActionPerformed

    private void OpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileActionPerformed
        JFileChooser fc = new JFileChooser();

        class MyTxtFilter extends javax.swing.filechooser.FileFilter {

            @Override
            public boolean accept(File file) {
                return file.isDirectory() || file.getAbsolutePath().endsWith(".mbv");
            }

            @Override
            public String getDescription() {
                return "*.mbv";
            }
        }

        fc.setFileFilter(new MyTxtFilter());
        if (fc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        try {
            readOpenedFile(fc.getSelectedFile().getAbsolutePath());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OpenFileActionPerformed

    private void pic2textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pic2textKeyReleased
        if (evt.getKeyCode() != 10) {
            return;
        }
        if (!isRead) {
            JOptionPane.showMessageDialog(rootPane, "Download default files!", "Attention", 1);
            return;
        }
        if (!isDigit(pic2text.getText().trim())) {
            return;
        }
        drawnImage2 = Integer.parseInt(pic2text.getText().trim()) - 1;
        ColorImage2.repaint();
        BWImage2.repaint();
    }//GEN-LAST:event_pic2textKeyReleased

    public void readFiles() throws FileNotFoundException, IOException {
        files = new Image[50];
        for (int i = 0; i < 50; i++) {
            files[i] = new Image("pic/pic_" + (i + 1) + ".mbv");
        }
        JOptionPane.showMessageDialog(rootPane, "Default files was downloaded", "Attention", 1);
        DownloadDefaultFiles.setEnabled(false);
        drawnImage1 = 0;
        drawnImage2 = 1;
        pic1text.setText("1");
        pic2text.setText("2");
        isRead = true;
        repaint();
    }

    class Image {

        short[][] image;
        int width, height;

        public Image(String path) throws IOException {
            RandomAccessFile raf = new RandomAccessFile(path, "r");
            byte[] buf = new byte[2];
            raf.read(buf);
            width = getNum(buf);
            raf.read(buf);
            height = getNum(buf);
            byte[] file = new byte[height * width * 2];
            raf.read(file);
            image = new short[height][width];
            int pixCount = 1;
            for (int h = 0; h < image.length; h++) {
                for (int w = 0; w < image[h].length; w++) {
                    image[h][w] = (short) (getNum(new byte[]{file[pixCount - 1], file[pixCount]}) / step);
                    pixCount += 2;
                }
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MainFrame().setVisible(true);
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BWImage1;
    private javax.swing.JPanel BWImage2;
    private javax.swing.JTextField BlueText;
    private javax.swing.JPanel ColorImage1;
    private javax.swing.JPanel ColorImage2;
    private javax.swing.JPanel ColorPallete;
    private javax.swing.JMenuItem DownloadDefaultFiles;
    private javax.swing.JPanel FindedColorPanel;
    private javax.swing.JTextField GreenText;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenuItem OpenFile;
    private javax.swing.JTextField RGBrepres;
    private javax.swing.JTextField RedText;
    private javax.swing.JPanel Scroll;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchText;
    private javax.swing.JPanel SelectedColorPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField pic1text;
    private javax.swing.JTextField pic2text;
    // End of variables declaration//GEN-END:variables
}
