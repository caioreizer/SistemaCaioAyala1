/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.CraVendasProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerVendasProduto extends AbstractTableModel {

    private List lstVendasProdutos;

    public void setList(List lstVendasProdutos) {
        this.lstVendasProdutos = lstVendasProdutos;
        
        this.fireTableDataChanged();
    }
    
    public CraVendasProdutos getBean(int rowIndex) {
        return (CraVendasProdutos) lstVendasProdutos.get(rowIndex);
    }

    public void addBean(CraVendasProdutos vendasProdutos) {
        lstVendasProdutos.add(vendasProdutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex) {
        lstVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstVendasProdutos.size();                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CraVendasProdutos vendasProdutos = (CraVendasProdutos) lstVendasProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return vendasProdutos.getCraProduto().getCraIdProduto();
        } else if (columnIndex ==1) {
            return vendasProdutos.getCraProduto().getCraNome();
        } else if (columnIndex ==2) {
            return vendasProdutos.getCraQuantidade();
        } else if (columnIndex ==3) {
            return vendasProdutos.getCraPrecoFinal();
        }else if (columnIndex ==4) {
            return vendasProdutos.getCraPrecoFinal()*vendasProdutos.getCraQuantidade();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Produto";         
        } else if ( columnIndex == 2) {
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Valor Unitário";
        } else if ( columnIndex == 4) {
            return "Total";
        } 
        return "";
    }
}
