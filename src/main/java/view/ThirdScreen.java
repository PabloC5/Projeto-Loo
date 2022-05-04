package view;

import javax.swing.*;
import java.awt.*;

public class ThirdScreen extends JPanel implements VisualWindow {

    private FrameBase frameb;

    public ThirdScreen(FrameBase frameb){
        this.frameb = frameb;
        setLayouts();
        setComponents();
        setEvents();
    }

    @Override
    public void setLayouts() {
        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(Color.DARK_GRAY);
    }

    @Override
    public void setComponents() {

    }

    @Override
    public void setEvents() {

    }
}
