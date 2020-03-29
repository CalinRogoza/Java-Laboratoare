package compulsory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    //create all buttons (Load, Reset, Exit)
    Graphics2D graphics;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        //add all buttons
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        resetBtn.addActionListener(this::reset);
        loadBtn.addActionListener(this::load);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(null);

            ImageIO.write(frame.canvas.image, "PNG", fileChooser.getSelectedFile());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void reset(ActionEvent e) {
        this.frame.canvas.setVisible(false);
        this.frame.canvas.createOffscreenImage();
        this.frame.canvas.setVisible(true);
    }

    private void load(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                BufferedImage image = ImageIO.read(fileChooser.getSelectedFile());
                this.frame.canvas.loadImage(image);
                this.frame.canvas.revalidate();
                this.frame.canvas.repaint();
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }
}
