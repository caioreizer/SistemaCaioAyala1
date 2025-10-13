/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.CraFuncionario;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerFuncionarios extends AbstractTableModel {

    private List lstFuncionario;

    public void setList(List lstFuncionario) {
        this.lstFuncionario = lstFuncionario;
    }
    
    public CraFuncionario getBean(int rowIndex) {
        return (CraFuncionario) lstFuncionario.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstFuncionario.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CraFuncionario funcionario = (CraFuncionario) lstFuncionario.get( rowIndex);
        if ( columnIndex == 0 ){
            return funcionario.getCraIdFuncionario();
        } else if (columnIndex ==1) {
            return funcionario.getCraNome();        
        } else if (columnIndex ==2) {
            return funcionario.getCraCargo();
        } else if (columnIndex ==3) {
            return funcionario.getCraCpf();
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
            return "Cargo";
        } else if ( columnIndex == 3) {
            return "Cpf";
        } 
        return "";
    }
}
