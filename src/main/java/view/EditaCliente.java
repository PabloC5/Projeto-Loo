package view;

import controller.Register;
import dao.ClientDao;
import model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditaCliente extends JFrame implements VisualWindow {

    private JButton jButton;
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel contentPane;
    private JPanel tituloPainel;
    private Cliente clientes;


    public EditaCliente(Cliente cliente){
        setClientes(cliente);
        setLayouts();
        setComponents();
        setEvents();
        repaint();
    }

    @Override
    public void setLayouts() {
        setSize(800, 600);
        setVisible(true);
    }

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    @Override
    public void setComponents() {
        textField = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        tituloPainel = new JPanel();
        contentPane.setBackground(Color.lightGray);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel buttonPane = new JPanel();
        JPanel textPanel = new JPanel();
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Arial Black", Font.BOLD, 12));
        lblNome.setForeground(SystemColor.desktop);
        lblNome.setBounds(95, 127, 70, 15);
        textField = new JTextField();
        textField.setBounds(183, 125, 146, 19);

        JLabel labelCpf = new JLabel("CPF:");
        labelCpf.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelCpf.setForeground(new Color(1, 42, 42));
        labelCpf.setBounds(95, 153, 70, 15);

        contentPane.add(labelCpf);
        textField2 = new JTextField();
        textField2.setBounds(183, 151, 146, 19);
        contentPane.add(textField2);
        textField2.setColumns(10);

        contentPane.add(lblNome);
        contentPane.add(textField);
        textField.setColumns(10);
        contentPane.add(buttonPane, BorderLayout.NORTH);


        JLabel labelIdade = new JLabel("Idade:");
        labelIdade.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelIdade.setForeground(new Color(01, 42, 42));
        labelIdade.setBounds(95, 177, 70, 15);
        contentPane.add(labelIdade);
        textField3 = new JTextField();
        textField3.setColumns(10);
        textField3.setBounds(183, 176, 146, 19);
        contentPane.add(textField3);


        jButton = new JButton("");
        jButton.setFont(new Font("Ubuntu", Font.BOLD, 14));
        jButton.setForeground(new Color(01, 100, 0));
        jButton.setBounds(85, 195, 95, 25);
        jButton.setText("Editar");
        contentPane.add(jButton);
        textField.setText(clientes.getNome());
        textField2.setText(String.valueOf(clientes.getCpf()));
        textField3.setText(String.valueOf(clientes.getIdade()));
        contentPane.add(jButton);
    }

    @Override
    public void setEvents() {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ClientDao clientDao = new ClientDao();
                    int id = (int) clientes.getId();
                    String nomeCliente = textField.getText();
                    int idadeCliente = Integer.parseInt(textField3.getText());
                    String cpf = textField2.getText();
                    Cliente clienteEditado = new Cliente(id,nomeCliente,idadeCliente, cpf);
                    Register register = new Register();
                    register.updateClinte(clienteEditado);
                    textField.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    System.out.println(clienteEditado);
                }catch (NumberFormatException exception){
                    textField.setText("Valores vazios");
                    textField2.setText("Valores vazios");
                    textField3.setText("Valores vazios");
                    System.out.println("Não permitido valores vazios");
                }
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
