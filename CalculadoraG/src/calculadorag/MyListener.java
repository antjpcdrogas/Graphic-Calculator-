package calculadorag;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author Se7en
 */

    
   
public class MyListener implements ActionListener{

    //this method overrides the actionPerformed() method of the ActionListener interface
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Hello world!");
    }

}

