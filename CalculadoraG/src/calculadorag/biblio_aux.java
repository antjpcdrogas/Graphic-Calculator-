/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorag;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Se7en
 */
public class biblio_aux {
    
   Botões_Valores teclas= new Botões_Valores();
    
    public String get_full_string(List lista){
    String full="";
    int tam=lista.size(),i;
    for(i=0;i<tam;i++)
        full=full + lista.get(i);
        
        
        
        
 return full;

}
    
    
    public String choose_operator(String operator){
      String choosed="";
      
     
    
     
        switch (operator) {
            case "+":  choosed = " + ";
                     break;
            case "-":  choosed = " - ";
                     break;
                case "*":  choosed = "*";
                     break;
                    
                     case "/":  choosed = " / ";
                     break;
                    
                  default :choosed = "";
                     break;
            
    }
        
        return choosed;
    }
    
    
     public int Get_num_operators_equals(List lista, String operador){ 
         int i,num_operators=0;
         
         String operator;
     for(i=0;i<lista.size();i++){
          operator=choose_operator(lista.get(i).toString());
          if (!operator.equals("")==true || operator.equals(operador)==true )
           num_operators++;
         
         
     }
   return num_operators;  
}
    public int[] Get_Index(List lista, String operator){
        int i;
        int counter=0;
        
        
        int index[]=new int[Get_num_operators_equals(lista,operator)];
        
        System.out.println("numero operadores>"+ Get_num_operators_equals(lista,operator));
        for(i=0;i<lista.size();i++){
            if (lista.get(i).equals(operator)==true){
                index[counter]=i;
                counter++;
                }
        
        
    }
        return index;
    }

    

    
    
    
  public void Operator_Pressed(String operator, List total, List parcial){ 
    
      total.add(get_full_string(parcial));
      total.add(operator);
     parcial.clear();
  }
}
