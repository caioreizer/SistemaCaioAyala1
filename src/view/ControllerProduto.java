/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.CraProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerProduto extends AbstractTableModel {

    private List lstProduto;

    public void setList(List lstProduto) {
        this.lstProduto = lstProduto;
    }
    
    public CraProduto getBean(int rowIndex) {
        return (CraProduto) lstProduto.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstProduto.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CraProduto produto = (CraProduto) lstProduto.get( rowIndex);
        if ( columnIndex == 0 ){
            return produto.getCraIdProduto();
        } else if (columnIndex ==1) {
            return produto.getCraNome();        
        } else if (columnIndex ==2) {
            return produto.getCraPreco();
        } else if (columnIndex ==3) {
            return produto.getCraTamanho();
          } else if (columnIndex ==4) {
            return produto.getCraDescricao();
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
            return "Preço";
        } else if ( columnIndex == 3) {
            return "Tamanho";
         } else if ( columnIndex == 4) {
            return "Descrição";
        }
        return "";
    }
}
