package compulsory;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JSpinner shapesField;
    JComboBox colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("(Only for Random Polygon!) Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(5); //default number of sides

        String[] colors = {"Random", "Black"};
        String[] shapes = {"Random Polygon", "Triangle", "Diamond"};

        colorCombo = new JComboBox(colors);
        colorCombo.setSelectedIndex(0);

        SpinnerListModel model = new SpinnerListModel(shapes);
        shapesField = new JSpinner(model);
        Dimension dimension = new Dimension(100, 25);
        shapesField.setPreferredSize(dimension);


        add(label); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
        add(shapesField);
    }


}
