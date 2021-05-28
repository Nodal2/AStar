package vue;

public class Paint extends Thread{
	
	private Display display;
	
	public Paint(Display display) {
		this.display = display;
	}
	
	@Override
	public void run() {
		while(true) {
			this.display.repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	

}
