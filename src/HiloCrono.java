import javax.swing.JLabel;

public class HiloCrono extends Thread {
	
	JLabel label;
	
	
	public HiloCrono(JLabel lbl){
		this.label = lbl;
	}
	
	public void run() {
		try {
			
			int x=0;
			
			while(Form.inicio==true) {
				Thread.sleep(100);
				ejecutarCronometro(x);
				x++;
			}
			
		} catch (Exception e) {
			System.out.println("Excepcion en el hilo "+ e.getMessage());
		}
			
	}


	private void ejecutarCronometro(int x) {
		System.out.println(x+""+Thread.currentThread().getName());
		
		Form.seg++;
		
		String txtseg="",txtmin="",txthor="";
		
		if(Form.seg>59) {
			Form.seg = 0;
			Form.min++;
			
			if(Form.min>59) {
				Form.min=0;
				Form.hora++;
			}
		}
		
		if (Form.seg<=9) {
			txtseg = "0"+Form.seg;
		}else {
			txtseg =""+Form.seg;
		}
		
		if (Form.min<=9) {
			txtmin = "0"+Form.min;
		}else {
			txtmin =""+Form.min;
		}
		
		if (Form.hora<=9) {
			txthor = "0"+Form.hora;
		}else {
			txthor =""+Form.hora;
		}
		
		String reloj = txthor+":"+txtmin+":"+txtseg;
		
		label.setText(reloj);
	}
}
