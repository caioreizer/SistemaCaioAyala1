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

    private List lstVendasProduto;

    public void setList(List lstUsuarios) {
        this.lstVendasProduto = lstVendasProduto;
    }
    
    public CraVendasProdutos getBean(int rowIndex) {
        return (CraVendasProdutos) lstVendasProduto.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendasProduto.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CraVendasProdutos vendasProdutos = (CraVendasProdutos) lstVendasProduto.get( rowIndex);
        if ( columnIndex == 0 ){
            return vendasProdutos.getCraIdVendasProdutos();
        } else if (columnIndex ==1) {
            return vendasProdutos.getCraDesconto();        
        } else if (columnIndex ==2) {
            return vendasProdutos.getCraObservacao();
        } else if (columnIndex ==3) {
            return vendasProdutos.getCraQuantidade();
         } else if (columnIndex ==4) {
            return vendasProdutos.getCraPrecoFinal();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Desconto";         
        } else if ( columnIndex == 2) {
            return "Observação";
        } else if ( columnIndex == 3) {
            return "Quantidade";
        } else if ( columnIndex == 4) {
            return "Preço Final";
        } 
        return "";
    }
}
