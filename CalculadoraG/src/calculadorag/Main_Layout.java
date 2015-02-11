package calculadorag;
import javax.swing.KeyStroke;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.function.Function;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Se7en
 */
public class Main_Layout extends javax.swing.JFrame {
          Color color;          
    biblio_aux biblio_auxiliar=new biblio_aux();
      Calculos calculos=new Calculos();
    List<String> inputs_parciais = new ArrayList<>();// valores addicionados á medida que se carregam nas teclas
String resultado_anterior="";
    List<String> inputs_totais = new ArrayList<>();// valores calculados quando aparece um operador + - * \
  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      MyListener listener = new MyListener();
     ImageIcon img = new ImageIcon("calculator.png");
     
JFileChooser fileChooser;  
  
int aux_save=0;   
Botões_Valores button_value= new Botões_Valores();



////////////////////////////////////////////////////////////////////77
/////////////////////////////////////////////////////////////////////




public void add_ecra_1(){
 
    
     EcraCalc.append(button_value.tecla1);
        Save_Input(button_value.tecla1);
    
    
}
public void add_ecra_2(){
     
     EcraCalc.append(button_value.tecla2);
        Save_Input(button_value.tecla2);
}
public void add_ecra_3(){
     
     EcraCalc.append(button_value.tecla3);
        Save_Input(button_value.tecla3);
}
public void add_ecra_4(){
     
     EcraCalc.append(button_value.tecla4);
        Save_Input(button_value.tecla4);
}
public void add_ecra_5(){
    
     EcraCalc.append(button_value.tecla5);
        Save_Input(button_value.tecla5); 
}
public void add_ecra_6(){
   
     EcraCalc.append(button_value.tecla6);
        Save_Input(button_value.tecla6);  
}
public void add_ecra_7(){
     
     EcraCalc.append(button_value.tecla7);
        Save_Input(button_value.tecla7);
}

public void add_ecra_8(){
    
     EcraCalc.append(button_value.tecla8);
        Save_Input(button_value.tecla8); 
}
public void add_ecra_9(){
     
     EcraCalc.append(button_value.tecla9);
        Save_Input(button_value.tecla9);
}
public void add_ecra_0(){
   
     EcraCalc.append(button_value.tecla0);
        Save_Input(button_value.tecla0);  
}



public void add_ecra_teclap(){
   
     EcraCalc.append(button_value.teclap);
        Save_Input(button_value.teclap);  
}

public void add_ecra_soma(){
   
     EcraCalc.append(button_value.tecla_soma);
        Save_Input(button_value.tecla_soma);  
}
public void add_ecra_sub(){
   
     EcraCalc.append(button_value.tecla_sub);
        Save_Input(button_value.tecla_sub);  
}
public void add_ecra_multi(){
   
     EcraCalc.append(button_value.tecla_multi_display);
        Save_Input(button_value.tecla_multi);  
}
public void add_ecra_div(){
   
     EcraCalc.append(button_value.tecla_div_display);
        Save_Input(button_value.tecla_div);  
}
public void add_ecra_delete(){
   
      int i,tam;

        try {//remove apenas no ecra
            Document doc = EcraCalc.getDocument();

            tam= inputs_parciais.get(inputs_parciais.size()-1).length();
            for(i=0;i<tam;i++)
            doc.remove(doc.getLength()-1, 1);

            System.out.println("asdasd");

        } catch (BadLocationException ex) {
            Logger.getLogger(Main_Layout.class.getName()).log(Level.SEVERE, null, ex);
        }

        inputs_parciais.remove( inputs_parciais.size()-1); 
    
    
    
}





public void add_ecra_enter(){
    
      String function=new String(),aux=new String();
        
        double y;
        if (!biblio_auxiliar.choose_operator(inputs_parciais.get(0)).equals("")){
            
            aux=resultado_anterior+inputs_parciais.get(0);
        inputs_parciais.set(0, aux);
        }
            
        for(int i=0;i<inputs_parciais.size();i++)
        function=function + inputs_parciais.get(i);
        
        System.out.println("--->" + function);
        Expression e = new ExpressionBuilder( function)
                
              .variables("x")
                .build();
          
                            
	   y =(double)Math.round(e.evaluate()*100) /100;
           resultado_anterior=y+"";
           EcraCalc.append("\n                     " + y+"\n");
           
        inputs_parciais.clear();
}
public void Save_Input(String add_value){      
inputs_parciais.add(add_value);
aux_save++;      
}
  
public void Input_Key_Maps(){
  
        jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_1,0), "1");

         jPanel4.getActionMap().put("1", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

               add_ecra_1();

            }
        });

         
         
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_2,0), "2");

         jPanel4.getActionMap().put("2", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

              add_ecra_2();

            }
        });
         
         
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_3,0), "3");

         jPanel4.getActionMap().put("3", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

                add_ecra_3();

            }
        });
          
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_4,0), "4");

         jPanel4.getActionMap().put("4", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

                add_ecra_4();

            }
        });
         
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD,0), ".");

         jPanel4.getActionMap().put(".", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

                add_ecra_teclap();

            }
        });
         
         
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_5,0), "5");

         jPanel4.getActionMap().put("5", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

                 add_ecra_5();

            }
        });
         
         
         
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_6,0), "6");

         jPanel4.getActionMap().put("6", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

               add_ecra_6();

            }
        });
         
         
         
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_7,0), "7");

         jPanel4.getActionMap().put("7", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

                 add_ecra_7();

            }
        });
         
         
         
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_8,0), "8");

         jPanel4.getActionMap().put("8", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
  add_ecra_8();
            }
        });
         
         
         
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_9,0), "9");

         jPanel4.getActionMap().put("9", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

     add_ecra_9();

            }
        });
         
         
         
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_0,0), "0");

         jPanel4.getActionMap().put("0", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

                add_ecra_0();

            }
        });
         
         
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), "enter");

         jPanel4.getActionMap().put("enter", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

                add_ecra_enter();

            }
        });
         
         
         
              jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_X,0), "*");
         

         
         
         
              jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE,0), "/");
         

         jPanel4.getActionMap().put("/", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

                add_ecra_div();

            }
        });
         
         
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY,0), "*");

         jPanel4.getActionMap().put("*", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

                add_ecra_multi();

            }
        });
         
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS,0), "+");

         jPanel4.getActionMap().put("+", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

                add_ecra_soma();

            }
        });
         
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS,0), "-");

         jPanel4.getActionMap().put("-", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

                add_ecra_sub();

            }
        });
         
            jPanel4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0), "DEL");

         jPanel4.getActionMap().put("DEL", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {

                add_ecra_delete();

            }
        });
         
}

    public Main_Layout() {
        initComponents();
        Input_Key_Maps();
        
        
        
        //////////////////Inputs teclado
        
        
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton26 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jFrame2 = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jFrame3 = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        textArea1 = new java.awt.TextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton34 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        EcraCalc = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jFrame1.setTitle("Modo Gráfico");
        jFrame1.setIconImage(img.getImage());
        jFrame1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFrame1MouseClicked(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setText("Y=");

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);
        jList1.getAccessibleContext().setAccessibleName("jList1");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setText("Lista de Funções ");

        jButton24.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton24.setText("Adicionar");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton25.setText("Desenhar!");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setText("X Min=");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setText("X Max=");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton26.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton26.setText("Remover");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Preenchar limites");

        jMenu3.setText("Funções");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Abrir  Funções");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Guarda Funções");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setText("Fechar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar2.add(jMenu3);

        jFrame1.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(jButton24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton26))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jButton25))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jFrame1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(6, 6, 6)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton26)
                            .addComponent(jButton24))
                        .addContainerGap())))
        );

        jFrame2.setTitle("Sobre");
        jFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Aplicação Desenvolvida pelo aluno António Drogas nº 23319, ");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 422, 24));

        jLabel7.setText("no âmbito do trabalho final da unidade curricular Interação Humana Com o Computador.");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        jFrame2.getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 448, -1));

        jFrame3.setTitle("Ajuda");

        textArea1.setText("Calculadora Gráfica que suporta todas as opções esplicitas na ferramenta.\n\nA tecla \"C\" apaga individualmente o que está apresentado no ecrã e a tecla \"clear\" apaga tudo. \n\nA utilização da ferramenta têm suporte do teclado fisico.\n\nA partir do Menu temos a opção de fechar a aplicação ou abrir o modo Gráfico da mesma.\n\n\nModo Gráfico:\n\nNeste modo é introduzida uma função com 1 variável real cujo gráfico será representado dentro dos limites estabelecidos,\napós pressionar a tecla \"DESENHAR\".\n\nNa tecla \"Adcionar\" e \"Remover\" controlamos as funções que serão guardadas na lista acima. Esta lista pode ser guardada,\npara uso posterior através da opção \" Guardar Funções\" no menu \"Funções\".\n\nPara abrir uma lista de funções já guardadas anteriormente, utiliza-se a opção \"Abrir Funções\".\n\nPara selecionar uma função da lista basta clicar sobre esta 2 vezes.\n\n\n\n\n");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora Gráfica - IHC 2014");
        setIconImage(img.getImage());
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel4KeyPressed(evt);
            }
        });
        jPanel4.setLayout(new java.awt.GridLayout(4, 8));

        jButton18.setBackground(new java.awt.Color(189, 189, 189));
        jButton18.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton18.setText("(");
        jButton18.setBorder(null);
        jButton18.setBorderPainted(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton18);

        jButton19.setBackground(new java.awt.Color(189, 189, 189));
        jButton19.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton19.setText(")");
        jButton19.setBorder(null);
        jButton19.setBorderPainted(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton19);

        jButton28.setBackground(new java.awt.Color(189, 189, 189));
        jButton28.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton28.setText("LOG");
        jButton28.setBorder(null);
        jButton28.setBorderPainted(false);
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton28);

        jButton23.setBackground(new java.awt.Color(189, 189, 189));
        jButton23.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton23.setText("C");
        jButton23.setBorder(null);
        jButton23.setBorderPainted(false);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton23);

        jButton29.setBackground(new java.awt.Color(189, 189, 189));
        jButton29.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton29.setText("ABS");
        jButton29.setBorder(null);
        jButton29.setBorderPainted(false);
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton29);

        jButton30.setBackground(new java.awt.Color(189, 189, 189));
        jButton30.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton30.setText("MOD");
        jButton30.setBorder(null);
        jButton30.setBorderPainted(false);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton30);

        jButton16.setBackground(new java.awt.Color(255, 212, 153));
        jButton16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton16.setText("\u00F7");
        jButton16.setBorder(null);
        jButton16.setBorderPainted(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton16);

        jButton35.setBackground(new java.awt.Color(189, 189, 189));
        jButton35.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton35.setText("TANH");
        jButton35.setBorder(null);
        jButton35.setBorderPainted(false);
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton35);

        jButton36.setBackground(new java.awt.Color(189, 189, 189));
        jButton36.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton36.setText("SINH");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton36);

        jButton31.setBackground(new java.awt.Color(189, 189, 189));
        jButton31.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton31.setText("LOG2");
        jButton31.setBorder(null);
        jButton31.setBorderPainted(false);
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton31);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton7.setText("7");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7);

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton8.setText("8");
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8);

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton9.setText("9");
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton9);

        jButton15.setBackground(new java.awt.Color(255, 212, 153));
        jButton15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton15.setText("X");
        jButton15.setBorder(null);
        jButton15.setBorderPainted(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton15);

        jButton22.setBackground(new java.awt.Color(189, 189, 189));
        jButton22.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton22.setText("EXP");
        jButton22.setActionCommand("Exp");
        jButton22.setBorder(null);
        jButton22.setBorderPainted(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton22);

        jButton33.setBackground(new java.awt.Color(189, 189, 189));
        jButton33.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton33.setText("\u221A");
        jButton33.setBorder(null);
        jButton33.setBorderPainted(false);
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton33);

        jButton32.setBackground(new java.awt.Color(189, 189, 189));
        jButton32.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton32.setText("LOG10");
        jButton32.setActionCommand("Log10");
        jButton32.setBorder(null);
        jButton32.setBorderPainted(false);
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton32);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton4.setText("4");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton5.setText("5");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5);

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton6.setText("6");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6);

        jButton14.setBackground(new java.awt.Color(255, 212, 153));
        jButton14.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton14.setText("-");
        jButton14.setBorder(null);
        jButton14.setBorderPainted(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton14);

        jButton21.setBackground(new java.awt.Color(189, 189, 189));
        jButton21.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton21.setText("TAN");
        jButton21.setBorder(null);
        jButton21.setBorderPainted(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton21);

        jButton20.setBackground(new java.awt.Color(189, 189, 189));
        jButton20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton20.setText("COS");
        jPanel4.add(jButton20);

        jButton17.setBackground(new java.awt.Color(189, 189, 189));
        jButton17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton17.setText("SIN");
        jButton17.setActionCommand("Sin");
        jButton17.setBorder(null);
        jButton17.setBorderPainted(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton17);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton1.setText("1");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.getAccessibleContext().setAccessibleName("num1");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton2.setText("2");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton3.setText("3");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jButton13.setBackground(new java.awt.Color(255, 212, 153));
        jButton13.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton13.setText("+");
        jButton13.setBorder(null);
        jButton13.setBorderPainted(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton13);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jButton34.setBackground(new java.awt.Color(189, 189, 189));
        jButton34.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton34.setText("Clear");
        jButton34.setBorder(null);
        jButton34.setBorderPainted(false);
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton34);

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton10.setText("0");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 212, 153));
        jButton11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton11.setText("=");
        jButton11.setPreferredSize(new java.awt.Dimension(9, 15));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel4.setSize(30, 40);

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton12.setText(".");
        jButton12.setBorder(null);
        jButton12.setBorderPainted(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        EcraCalc.setEditable(false);
        EcraCalc.setBackground(new java.awt.Color(204, 255, 204));
        EcraCalc.setColumns(6);
        EcraCalc.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        EcraCalc.setRows(3);
        EcraCalc.setTabSize(2);
        EcraCalc.setBorder(null);
        jScrollPane1.setViewportView(EcraCalc);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        jMenu1.setText("Menu");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Modo Gráfico");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem6.setText("Sair");
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Ajuda");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem3.setText("Sobre");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        getAccessibleContext().setAccessibleName("Frame_principal");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  
    
    
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
jLabel5.setVisible(false);        
       
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame1.setBackground(new java.awt.Color(102, 102, 102));
        jFrame1.setForeground(new java.awt.Color(102, 102, 102));
       jFrame1.setSize(390,260); 
jFrame1.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
                  // Set size of frame (in pixels)
        //jFrame1.setJMenuBar(null);
        jFrame1.setVisible(true);
        

        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    DefaultListModel model = new DefaultListModel();
    
     private void readFileToList(File file, JList list) throws IOException {  
         jList1.setModel(model);
         
         
        model.removeAllElements();
         
        DefaultListModel model = (DefaultListModel)list.getModel();  
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file)));
              String line;
              while((line = br.readLine()) != null) {
                  model.addElement(line);
              }
              br.close();
     }  
    
    
    
    
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        EcraCalc.append(button_value.tecla0);
        Save_Input(button_value.tecla0);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        EcraCalc.append(button_value.tecla_sub);
        Save_Input(button_value.tecla_sub);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        EcraCalc.append(button_value.tecla_sqrt_display);
        Save_Input(button_value.tecla_sqrt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        EcraCalc.append(button_value.tecla_exp);
        Save_Input(button_value.tecla_exp);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        EcraCalc.append(button_value.tecla_log);
        Save_Input(button_value.tecla_log);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        EcraCalc.append(button_value.tecla_pd);
        Save_Input(button_value.tecla_pd);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        EcraCalc.append(button_value.tecla_abs);
        Save_Input(button_value.tecla_abs);            // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        EcraCalc.append(button_value.tecla3);
        Save_Input(button_value.tecla3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
      
        EcraCalc.append(button_value.tecla2);
        Save_Input(button_value.tecla2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
add_ecra_1();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
add_ecra_delete();       
        
     

    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:
        EcraCalc.append(button_value.tecla_tanH);
        Save_Input(button_value.tecla_tanH);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        EcraCalc.append(button_value.tecla_multi_display);
        Save_Input(button_value.tecla_multi);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        EcraCalc.append(button_value.tecla_mod);
        Save_Input(button_value.tecla_mod);            // TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        EcraCalc.append(button_value.tecla_pe);
        Save_Input(button_value.tecla_pe);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        EcraCalc.append(button_value.tecla_log2);
        Save_Input(button_value.tecla_log2);            // TODO add your handling code here:
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed

        EcraCalc.setText(null);// TODO add your handling code here:
        inputs_parciais.clear();
        resultado_anterior="";
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        EcraCalc.append(button_value.tecla_tan);
        Save_Input(button_value.tecla_tan);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        EcraCalc.append(button_value.tecla_log10);
        Save_Input(button_value.tecla_log10);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        EcraCalc.append(button_value.tecla_sin);
        Save_Input(button_value.tecla_sin);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        EcraCalc.append(button_value.teclap);
        Save_Input(button_value.teclap);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        EcraCalc.append(button_value.tecla_soma);
        Save_Input(button_value.tecla_soma);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        EcraCalc.append(button_value.tecla9);
        Save_Input(button_value.tecla9);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        EcraCalc.append(button_value.tecla8);
        Save_Input(button_value.tecla8);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        EcraCalc.append(button_value.tecla7);
        Save_Input(button_value.tecla7);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        EcraCalc.append(button_value.tecla6);
        Save_Input(button_value.tecla6);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        EcraCalc.append(button_value.tecla5);
        Save_Input(button_value.tecla5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        EcraCalc.append(button_value.tecla4);
        Save_Input(button_value.tecla4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        EcraCalc.append(button_value.tecla_div_display);
        Save_Input(button_value.tecla_div);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        // TODO add your handling code here:
         EcraCalc.append(button_value.tecla_sinH);
        Save_Input(button_value.tecla_sinH);
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        jFrame1.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        System.out.print("asdasd");

        JFileChooser fileChooser = new JFileChooser();

        if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            writeListToFile(file,jList1);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                readFileToList(file,jList1);

                // TODO add your handling code here:
            } catch (IOException ex) {
                Logger.getLogger(Main_Layout.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        DefaultListModel model = (DefaultListModel)jList1.getModel();
        int selectedIndex = jList1.getSelectedIndex();
        if (selectedIndex != -1) {
            model.remove(selectedIndex);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        double xmin,xmax;
         System.out.print("Fez sdfsdfo");
        
         if (jTextField2.getText().equals("") || jTextField3.getText().equals("")){
             jLabel5.setVisible(true);
             System.out.print("Fez isto");
         }
         else{
        xmin = Double.parseDouble(jTextField2.getText());
        xmax = Double.parseDouble(jTextField3.getText());

             System.out.print("Fez aquilo");       
            
            try {
                Graphics_Draw.Desenha_Grafico(xmin,xmax,jTextField1.getText());        // TODO add your handling code here:
            } catch (IOException ex) {
                Logger.getLogger(Main_Layout.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        String function=jTextField1.getText();

        jList1.setModel(model);

        System.out.println("------>" + function);
        model.getSize();
        model.addElement(function);
        //model.add(model.getSize(),function);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
add_ecra_enter();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jFrame1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFrame1MouseClicked
int index=0;
         jList1 = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
           index = jList1.locationToIndex(evt.getPoint());
        } else if (evt.getClickCount() == 3) {   // Triple-click
            index = jList1.locationToIndex(evt.getPoint());

        
            
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jFrame1MouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        int index=0;
         jList1 = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
           index = jList1.locationToIndex(evt.getPoint());
        } else if (evt.getClickCount() == 3) {   // Triple-click
            index = jList1.locationToIndex(evt.getPoint());}
        jTextField1.setText((String) jList1.getSelectedValue());
     System.out.println("index:"+ index);
        
    }//GEN-LAST:event_jList1MouseClicked

    private void jPanel4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel4KeyPressed

        

// TODO add your handling code here:
    }//GEN-LAST:event_jPanel4KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        
     Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame2.setBackground(new java.awt.Color(102, 102, 102));
        jFrame2.setForeground(new java.awt.Color(102, 102, 102));
       jFrame2.setSize(550,100); 
jFrame2.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
                  // Set size of frame (in pixels)
        //jFrame1.setJMenuBar(null);
        jFrame2.setVisible(true);
        

// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
          
     Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame3.setBackground(new java.awt.Color(102, 102, 102));
        jFrame3.setForeground(new java.awt.Color(102, 102, 102));
       jFrame3.setSize(550,350); 
jFrame3.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
                  // Set size of frame (in pixels)
        //jFrame1.setJMenuBar(null);
        jFrame3.setVisible(true);
        
        
        
        
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed
       
    
    /**
     * @param args the command line arguments
     */
    
    /**
     *
     * @param file
     * @param args the command line arguments
     */
    public void writeListToFile(File file, JList list ) {
        jList1.setModel(model);
        if(file.exists()) {  
            // check with user via JOptionPane.showConfirmDialog  
            // before overwriting the file.  
            System.out.println("File " + file.getPath() + " exists");  
        }  
        DefaultListModel model = (DefaultListModel)list.getModel();  
        try {  
            BufferedWriter bw = new BufferedWriter(  
                                new OutputStreamWriter(  
                                new FileOutputStream(file)));  
            for(int j = 0; j < model.getSize(); j++) {  
                String line = (String)model.getElementAt(j);  
                bw.write(line, 0, line.length());  
                bw.newLine();  
            }  
            bw.close();  
        } catch(IOException e) {  
            System.out.println("Write error: " + e.getMessage());  
        }             
        
    }  
    
    
    
    
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 
                new Main_Layout().setVisible(true);
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea EcraCalc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
