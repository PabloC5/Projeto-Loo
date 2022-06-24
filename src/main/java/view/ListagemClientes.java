package view;

import controller.Register;
import dao.ClientDao;
import model.Cliente;
import controller.ListaClientes;
import model.CriarTableClientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListagemClientes extends JFrame implements VisualWindow {

    private JButton jButton;

    private  JButton jButton2;
    private JPanel painelFundo;

    private JTable tabela;

    private JScrollPane barraRolagem;

    private CriarTableClientes modelClienteTable;
    List<Cliente> listaCliente;

    public ListagemClientes(){
        setLayouts();
        setComponents();
        setEvents();
        repaint();
    }

    @Override
    public void setLayouts() {
        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(Color.BLUE);
    }

    private void pesquisar() {
        ClientDao dao = new ClientDao();
        listaCliente = dao.listAllCliente();
        modelClienteTable = new CriarTableClientes(listaCliente);
        tabela.setModel(modelClienteTable);
    }
    //    teste net
    @Override
    public void setComponents() {
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        tabela = new JTable(modelClienteTable);
        pesquisar();
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem);

        getContentPane().add(painelFundo);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 120);
        setVisible(true);

        jButton = new JButton("");
        jButton.setFont(new Font("Ubuntu", Font.BOLD, 14));
        jButton.setForeground(new Color(226, 29, 29));
        jButton.setBounds(500, 500, 95, 25);
        jButton.setText("Deletar");

        jButton2 = new JButton("");
        jButton2.setFont(new Font("Ubuntu", Font.BOLD, 14));
        jButton2.setForeground(new Color(01, 100, 0));
        jButton2.setBounds(500, 500, 95, 25);
        jButton2.setText("Editar");
        getContentPane().add(jButton);
        getContentPane().add(jButton2);

//        fim teste
    }

    public void deletarClient(){
        try {
            System.out.println("estou aqui 1");
            ClientDao clienteDao = new ClientDao();
            clienteDao.listAllCliente();
            int linhaSelecionada = -1;
            linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                System.out.println(tabela.getValueAt(linhaSelecionada, 0).toString());
                int idClient = Integer.parseInt(tabela.getValueAt(linhaSelecionada, 0).toString());
                Register register = new Register();
                register.deletaClientes(idClient);
                modelClienteTable.removeCliente(linhaSelecionada);
            }
        }catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public Cliente getClientes(){
        try {
            System.out.println("estou aqui 1");
            ClientDao clienteDao = new ClientDao();
            clienteDao.listAllCliente();
            int linhaSelecionada = -1;
            linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                System.out.println(tabela.getValueAt(linhaSelecionada, 0).toString());
                int idCliente = Integer.parseInt(tabela.getValueAt(linhaSelecionada, 0).toString());
                ClientDao dao = new ClientDao();
                return dao.getClienteById(idCliente);
            }
        }catch (Exception exception) {
            System.out.println(exception);
        }
        return null;
    }
    @Override
    public void setEvents() {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deletarClient();
                }catch (Exception exception){
                    System.out.println("Erro encontrado: " + exception);
                }

            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new EditaCliente(getClientes()).setVisible(true);
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
