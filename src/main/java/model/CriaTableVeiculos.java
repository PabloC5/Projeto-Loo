package model;

import model.Carro;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CriaTableVeiculos extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;

    private static final int COL_PORTAS = 2;

    private static final int COL_RODAS = 3;

    private static final int COL_PRECO = 4;



    List<Carro> listDeCarros;

    String [] colunas = {"ID","Modelo", "Portas", "Aro Rodas","Preço"};


    public CriaTableVeiculos(List<Carro> listDeCarros) {
        this.listDeCarros = listDeCarros;
    }

    public int getRowCount() {
        return listDeCarros.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

//    public Class getColumnClass(int columnIndex) {
//        if (columnIndex == COL_ID) {
//            return Integer.class;
//        }
//        return String.class;
//    }

    public void removeContato(int indiceLinha) {
        listDeCarros.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha,
                indiceLinha);
    }
    public boolean isCellEditable(int rowIndex, int
            columnIndex) {
        return false;
    }

    public Object getValueAt(int row, int column) {

        Carro m = listDeCarros.get(row);

        if (column == COL_ID) {
            return m.getId();
        } else if (column == COL_NOME) {
            return m.getNomePoduto();
        }else if (column == COL_PORTAS){
            return m.getPortas();
        }else if (column == COL_RODAS){
            return m.getAroRodas();
        }else if (column == COL_PRECO){
            return m.getPreco();
        }

        return m.getId();
    }
}
