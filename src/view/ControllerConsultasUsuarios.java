/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.CraProduto;
import bean.CrsUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerConsultasUsuarios extends AbstractTableModel {

    private List lstUsuarios;

    public void setList(List lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
        this.fireTableDataChanged();
        
    }
    
    public CrsUsuarios getBean(int rowIndex) {
        return (CrsUsuarios) lstUsuarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstUsuarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CrsUsuarios usuarios = (CrsUsuarios) lstUsuarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return usuarios.getCraIdUsuarios();
        } else if (columnIndex ==1) {
            return usuarios.getCraApelido();        
        } else if (columnIndex ==2) {
            return usuarios.getCraDataNascimento();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Apelido";         
        } else if ( columnIndex == 2) {
            return "Data de nascimento";
        } 
        return "";
    }
}
