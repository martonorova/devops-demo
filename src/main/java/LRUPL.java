public class LRUPL extends SwitchAlgorithm {
	public LRUPL() {
		
	}
	
	@Override
	public char allocate(int counter) {
		
		char frameName = '*';
		Frame leastRecUsed = null;
		int minTime = 10000;
		for (Frame var : pageFrameData) {
			if (!(var.isFrozen() && counter - 5 <= var.getAllockTime()) && var.getReferTime() < minTime ) {
				minTime = var.getReferTime();
				leastRecUsed = var;
			}
		}
		
		if (leastRecUsed != null) {
			leastRecUsed.setReferTime(counter);
			leastRecUsed.setAllockTime(counter);
			leastRecUsed.setFrozen(true);
			frameName = leastRecUsed.getName();
		}
		
		return frameName;
	}
	
	@Override
	public void useFrame(char frameName, int counter) {
		for (Frame var : pageFrameData) {
			if (frameName == var.getName()) {
				var.setReferTime(counter);
				var.setFrozen(false);
			}
		}
	}
}
