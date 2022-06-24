package view;
import java.awt.Color;

import javax.swing.*;

public class ThreadExecute extends Thread {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel();

        public void run() {
            frame.setBackground(Color.gray);
            frame.setVisible(true);

            panel.add(label);
            frame.add(panel);
            label.setText("0");

            for(int i = 0; i<100; i++) {
                try {
                    sleep(100);
                    System.out.println("to executando");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                label.setText(""+i);
            }
            frame.dispose();
        }

//    }
}
