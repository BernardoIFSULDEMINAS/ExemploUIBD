/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



import java.text.ParseException;
import org.jdesktop.beansbinding.Converter;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author 13828523633
 */
public class ConverteData extends Converter<Calendar,String> {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public String convertForward(Calendar value) {
        return sdf.format(value.getTime());
    }
    
    public ConverteData() {
        sdf.setLenient(false);
    }
    
    @Override
    public Calendar convertReverse(String value) {
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(value));
            return c;
        } catch (ParseException e) {
            System.out.println("Erro quando processando data: " + e.getMessage());
            throw new RuntimeException("Não pôde processar data");
        }
        
    }
    
}
