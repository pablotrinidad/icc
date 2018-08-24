/* -*- jde -*- */
/* <VistaRelojAnalogico.java> */

package icc.practica1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase para representar gráficamente un Reloj analógico.<p>
 *
 * Esta clase implementa la interfaz VistaReloj, así que sabe como dibujarse
 * en la pantalla, y esperar un segundo.
 *
 * La funcionalidad que dibuja el reloj en la pantalla está dentro de una clase
 * privada.
 *
 * @author Canek
 */
public class VistaRelojAnalogico implements VistaReloj {

    /** Nuestro reloj (la maquinaria). */
    private Reloj        reloj;
    /** Lienzo para dibujar el reloj. */
    private PanelDeReloj panel;
    
    /**
     * Construye una vista de reloj analógico con un tamaño determinado de
     * 500x500.
     * @param r el Reloj dentro de esta vista. gráfica.
     */
    public VistaRelojAnalogico(Reloj r) {
	this(r,500,500);
    }

    /**
     * Construye un gráfico de reloj con un tamaño arbitrario.
     * @param r el Reloj dentro de esta parte gráfica.
     * @param x el número de pixeles de ancho del reloj.
     * @param y el número de pixeles de largo del reloj.
     */
    public VistaRelojAnalogico(Reloj r, int x, int y) {
	reloj = r;
	JFrame frame;
	
	frame = new JFrame("Reloj Analógico");
	frame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		    System.exit(0);
		}
	    });

	Container cont = frame.getContentPane();
	
	panel = new PanelDeReloj(r);
	cont.setLayout(new BoxLayout(cont,BoxLayout.Y_AXIS));
        cont.add(panel, BorderLayout.CENTER);

        frame.setSize(new Dimension(x, y));
	frame.setVisible(true);
    }

    /**
     * Regresa el Reloj contenido en esta vista.
     * @return el Reloj contenido en esta vista.
     */
    public Reloj getReloj() {
	return reloj;
    }

    /**
     * Actualiza la vista de acuerdo a los valores del Reloj.
     */
    public void actualiza() {
	panel.pinta();
    }

    /**
     * Detiene la ejecución del programa el número de segundos que se le pide.
     * @param segundos el número de segundos a esperar.
     */
    public void espera(int segundos) {
	try {
	    Thread.sleep(segundos*1000);
	} catch(InterruptedException e) {
	    e.printStackTrace();
	    System.exit(1);
	}
    }
}

/**
 * Utilizamos una clase heredera de la clase <code>JPanel</code> para
 * pintar en la pantalla. Como esta clase no es utilizada por ninguna otra
 * además de la clase <code>RelojAnalogico</code>, la hacemos privada a
 * ésta al no incluir el modificador <code>public</code>.
 */
class PanelDeReloj extends JPanel {

    private Reloj reloj;

    /**
     * Para pintar las horas, necesitamos el Reloj.
     * @param r el Reloj.
     */
    public PanelDeReloj(Reloj r) {
	reloj = r;
        setBackground(Color.white);
        setForeground(Color.black);
        setBorder(BorderFactory.createCompoundBorder(
		      BorderFactory.createRaisedBevelBorder(),
		      BorderFactory.createLoweredBevelBorder()));
    }

    /**
     * Pinta las manecillas utilizando la función de la clase de
     * cual es heredera.
     */
    public void pinta() {
	update(getGraphics());
    }

    /**
     * Pinta sobre la pantalla las manecillas.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int ancho = getWidth();
        int alto  = getHeight();
	int tiempo;

	int horas, minutos, segundos;

	horas    = reloj.getHora();
	minutos  = reloj.getMinuto();
	segundos = reloj.getSegundo();

	g.drawOval((ancho-(int)(ancho*0.8))/2,(alto-(int)(alto*0.8))/2,
		   (int)(ancho*0.8),(int)(alto*0.8));

	dibujaRayitas(g);

	tiempo = (segundos-15)*(6);
	g.setColor(Color.red);
	dibujaManecilla(g,tiempo,alto,ancho,0.7);
	tiempo = (minutos-15)*(6);
	g.setColor(Color.green);
	dibujaManecilla(g,tiempo,alto,ancho,0.6);
	tiempo = (horas*5-15)*(6);
	g.setColor(Color.blue);
	dibujaManecilla(g,tiempo,alto,ancho,0.4);
    }

    /**
     * Dibuja las manecillas una por una.
     */
    private void dibujaManecilla(Graphics g, int tiempo, int alto,
				  int ancho, double l) {
	double x = Math.cos(Math.toRadians((double)tiempo));
	double y = Math.sin(Math.toRadians((double)tiempo));
	g.drawLine(ancho/2, alto/2,
		   (int)(x*l*ancho)/2+ancho/2,
		   (int)(y*l*alto)/2+alto/2);
    }

    /**
     * Dibuja las rayitas que definen las horas y los minutos.
     */
    private void dibujaRayitas(Graphics g) {
	int ancho = getWidth();
        int alto  = getHeight();
	int i;
	
	for(i = 0; i < 60; i++) {
	    double x = Math.cos(Math.toRadians((double)(i*6)));
	    double y = Math.sin(Math.toRadians((double)(i*6)));
	    g.drawLine((int)(x*0.77*ancho)/2+ancho/2,
		       (int)(y*0.77*alto)/2+alto/2,
		       (int)(x*0.8*ancho)/2+ancho/2,
		       (int)(y*0.8*alto)/2+alto/2);
	}
	for(i = 0; i < 12; i++) {
	    double x = Math.cos(Math.toRadians((double)(i*30)));
	    double y = Math.sin(Math.toRadians((double)(i*30)));
	    g.drawLine((int)(x*0.73*ancho)/2+ancho/2,
		       (int)(y*0.73*alto)/2+alto/2,
		       (int)(x*0.8*ancho)/2+ancho/2,
		       (int)(y*0.8*alto)/2+alto/2);
	}
    }
}

/* </VistaRelojAnalogico.java> */
