package formingcolorpallete;

import java.awt.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends javax.swing.JFrame {

    Robot robot;
    Color col;
    double step;
    double code;
    int width, height;

    public MainFrame() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ColorPallete = new PaintPanel();
        jLabel1 = new javax.swing.JLabel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Scroll = new javax.swing.JPanel();
        PicGray1 = new javax.swing.JPanel();
        PicRGB1 = new javax.swing.JPanel();
        PicGray2 = new javax.swing.JPanel();
        PicRGB2 = new javax.swing.JPanel();
        ComboBox1 = new javax.swing.JComboBox<>();
        ComboBox2 = new javax.swing.JComboBox<>();

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
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Color Pallete");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Scroll.setPreferredSize(new java.awt.Dimension(795, 582));

        PicGray1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PicGray1.setPreferredSize(new java.awt.Dimension(384, 288));

        javax.swing.GroupLayout PicGray1Layout = new javax.swing.GroupLayout(PicGray1);
        PicGray1.setLayout(PicGray1Layout);
        PicGray1Layout.setHorizontalGroup(
            PicGray1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        PicGray1Layout.setVerticalGroup(
            PicGray1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        PicRGB1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PicRGB1.setPreferredSize(new java.awt.Dimension(384, 288));

        javax.swing.GroupLayout PicRGB1Layout = new javax.swing.GroupLayout(PicRGB1);
        PicRGB1.setLayout(PicRGB1Layout);
        PicRGB1Layout.setHorizontalGroup(
            PicRGB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        PicRGB1Layout.setVerticalGroup(
            PicRGB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PicGray2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PicGray2.setPreferredSize(new java.awt.Dimension(384, 288));

        javax.swing.GroupLayout PicGray2Layout = new javax.swing.GroupLayout(PicGray2);
        PicGray2.setLayout(PicGray2Layout);
        PicGray2Layout.setHorizontalGroup(
            PicGray2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        PicGray2Layout.setVerticalGroup(
            PicGray2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        PicRGB2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PicRGB2.setPreferredSize(new java.awt.Dimension(384, 288));

        javax.swing.GroupLayout PicRGB2Layout = new javax.swing.GroupLayout(PicRGB2);
        PicRGB2.setLayout(PicRGB2Layout);
        PicRGB2Layout.setHorizontalGroup(
            PicRGB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        PicRGB2Layout.setVerticalGroup(
            PicRGB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );

        ComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50" }));
        ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox1ActionPerformed(evt);
            }
        });

        ComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50" }));
        ComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ScrollLayout = new javax.swing.GroupLayout(Scroll);
        Scroll.setLayout(ScrollLayout);
        ScrollLayout.setHorizontalGroup(
            ScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScrollLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ScrollLayout.createSequentialGroup()
                        .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PicRGB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PicGray1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ScrollLayout.createSequentialGroup()
                        .addComponent(ComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PicRGB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PicGray2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        ScrollLayout.setVerticalGroup(
            ScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScrollLayout.createSequentialGroup()
                .addGroup(ScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ScrollLayout.createSequentialGroup()
                        .addGroup(ScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(PicRGB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PicGray1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(ScrollLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)))
                .addGroup(ScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PicRGB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PicGray2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ScrollLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(ComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(Scroll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(548, 548, 548))
            .addGroup(layout.createSequentialGroup()
                .addComponent(ColorPallete, javax.swing.GroupLayout.PREFERRED_SIZE, 1276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ColorPallete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ColorPallete.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    byte[] buf = new byte[2];

    private void readFile(RandomAccessFile raf, int number) throws IOException {
        raf.read(buf);
        width = getNum(buf);
        raf.read(buf);
        height = getNum(buf);
        Graphics g = null;
        if (number == 1) {
            g = PicRGB1.getGraphics();
        }
        int posX;
        while (raf.read(buf) != -1) {
            posX = (int) (getNum(buf) / step);
            if (posX == ColorPallete.getWidth()) {
                posX = ColorPallete.getWidth() - 1;
            }
            col = robot.getPixelColor(super.getX() + posX + 3, super.getY() + super.getHeight() - ColorPallete.getHeight() / 2);
            g.setColor(col);
            drawColorPixel(g);
        }
    }

    int x = 0;
    int y = 0;

    private void drawColorPixel(Graphics g) {
        if (x > PicRGB1.getWidth()) {
            y++;
            x = 0;
        }
        g.fillOval(x++, y, 1, 1);
    }

        private int getNum(byte[] buf) {
            int tmp, res;
            res = Math.abs(buf[0]);
            tmp = Math.abs(buf[1]) << 8;
            res += tmp;
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
        if (SearchText.getText().trim().length() != 14 | !isDigit(SearchText.getText())) {
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

    private void SearchTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_SearchTextCaretUpdate
        if (SearchText.getText().length() != 14 & SearchText.getBackground() == Color.GREEN) {
            SearchText.setBackground(Color.WHITE);
        } else if (SearchText.getText().length() == 14) {
            SearchText.setBackground(Color.GREEN);
        }
    }//GEN-LAST:event_SearchTextCaretUpdate

    private void ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox1ActionPerformed
        try {
            readFile(new RandomAccessFile("pic/pic_" + (ComboBox1.getSelectedIndex() + 1) + ".mbv", "r"), 1);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        PicRGB1.setSize(width, height);
        PicGray1.setSize(width, height);
    }//GEN-LAST:event_ComboBox1ActionPerformed

    private void ComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox2ActionPerformed
        try {
            readFile(new RandomAccessFile("pic/pic_" + (ComboBox1.getSelectedIndex() + 1) + ".mbv", "r"), 2);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        PicRGB2.setSize(width, height);
        PicGray2.setSize(width, height);
    }//GEN-LAST:event_ComboBox2ActionPerformed

    private boolean isDigit(String s) {
        return Pattern.compile("[0-1]").matcher(s).find();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BlueText;
    private javax.swing.JPanel ColorPallete;
    private javax.swing.JComboBox<String> ComboBox1;
    private javax.swing.JComboBox<String> ComboBox2;
    private javax.swing.JPanel FindedColorPanel;
    private javax.swing.JTextField GreenText;
    private javax.swing.JPanel PicGray1;
    private javax.swing.JPanel PicGray2;
    private javax.swing.JPanel PicRGB1;
    private javax.swing.JPanel PicRGB2;
    private javax.swing.JTextField RGBrepres;
    private javax.swing.JTextField RedText;
    private javax.swing.JPanel Scroll;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchText;
    private javax.swing.JPanel SelectedColorPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
