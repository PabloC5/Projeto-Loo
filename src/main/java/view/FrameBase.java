package view;

import dao.VeiculoDao;
//import model.Carro;
import model.Carro;
import model.Veiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FrameBase extends JFrame implements VisualWindow {
    private JButton jButton;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButtonThread;

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
        jButton2 = new JButton("Listar Carros");
        jButton3 = new JButton("Cadastrar Veiculo");
        jButton4 = new JButton("Listar Clientes");
        jButtonThread = new JButton("Execute a Thread??");

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
        buttonPane.add(Box.createRigidArea(new Dimension(250, 0)));
        buttonPane.add(jButton);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(jButton2);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(jButton3);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(jButton4);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(jButtonThread);
        Container contentPane = getContentPane();

        contentPane.add(listPane, BorderLayout.CENTER);
        contentPane.add(buttonPane, BorderLayout.SOUTH);
        contentPane.add(titlePanel, BorderLayout.NORTH);

    }

    public void ExecThread(){
        new Thread() {

            JFrame frame = new JFrame();
            JPanel panel = new JPanel();
            JLabel label = new JLabel();

            List<Carro> listaPercorreCarro;
            VeiculoDao dao = new VeiculoDao();
            public void run() {
                frame.setBackground(Color.gray);
                frame.setSize(800, 600);
                frame.setVisible(true);

                panel.add(label);
                frame.add(panel);
//                frame.add(panel2);
                label.setText("0");

                listaPercorreCarro = dao.listAllVeiculos();
                for (int i = 1; i-1 < listaPercorreCarro.size(); i++) {
                    try {
                        sleep(100);
                        System.out.println("to executando");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    label.setText("Contando quantos Veiculos temos no banco: " + i);
                }
//                frame.dispose();
            }
        }.start();
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
                new ListagemVeiculos().setVisible(true);
            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastroVeiculo().setVisible(true);
            }
        });

        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListagemClientes().setVisible(true);
            }
        });

        jButtonThread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecThread();
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