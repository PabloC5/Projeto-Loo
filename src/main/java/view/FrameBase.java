package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameBase extends JFrame implements VisualWindow {
    private JButton jButton;
    private JButton jButton2;
    private JButton jButton3;
    private JPanel painel = new JPanel();

    public FrameBase(){
        setLayouts();
        setComponents();
        setEvents();
        repaint();
    }

    @Override
    public void setLayouts() {
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void setComponents() {
        jButton = new JButton("Cadastrar Cliente");
        jButton2 = new JButton("Listar Clientes");
        jButton3 = new JButton("Cadastrar Produto");

        painel.add(jButton);

        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        JPanel titlePanel = new JPanel();
        titlePanel.add(Box.createRigidArea(new Dimension(145,0)));
        JLabel imagem = new JLabel();
        ImageIcon imageIcon = new ImageIcon("/home/pablo/Documentos/logo.png") ;
        imagem.setIcon(imageIcon);
        imagem.setAlignmentY(CENTER_ALIGNMENT);
        listPane.add(imagem);
        listPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,50));
        listPane.add(Box.createRigidArea(new Dimension(400,500)));

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setAlignmentX(CENTER_ALIGNMENT);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 200, 10));
        buttonPane.add(Box.createVerticalGlue());
        buttonPane.add(Box.createRigidArea(new Dimension(400, 0)));
        buttonPane.add(jButton);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(jButton2);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(jButton3);
        Container contentPane = getContentPane();

        contentPane.add(listPane, BorderLayout.CENTER);
        contentPane.add(buttonPane, BorderLayout.SOUTH);
        contentPane.add(titlePanel, BorderLayout.NORTH);

    }

    @Override
    public void setEvents() {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastroCliente().setVisible(true);
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastroVeiculo().setVisible(true);
            }
        });
    }

    public void repaintAll(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                repaint();
            }
        });
    }
}