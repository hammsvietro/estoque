/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;
import javax.swing.table.AbstractTableModel;
import java.util.*;

/**
 *
 * @author Hammsvietro
 */
public class ProdutoTableModel extends AbstractTableModel{

    
    private ArrayList<Produto> dados = new ArrayList<>();
    private String[] colunas = {"Nome" , "ID" , "Quantidade" , "Valor"};
    
    public int getRowCount() {
        return dados.size();
    }

   
    public String getColumnName(int column) {
        return colunas[column];
    }

   public void removeRow(int linha){
       this.dados.remove(linha);
       this.fireTableRowsDeleted(linha,linha);
   }
    
    public int getColumnCount() {
        return colunas.length;
    }

   
    public Object getValueAt(int linha, int coluna) {
        switch (coluna){
            case 0:
                return dados.get(linha).getNome();
            case 1:
                return dados.get(linha).getId();
            case 2:
                return dados.get(linha).getQuantidade();
            case 3:
                return dados.get(linha).getValor();
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch (coluna){
            case 0:
                dados.get(linha).setNome((String) valor);
                break;
            case 1:
                dados.get(linha).setId(Long.parseLong((String) valor));
                break;
            case 2:
                dados.get(linha).setQuantidade(Long.parseLong((String) valor));
                break;
            case 3:
                dados.get(linha).setValor(Double.parseDouble((String) valor));
                break;
                
        }
        this.fireTableRowsUpdated(linha, linha);
        
    }
    
    
    
    
    public void addRow(Produto produto){
        this.dados.add(produto);
        this.fireTableDataChanged();
    }
    
}
