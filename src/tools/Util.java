/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author u1845853
 */
public class Util {

    public static void habilitar(boolean valor, JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);
        }
    }
    private static final String DATE_FORMAT = "dd/MM/yyyy"; 
    
    public static void limpar(JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
                //instanceof
            }
        }
    }
    
    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);        
    }
    
    public static boolean perguntar(String cad) {
        JOptionPane.showConfirmDialog(null, cad);
        return true;
    }
    
    public static int strToInt(String num) {
        return Integer.valueOf(num);
    }
    public static String intToStr(int num) {
        return String.valueOf(num);
    }    
    
    public static double strToDouble(String num) {
        return Double.parseDouble(num);
    }

    public static String doubleToStr(double num) {
        return String.valueOf(num);
    }

    public static Date strToDate(String data) throws ParseException { 
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.parse(data);
    }

    public static String dateToStr(Date data) {
        if (data == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(data);
    }
}
