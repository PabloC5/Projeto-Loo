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

    private JButton jButton2;
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPanel contentPane;
    private JPanel tituloPainel;

    private Cliente clientes;


    public EditaCliente(Cliente cliente){
//        this.clientes = cliente;
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
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    @Override
    public void setComponents() {
//        textField = new JTextField();
//        textField2 = new JTextField();
//        textField3 = new JTextField();
//        textField4 = new JTextField();
//        setBounds(100, 100, 450, 300);
//        contentPane = new JPanel();
//        tituloPainel = new JPanel();
//        contentPane.setBackground(Color.white);
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
//
//        JPanel buttonPane = new JPanel();
//        JPanel textPanel = new JPanel();
////        JLabel labelTitulo = new JLabel("Cadastrar clientes:");
//        JLabel lblNomeProduto = new JLabel("Modelo Veiculo:");
//        lblNomeProduto.setFont(new Font("Arial Black", Font.BOLD, 12));
//        lblNomeProduto.setForeground(SystemColor.desktop);
//        lblNomeProduto.setBounds(95, 127, 70, 15);
////        teste
//        textField = new JTextField();
//        textField.setBounds(183, 125, 146, 19);
//
//        JLabel labelPreco = new JLabel("Preço:");
//        labelPreco.setFont(new Font("Arial Black", Font.PLAIN, 12));
//        labelPreco.setForeground(new Color(1, 42, 42));
//        labelPreco.setBounds(95, 153, 70, 15);
//
//        JLabel labelPortas = new JLabel("Portas Num:");
//        labelPortas.setFont(new Font("Arial Black", Font.PLAIN, 12));
//        labelPortas.setForeground(new Color(1, 42, 42));
//        labelPortas.setBounds(95, 190, 70, 15);
//
//        JLabel labelAroRodas = new JLabel("Aro rodas:");
//        labelAroRodas.setFont(new Font("Arial Black", Font.PLAIN, 12));
//        labelAroRodas.setForeground(new Color(1, 42, 42));
//        labelAroRodas.setBounds(95, 210, 70, 15);
//
////        tituloPainel.add(labelTitulo);
//        contentPane.add(labelPreco);
//        textField2 = new JTextField();
//        textField2.setBounds(183, 151, 146, 19);
//        contentPane.add(textField2);
//        textField2.setColumns(10);
//
//        contentPane.add(labelPortas);
//        textField3 = new JTextField();
//        textField3.setBounds(183, 190, 146, 19);
//        contentPane.add(textField3);
//        textField3.setColumns(10);
//
//        contentPane.add(labelAroRodas);
//        textField4 = new JTextField();
//        textField4.setBounds(183, 210, 146, 19);
//        contentPane.add(textField4);
//        textField4.setColumns(10);
//
//        contentPane.add(lblNomeProduto);
//        contentPane.add(textField);
//        textField.setColumns(10);
//        contentPane.add(buttonPane, BorderLayout.NORTH);
//
//        jButton = new JButton("");
//        jButton.setFont(new Font("Ubuntu", Font.BOLD, 14));
//        jButton.setForeground(new Color(01, 100, 0));
//        jButton.setBounds(85, 230, 95, 25);
//        jButton.setText("Editar");
//        novo
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
//        JLabel labelTitulo = new JLabel("Cadastrar clientes:");
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Arial Black", Font.BOLD, 12));
        lblNome.setForeground(SystemColor.desktop);
        lblNome.setBounds(95, 127, 70, 15);
//        teste
        textField = new JTextField();
        textField.setBounds(183, 125, 146, 19);

        JLabel labelCpf = new JLabel("CPF:");
        labelCpf.setFont(new Font("Arial Black", Font.PLAIN, 12));
        labelCpf.setForeground(new Color(1, 42, 42));
        labelCpf.setBounds(95, 153, 70, 15);

//        tituloPainel.add(labelTitulo);
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
//        fim novo
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
//                        clientDao.updateCarro(carro);
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
//}