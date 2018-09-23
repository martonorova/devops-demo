package src;


public class PageTable {
	private char[] frames = new char[100];
	private boolean[] isValid = new boolean[100];
	private int counter = 1;
	private SwitchAlgorithm switchAlgorithm;
	private int pageFails = 0;
	
	public PageTable(SwitchAlgorithm switchAlgorithm) {
		this.switchAlgorithm = switchAlgorithm;
		
		for (int i = 0; i < 100; ++i) {
			isValid[i] = false;
		}
	}
	
	public char referPage(int id) {
		if (isValid[id]) {
			switchAlgorithm.useFrame(frames[id], counter);
			counter++;
			return '-';
		}
		
		pageFails++;
		char frameName = switchAlgorithm.allocate(counter++);
		//a regi bejegyzest ervenyteleniteni kell
		for (int i = 0; i < 100; ++i) {
			if(frameName == frames[i]) {
				isValid[i] = false;
			}
		}
		
		if (frameName != '*') {
			isValid[id] = true;
			frames[id] = frameName;
		}
		
		
		
		return frameName;
	}
	
	public int getPageFails() {
		return pageFails;
	}

	public void setPageFails(int pageFails) {
		this.pageFails = pageFails;
	}
	
}
