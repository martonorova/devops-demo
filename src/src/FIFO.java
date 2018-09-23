package src;

public class FIFO extends SwitchAlgorithm {
	
	public FIFO() {
		super();
	}
	
	@Override
	public char allocate(int counter)/* throws Exception */{
		char frameName = '*';
		int minTime = 100000;
		Frame oldest = null;
		for (Frame var : pageFrameData) {
			if (var.getAllockTime() < minTime) {
				minTime = var.getAllockTime();
				oldest = var;
			}
		}
		if (oldest != null) {
			oldest.setAllockTime(counter);
			frameName = oldest.getName();
			
		}/* else {
			throw new Exception("Every frame younger than " + minTime);
		}*/
		
		
		return frameName;
	}
	
	@Override
	public void useFrame(char frameName, int counter) {}
}
