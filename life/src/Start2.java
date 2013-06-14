import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Start2 extends JFrame{
	PanelEspacioCelular pec = new PanelEspacioCelular(300, 300);

	public Start2() {
		setMinimumSize(new Dimension(637, 665));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Game Of Live V2.0 BETA");
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 603, 588);
		getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(pec);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmClear = new JMenuItem("New Matrix");
		mntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pec.reiniciar();
			}
		});
		mnFile.add(mntmClear);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Random Cells");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pec.setAleatorias();
			}
		});
		mnFile.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmJghj = new JMenuItem("Start Generation");
		mntmJghj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pec.setEstado(true);
			}
		});
		mnFile.add(mntmJghj);
		
		JMenuItem mntmStopGeneration = new JMenuItem("Stop Generation");
		mntmStopGeneration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pec.setEstado(false);
			}
		});
		mnFile.add(mntmStopGeneration);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Matrix");
		menuBar.add(mnEdit);
		
		JMenuItem mntmOpenMatrix = new JMenuItem("Open Matrix");
		mnEdit.add(mntmOpenMatrix);
		
		JMenuItem mntmLoadMatrix = new JMenuItem("Load Matrix");
		mnEdit.add(mntmLoadMatrix);
		
		JMenu mnPreferedMatrix = new JMenu("Prefered Matrix");
		mnEdit.add(mnPreferedMatrix);
		
		JMenuItem mntmOscilator = new JMenuItem("Oscilator");
		mnPreferedMatrix.add(mntmOscilator);
		
		JSeparator separator_2 = new JSeparator();
		mnEdit.add(separator_2);
		
		JMenuItem mntmZoom = new JMenuItem("Zoom +");
		mntmZoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pec.setZoom(2);
			}
		});
		mnEdit.add(mntmZoom);
		
		JMenuItem mntmZoom_1 = new JMenuItem("Zoom  -");
		mnEdit.add(mntmZoom_1);
		
		
		
		new Thread (pec).start();
		
	}
	
	public static void main(String[] args){
		new Start2().setVisible(true);
		new Informacion().setVisible(true);
	}
}
