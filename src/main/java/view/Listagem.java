//package view;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class SecondScreen extends JPanel implements VisualWindow{
//
//        private FrameBase frameBase;
//
//        public SecondScreen(FrameBase frameBase){
//            this.frameBase = frameBase;
//            setLayouts();
//            setComponents();
//            setEvents();
//        }
//
//        @Override
//        public void setLayouts() {
//            setLayout(new FlowLayout());
//            setVisible(true);
//            setBackground(Color.DARK_GRAY);
//        }
//
//        @Override
//        public void setComponents() {
//
//        }
//
//        @Override
//        public void setEvents() {
//
//        }
//
//}

package view;

import javax.swing.*;
import java.awt.*;

public class Listagem extends JPanel implements VisualWindow{


    private FrameBase frameb;

    public Listagem(FrameBase frameb) {
        this.frameb = frameb;
        setLayouts();
        setComponents();
        setEvents();
    }


    @Override
    public void setLayouts() {
        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(Color.BLUE);

    }

    @Override
    public void setComponents() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEvents() {
        // TODO Auto-generated method stub

    }



}
