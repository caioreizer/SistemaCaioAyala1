    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.CraVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
    }
    
    public CraVendas getBean(int rowIndex) {
        return (CraVendas) lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CraVendas vendas = (CraVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return vendas.getCraIdVendas();
        } else if (columnIndex ==1) {
            return vendas.getCraDataVenda();        
        } else if (columnIndex ==2) {
            return vendas.getCraFormaPagamento();
        } else if (columnIndex ==3) {
            return vendas.getCraValorUnitario();
        } else if (columnIndex ==4) {
            return vendas.getCraStatus();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Data da Venda";         
        } else if ( columnIndex == 2) {
            return "Forma de pagamento";
        } else if ( columnIndex == 3) {
            return "Valor Unitário";
        } else if ( columnIndex == 4) {
            return "Status da venda";
        } 
        return "";
    }
}
