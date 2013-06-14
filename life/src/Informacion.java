import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Color;


public class Informacion extends JFrame {
	static JLabel label = new JLabel("0");
	public Informacion() {
		setBackground(Color.WHITE);
		setMinimumSize(new Dimension(271, 100));
		getContentPane().setLayout(null);
		
		JLabel lblCelulasVivas = new JLabel("Celulas Vivas");
		lblCelulasVivas.setBounds(10, 26, 89, 14);
		getContentPane().add(lblCelulasVivas);
		
		
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(136, 26, 117, 14);
		getContentPane().add(label);
	}
	
	public void actualizarVivas(int n){
		label.setText(Integer.toString(n));
	}
}
