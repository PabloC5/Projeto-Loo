package model;

//public class CriarTableClientes {

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CriarTableClientes extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_CPF = 1;

    private static final int COL_IDADE = 2;

    private static final int COL_NOME = 3;



    List<Cliente> listaClientes;

    String [] colunas = {"ID","CPF", "Idade", "Nome"};

    public CriarTableClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public int getRowCount() {
        return listaClientes.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    public Class getColumnClass(int columnIndex) {
        if (columnIndex == COL_ID) {
            return Integer.class;
        }
        return String.class;
    }

    public void removeCliente(int indiceLinha) {
        listaClientes.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha,
                indiceLinha);

    }
    public boolean isCellEditable(int rowIndex, int
            columnIndex) {
        return false;
    }

    public Object getValueAt(int row, int column) {

        Cliente m = listaClientes.get(row);

        if (column == COL_ID) {
            return m.getId();
        } else if (column == COL_CPF) {
            return m.getCpf();
        }else if (column == COL_IDADE){
            return m.getIdade();
        }else if (column == COL_NOME){
            return m.getNome();
        }

        return m.getId();
    }
}