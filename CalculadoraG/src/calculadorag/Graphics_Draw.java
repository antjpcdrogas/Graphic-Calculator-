package calculadorag;

import java.awt.Color;
import static java.awt.Color.blue;
import static java.awt.Color.green;
import static java.awt.Color.red;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.apache.commons.io.FileUtils;
import ptolemy.plot.*;
import ptolemy.*;


/**        Log/Log ptplot programme to draw a y = x*x + a
 *        
 */

public class Graphics_Draw {
    @SuppressWarnings("empty-statement")
    public static void Desenha_Grafico(double xmin, double xmax, String function) throws IOException {
       
        File file = new File("C:\\teste.txt");
String string = FileUtils.readFileToString(file);
         int h;
         List<String> merito=new ArrayList();
    
          System.out.println("ESTA AQUI");
          String delims = "[ ,]+";
    //    List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        
           String[] tokens=string.split(delims);
        
    //  merito.add(string.split(delims));
      
           
           
           for(int q=0;q<tokens.length;q++)
               merito.add(tokens[q]);
           
           
      for(h=0;h<merito.size();h++){
        System.out.println(merito.get(h));
       
        }
	Plot plot = new Plot();             // Make a default plot
	//plot.setXLog(true);                 // Set x log axis 
	//plot.setYLog(true);                 // Set y log axis

	//    Add plot the dataset 0
	//    
	double a = 0.0;
         double x,i ;                  // Set x/y values
	   double y ;
        xmin=Math.round(xmin * 100) / 100;
        xmax=Math.round(xmax * 100) / 100;
                                            
        for(int g=0;g<merito.size();g++){
        
	for (i = xmin; i <=xmax; i++) {
	  x = i;                  // Set x/y values
          
          Expression e = new ExpressionBuilder("0")
                
              .variables("x")
                .build()
                .setVariable("x", Double.parseDouble(merito.get(g)));
                              
	   y =(double)Math.round(e.evaluate()*100) /100;
           
	    plot.addPoint(0,x,y,true);  // Add to data 0
            Color[] colors={blue,green};
            plot.setColors(colors);
            
            // plot.addPoint(0,x+5,y+2,true);

	}

        }
	plot.setTitle("Visualizador de Gráficos");      // Set plot title (optional)
	plot.setXLabel("X");         // Set the x/y labels
	plot.setYLabel("Y");
	
	//      Make a frame to display the plot in
        
	PlotFrame frame = new PlotFrame("Visualizador de Gráficos",plot);
	frame.setSize(600,400);              // Set size of frame (in pixels)
        frame.setJMenuBar(null);
	frame.setVisible(true);              // Make frame visible
    }
}