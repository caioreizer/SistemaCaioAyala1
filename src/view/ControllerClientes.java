/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.CraClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerClientes extends AbstractTableModel {

    private List lstClientes;

    public void setList(List lstClientes) {
        this.lstClientes = lstClientes;
    }
    
    public CraClientes getBean(int rowIndex) {
        return (CraClientes) lstClientes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstClientes.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CraClientes funcionario = (CraClientes) lstClientes.get( rowIndex);
        if ( columnIndex == 0 ){
            return funcionario.getCraIdCliente();
        } else if (columnIndex ==1) {
            return funcionario.getCraNome();        
        } else if (columnIndex ==2) {
            return funcionario.getCraCpf();
        } else if (columnIndex ==3) {
            return funcionario.getCraCep();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Cpf";
        } else if ( columnIndex == 3) {
            return "Cep";
        } 
        return "";
    }
}
