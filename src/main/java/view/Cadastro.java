package view;

import model.Cliente;
import util.Banco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro extends JPanel implements VisualWindow{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;

    public Cadastro() {
        setSize(525,500);
        setLayouts();
        setComponents();
        setEvents();
        repaint();
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = textField1.getText();
                String nome = textField2.getText();
                int idade = Integer.parseInt(textField3.getText());
                Cliente cliente = new Cliente(nome,idade ,cpf);
                Banco banco = new Banco();
                banco.addCliente(cliente);
                banco.imprimeClientes();
            }
        });
    }

    @Override
    public void setLayouts() {
        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(Color.BLUE);
    }

    @Override
    public void setComponents() {

    }

    @Override
    public void setEvents() {

    }
}
