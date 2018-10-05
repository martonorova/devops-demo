package logic;

public class PageTable {
	private char[] referredFrames = new char[100]; //stores the frame referred by each page
	private boolean[] isValid = new boolean[100]; // stores if the referral is valid for each frame
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
			switchAlgorithm.useFrame(referredFrames[id], counter);
			counter++;
			return '-';
		}
		
		pageFails++;
		char frameName = switchAlgorithm.allocate(counter++);
		//a regi bejegyzest ervenyteleniteni kell
		for (int i = 0; i < 100; ++i) {
			if(frameName == referredFrames[i]) {
				isValid[i] = false;
			}
		}
		
		if (frameName != '*') {
			isValid[id] = true;
			referredFrames[id] = frameName;
		}

		return frameName;
	}
	
	public int getPageFails() {
		return pageFails;
	}

	public void setPageFails(int pageFails) {
		this.pageFails = pageFails;
	}

    @Override
    public String toString() {
        return String.format("%s using %s", this.getClass().getSimpleName(), switchAlgorithm.toString());
    }
}
