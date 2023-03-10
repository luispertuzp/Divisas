package conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Divisas {

	private JFrame frame;
	private JSlider sldValor;
	double valor=0;
	private JLabel lblValor;
	private JLabel lblDe;
	private JLabel lblA;
	private JComboBox cboDe;
	private JComboBox cboA;
	private JLabel lblResultado;
	String de="", a="";
	double aMoneda = 0.0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Divisas window = new Divisas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Divisas() {
		initialize();
	}

	public void convertirDivisa() {
		
		switch(de) {
		case "EUR":
			if(a.equals("USD")) {
				aMoneda = (1.06*valor);
			}else if(a.equals("COP")) {
				aMoneda = (5.021*valor);
			}else {
				aMoneda = valor;
			}
				
			break;	
			 
		/*case "USD":
			if(a.equals("EUR")) {
				aMoneda = (0.95*valor);
			}else if(a.equals("COP")) {
				aMoneda = (4.747*valor);
			}else {
				aMoneda = valor;
			}
					
			break;	
		
		case "COP":
			if(a.equals("USD")) {
				aMoneda = (0.00021*valor);
			}else if(a.equals("EUR")) {
				aMoneda = (0.00020*valor);
			}else {
				aMoneda = valor;
			}
					
			break;	*/		
				
		}
			
		lblResultado.setText("$ " + valor+" "+ de +" -> " + aMoneda + " $ " + a );
		
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("CONVERSOR DE DIVISAS");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CANTIDAD");
		lblNewLabel.setBounds(21, 26, 69, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblValor = new JLabel("1");
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblValor.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblValor.setBounds(348, 34, 69, 57);
		frame.getContentPane().add(lblValor);
		
		lblResultado = new JLabel("1");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblResultado.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblResultado.setBounds(21, 156, 396, 57);
		frame.getContentPane().add(lblResultado);
		
		
		JSlider sldValor = new JSlider();
		sldValor.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				valor=sldValor.getValue();
				lblValor.setText("" + valor);
				convertirDivisa();
				
			}
		});
		sldValor.setValue(1);
		sldValor.setFocusTraversalKeysEnabled(false);
		sldValor.setFocusable(false);
		sldValor.setPaintTicks(true);
		sldValor.setMinorTickSpacing(1);
		sldValor.setMinimum(1);
		sldValor.setFocusTraversalPolicyProvider(true);
		sldValor.setBounds(21, 51, 317, 26);
		frame.getContentPane().add(sldValor);
		
		lblDe = new JLabel("DE");
		lblDe.setBounds(21, 105, 33, 22);
		frame.getContentPane().add(lblDe);
		
		lblA = new JLabel("A");
		lblA.setBounds(243, 105, 19, 22);
		frame.getContentPane().add(lblA);
		
		cboDe = new JComboBox();
		cboDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				de=cboDe.getSelectedItem().toString();
				convertirDivisa();
			}
		});
		cboDe.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "COP"}));
		cboDe.setBounds(51, 105, 84, 22);
		frame.getContentPane().add(cboDe);
		
		cboA = new JComboBox();
		cboA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a=cboA.getSelectedItem().toString();
				convertirDivisa();
				
			}
			
		});
		cboA.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "COP"}));
		cboA.setBounds(265, 105, 73, 22);
		frame.getContentPane().add(cboA);
		
		
	
	}
}
