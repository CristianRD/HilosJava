
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Form extends JFrame implements ActionListener{

	
	boolean corriendo = false;
	static boolean inicio=true;
	
	static int hora=0,min=0,seg=0;
	
	public Form(){
		
		setLayout(null);
		setTitle("Mi cronometro");
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(280, 180);
		iniciarComponentes();
	}
	
	JLabel texto;
	JButton iniciar, parar;
	private void iniciarComponentes() {
		
		texto = new JLabel("00:00:00");
		texto.setBounds(100,5,100,100);
		texto.setFont(new Font("Arial",Font.BOLD,20));
		iniciar = new JButton("inicio");
		iniciar.setBounds(30, 80, 80,30);
		iniciar.addActionListener(this);
		parar = new JButton("parar");
		parar.setBounds(150, 80, 80,30);
		parar.addActionListener(this);
		add(texto);
		add(parar);
		add(iniciar);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==iniciar) 
		{
		
			if(corriendo==false) {
				corriendo = true;
				inicio = true;
				iniciarHilo();
			}
			
		}
		else {
			
			corriendo = false;
			inicio = false;
		}
		
	}
	private void iniciarHilo() {
		
		if(inicio=true) {
			HiloCrono hilo = new HiloCrono(texto);
			hilo.start();
		}
		
	}
}
