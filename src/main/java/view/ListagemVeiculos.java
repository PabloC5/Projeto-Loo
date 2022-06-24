package view;

import model.CriaTableVeiculos;
import dao.VeiculoDao;
import controller.ListaClientes;
import model.Carro;
import util.Banco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListagemVeiculos extends JFrame implements VisualWindow {

    private JButton jButton;

    private  JButton jButton2;
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private Banco banco = new Banco();
    private JPanel contentPane;
    private JPanel tituloPainel;

    private JPanel painelFundo;

    private ListaClientes listaClientes;
    private JTable tabela;

    private JScrollPane barraRolagem;

    private CriaTableVeiculos modelo;
    List<Carro> lista;

    String [] colunas = {"Modelo", "Preço", "teste"};

    public ListagemVeiculos(){
        setLayouts();
        setComponents();
        setEvents();
        repaint();
    }

//    public Listagem(List<Carro> carros){
//        this.listDeCarros = new ArrayList<>(carros);
//    }

    @Override
    public void setLayouts() {
        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(Color.BLUE);
    }

    private void pesquisar() {
        VeiculoDao dao = new VeiculoDao();
        lista = dao.listAllVeiculos();
        modelo = new CriaTableVeiculos(lista);
        tabela.setModel(modelo);
    }
//    teste net
    @Override
    public void setComponents() {
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        tabela = new JTable(modelo);
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
//        jButton2.setForeground(new Color(226, 29, 29));
        jButton2.setForeground(new Color(01, 100, 0));
        jButton2.setBounds(500, 500, 95, 25);
        jButton2.setText("Editar");
        getContentPane().add(jButton);
        getContentPane().add(jButton2);

//        fim teste
    }

    public void deletaDeves(){
        try {
            System.out.println("estou aqui 1");
            VeiculoDao veiculoDao = new VeiculoDao();
            veiculoDao.listAllVeiculos();
            int linhaSelecionada = -1;
            linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                System.out.println(tabela.getValueAt(linhaSelecionada, 0).toString());
                int idVeiculo = Integer.parseInt(tabela.getValueAt(linhaSelecionada, 0).toString());
                VeiculoDao dao = new VeiculoDao();
                dao.deleteProduto(idVeiculo);
                        modelo.removeContato(linhaSelecionada);
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha.");
            }
        }catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public Carro pegaVeiculos(){
        try {
            System.out.println("estou aqui 1");
            VeiculoDao veiculoDao = new VeiculoDao();
            veiculoDao.listAllVeiculos();
            int linhaSelecionada = -1;
            linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                System.out.println(tabela.getValueAt(linhaSelecionada, 0).toString());
                int idVeiculo = Integer.parseInt(tabela.getValueAt(linhaSelecionada, 0).toString());
                VeiculoDao dao = new VeiculoDao();
//                dao.getProdutoById(idVeiculo);
//                modelo.removeContato(linhaSelecionada);
                return (Carro) dao.getProdutoById(idVeiculo);
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha.");
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
                    deletaDeves();
                }catch (Exception exception){
                    System.out.println("Erro encontrado: " + exception);
                }

            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new EditaVeiculo(pegaVeiculos()).setVisible(true);
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