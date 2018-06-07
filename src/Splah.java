import java.awt.Font;
import javax.swing.*;

public class Splah extends JDialog {

	private JProgressBar progreso;
	private JLabel letrero,inicio,medio,fin;
	
	public Splah()
	{
		iniciar();
		setSize(300,130);
		setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		comenzarHilo();
	}


	private void comenzarHilo()
	{
		Thread hilo = new Thread(new Runnable() {
			
			int x = 0;
				
			@Override
			public void run() {
				try 
				{
					while(x<=100)
					{
						progreso.setValue(x);
						x++;
						Thread.sleep(50);
					}
					dispose();
					Form myform = new Form();
					myform.setVisible(true);
					
				}
				catch (Exception e) 
				{
					System.out.println(e.getMessage());
				}
					
			}
			
		});
		hilo.start();	
	}


	private void iniciar() 
	{
		progreso = new JProgressBar();
		progreso.setBounds(10,50, 280, 20);
		add(progreso);
		
		letrero = new JLabel("Cargando..");
		letrero.setFont(new Font("Arial",Font.BOLD,20));
		letrero.setBounds(80,20,180,30);
		add(letrero);
		
		inicio = new JLabel("0%");
		inicio.setBounds(10, 73, 20, 20);
		add(inicio);
		
		medio = new JLabel("50%");
		medio.setBounds(135, 73, 30, 20);
		add(medio);
		
		fin = new JLabel("100%");
		fin.setBounds(270, 73, 40, 20);
		add(fin);
		
	}	
}
