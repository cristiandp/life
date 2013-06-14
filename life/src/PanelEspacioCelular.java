import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelEspacioCelular extends JPanel implements Runnable{

	JButton boton;
	MouseListener e;
	EspacioCelular ec;
	boolean estado= false;
	boolean ctrl = true;
	
	public PanelEspacioCelular(int alto, int ancho) {
		setPreferredSize(new Dimension(ancho, alto));
		ec = new EspacioCelular(alto, ancho);
		setBackground(Color.black);
		setForeground(Color.DARK_GRAY);
		
//		for (int i = 0; i < 35; i++){
//			for (int j = 0; j < 35; j++){
//				boton = new JButton();
//				boton.setOpaque(false);
//				boton.setMinimumSize(new Dimension(40,40));
//				add(boton);
//			}
//		}
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK)
					ec.setViva(e.getX(), e.getY());
					else
					ec.setMoribunda(e.getX(), e.getY());
					repaint();
				
			}
		});
		
		addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
					int movement = e.getWheelRotation();
					
				if(movement <=0){
					ec.setZoom(ec.getZoom()+2);
				}else{
					ec.setZoom(ec.getZoom()-2);
				}
					
				
				
				repaint();
				
			}
		});
		
		
		

		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			if((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK)
			ec.setViva(e.getX(), e.getY());
			else
			ec.setMoribunda(e.getX(), e.getY());
			repaint();
			}
		});
		
		
		
		
		
		
	
	}
	
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ec.paint(g, getForeground());
	}
	
	
	public void reiniciar(){
		ec.reiniciar();
		repaint();
	}
	
	public void setEstado(boolean estado){
		this.estado = estado;
	}
	
	public void nextFase(){
		ec.nextFase();
		repaint();
	}
	
	
	public void setZoom(int zoom){
		ec.setZoom(zoom);
		repaint();
	}
	
	public void setAleatorias(){
		ec.setAleatorias();
		repaint();
	}
	
	public int getZoom(){
		return ec.getZoom();
	}
	

	
	
	

	@Override
	public void run() {
		while (true){
			
		try {
			Informacion.label.setText(Integer.toString(ec.getEstado()));
		
			while(estado){
				ec.nextFase();
				repaint();
				Informacion.label.setText(Integer.toString(ec.getEstado()));
				Thread.sleep(10);
		
		}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
	}
	
	
}