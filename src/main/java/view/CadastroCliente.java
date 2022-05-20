package view;

import controller.Register;
import model.Cliente;
import model.Veiculo;
import util.Banco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroCliente extends JFrame implements VisualWindow {

    private JButton jButton;
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private Banco banco = new Banco();
    private JPanel contentPane;
    private JPanel tituloPainel;


    public CadastroCliente(){
        setLayouts();
        setComponents();
        setEvents();
        repaint();
    }

    @Override
    public void setLayouts() {
//        setSize(800, 600);
//        setVisible(true);
        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(Color.BLUE);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void setComponents() {
//        menuBar = new JMenuBar();
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
        jButton.setText("Salvar");
        contentPane.add(jButton);

//        Container contentPane = getContentPane();
//        contentPane.add(labelTitulo, BorderLayout.CENTER);

    }

    @Override
    public void setEvents() {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cpf = textField2.getText();
                    String nome = textField.getText();
                    int idade = Integer.parseInt(textField3.getText());
                    Cliente cliente = new Cliente(nome,idade,cpf);
                    Register register = new Register();
                    register.saveClient(cliente);

                    textField.setText("");
                    textField2.setText("");
                    textField3.setText("");
                }catch (Exception exception){
                    System.out.println("Erro encontrado: " + exception);
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