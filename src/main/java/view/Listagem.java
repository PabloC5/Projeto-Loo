package view;

import controller.CriaTableVeiculos;
import dao.VeiculoDao;
import controller.ListaClientes;
import model.Carro;
import util.Banco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Listagem extends JFrame implements VisualWindow {

    private JButton jButton;
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

    Object [][] dados = {
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
            {"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
    };

    public Listagem(){
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
//        textField = new JTextField();
//        textField2 = new JTextField();
//        textField3 = new JTextField();
//        setBounds(100, 100, 450, 300);
//        contentPane = new JPanel();
//        tituloPainel = new JPanel();
//        contentPane.setBackground(Color.lightGray);
//        setContentPane(contentPane);
//        contentPane.setLayout(null);

//        JPanel buttonPane = new JPanel();

//        jButton = new JButton("");
//        jButton.setFont(new Font("Ubuntu", Font.BOLD, 14));
//        jButton.setForeground(new Color(01, 100, 0));
//        jButton.setBounds(100, 100, 200, 25);
//        jButton.setText("Listar");
//        contentPane.add(jButton);
//        contentPane.add(tabela);

//        começa testes net
//        tabela = new JTable(modelo);

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
        getContentPane().add(jButton);

//        fim teste
    }

    public void deletaDeves(){
        try {
            System.out.println("estou aqui 1");
            VeiculoDao veiculoDao = new VeiculoDao();
            veiculoDao.listAllVeiculos();
            int linhaSelecionada = -1;
            linhaSelecionada = tabela.getSelectedRow();
//            System.out.println(tabela.getSelectedRow());
//            System.out.println("estou aqui 2");
            if (linhaSelecionada >= 0) {
                System.out.println("estou aqui 3");
                System.out.println(tabela.getValueAt(linhaSelecionada, 0).toString());
                int idVeiculo = Integer.parseInt(tabela.getValueAt(linhaSelecionada, 0).toString());
//                System.out.println("estou aqui 4");
                VeiculoDao dao = new VeiculoDao();
                dao.deleteProduto(idVeiculo);
                        modelo.remover(linhaSelecionada);
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha.");
            }
        }catch (Exception exception) {
            System.out.println(exception);
        }
    }
    @Override
    public void setEvents() {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deletaDeves();
//                    Object [][] testeLista = (Object[][]) veiculoDao.listAllVeiculos().toArray();
//                    System.out.println(Arrays.stream(dados).toArray());
//                    System.out.println("teste lista de veiculos nova");
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