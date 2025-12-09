/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.CraFuncionario;
import bean.CrsUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerConsultasFuncionarios extends AbstractTableModel {

    private List lstFuncionario;

    public void setList(List lstFuncionario) {
        this.lstFuncionario = lstFuncionario;
        this.fireTableDataChanged();
        
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
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CraFuncionario funcionarios = (CraFuncionario) lstFuncionario.get( rowIndex);
        if ( columnIndex == 0 ){
            return funcionarios.getCraIdFuncionario();
        } else if (columnIndex ==1) {
            return funcionarios.getCraNome();        
        } else if (columnIndex ==2) {
            return funcionarios.getCraCpf();
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
        } 
        return "";
    }
}
