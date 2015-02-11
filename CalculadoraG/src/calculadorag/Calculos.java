/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorag;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Se7en
 */
public class Calculos {
 
    
    Botões_Valores teclas=new Botões_Valores();
     biblio_aux biblio =new biblio_aux();
     
     public float calc_op_sem_priori(List totais){
          System.out.println("ENTROU sem");
         int i;
         float parse;
         float total=0;
         String operator_aux;
         String last_operator="";
         for(i=0;i<totais.size();i++)
        
        {    
            operator_aux=biblio.choose_operator(totais.get(i).toString());
              if (!operator_aux.equals("")==true){                  
                  last_operator=operator_aux;
                  continue;
              }
            
              
            parse= Float.parseFloat(totais.get(i)+"");
           total=Calculo(last_operator,parse,total);
        }
         return total;

    
     }   
    
   
  
  public float calc_op_com_priori(List totais)
  {  System.out.println("ENTROU COM");
         int i,k;
         float parse;
         float total=0;
         
         List<String> totais_aux = new ArrayList<>();
         
         
         String operator_aux;        
         String last_operator="";
         
         
         //falta receber index em array caso haa mais qe um operador
         int pos[]=  biblio.Get_Index(totais,teclas.tecla_multi);
       
         System.out.println("pos 0->"+pos[0]);
          
         System.out.println("tamanho pos>"+pos.length);
         
         for(i =0;i<pos.length;i++){
        
          System.out.println("TA AQUI");
         
       float parse_anterior=Float.parseFloat(totais.get(pos[i]-1)+"");
       float parse_posterior=Float.parseFloat(totais.get(pos[i]+1)+"");
               
       
       float total_parcial=parse_anterior*parse_posterior;
       
      
        totais.remove(pos[i]+1);
        totais.remove(pos[i]);
       totais.remove(pos[i]-1);
      totais.add(pos[i]-1, total_parcial);
      
         
        for(k=0;k<totais.size();k++){
            
        System.out.println("--8->"+totais.get(k));
        }
       
       
         }
       
         for(i=0;i<totais.size();i++)
        
        {    
           
            operator_aux=biblio.choose_operator(totais.get(i).toString());
              if (!operator_aux.equals("")==true){                  
                  last_operator=operator_aux;
                  continue;
              }
            
              
            parse= Float.parseFloat(totais.get(i)+"");
           total=Calculo(last_operator,parse,total);
        }
         return total;

  }
  
    public float check_calculo(List totais)//verifica se calculo é simples ou c prioridades
  {
      float resultado=0;
     if (totais.contains(teclas.tecla_multi)==true )
     resultado=calc_op_com_priori(totais);
     else if (totais.contains(teclas.tecla_multi)==false ) 
         resultado= calc_op_sem_priori(totais);
     
     
      return resultado;   
     }
      
     
  
 public float Parse_Totais(List totais,List parcial){
         
         
           
String full="";
    int tam=totais.size(),i;
    float parse;
    
    String last_operator="";
    String operator_aux="";
    float resultado=0;
    boolean ftime=true;
    
    
    resultado=check_calculo(totais);
    
    
    /*
    
    ////////calculs com prioridades
    
     if (totais.contains(teclas.tecla_multi)==true){  
         
       int pos=  biblio.Get_Index(totais,teclas.tecla_multi);
       
       float parse_anterior=Float.parseFloat(totais.get(pos-1)+"");
       float parse_posterior=Float.parseFloat(totais.get(pos+1)+"");
               
       
       float total_parcial=parse_anterior*parse_posterior;
       
       
        totais.remove(pos+1);
        totais.remove(pos);
       totais.remove(pos-1);
       totais.add(total_parcial);
       
          System.out.println("Entrou->"+ total_parcial); 
        
      }
    
    
     
     for(i=0;i<totais.size();i++)
     System.out.println("Index:"+ i + "   Valor: "+totais.get(i));
     
     
     
    /////////////calculos sem prioridades///////
    for(i=0;i<totais.size();i++)
    {
       if(totais.size()==1){
            parse= Float.parseFloat(totais.get(i)+"");
       return parse;}
    
    
      if (ftime==true){//caso seja a 1º caso
     parse= Float.parseFloat(totais.get(i)+"");
      System.out.println("TAMOS AQUI AGORA:"+parse);
    total=parse; 
   ftime=false;
 
   
    continue;
   }
  
     operator_aux=biblio.choose_operator(full);
   if (!operator_aux.equals("")){//apareceu operador
       
       //verificar se existem operadores prioritarios na função
     
       last_operator=operator_aux;      
       
       continue;
   }
           parse= Float.parseFloat(totais.get(i)+"");                 
         total= Calculo(last_operator,total,parse);                                         
    }
    
     System.out.println("----------->"+total);
    
    return total;
    */
    return resultado;
}
    
   
       public float Calculo(String operator,float num1,float num2){
          
           if (operator.equals("+"))              
               num1=num1+num2;
          if (operator.equals("-"))              
               num1=num1-num2;
          if (operator.equals("x"))              
               num1=num1*num2;
           if (operator.equals("/"))              
               num1=num1/num2;
           return num1;
      }  
     
     
}
