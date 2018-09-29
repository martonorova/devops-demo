public class LRU extends SwitchAlgorithm {
	public LRU() {
		super();
		
	}
	
	@Override
	public char allocate(int counter) {
		char frameName = '*';
		Frame leastRecUsed = null;
		int minTime = 10000;
		for (Frame var : pageFrameData) {
			if (var.getReferTime() < minTime) {
				minTime = var.getReferTime();
				leastRecUsed = var;
			}
		}
		
		if (leastRecUsed != null) {
			leastRecUsed.setReferTime(counter);
			frameName = leastRecUsed.getName();
		}
		
		return frameName;
	}
	
	@Override
	public void useFrame(char frameName, int counter) {
		for (Frame var : pageFrameData) {
			if (frameName == var.getName()) {
				var.setReferTime(counter);
			}
		}
		
	}
}
