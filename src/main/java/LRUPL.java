public class LRUPL extends SwitchAlgorithm {

	private int maxFrozenTime = 5;

	public LRUPL() {
		
	}
	
	@Override
	public char allocate(int counter) {
		
		char frameName = '*';
		Frame leastRecUsed = null;
		int minTime = Integer.MAX_VALUE;
		for (Frame frame : pageFrameData) {
			if (!(frame.isFrozen() && counter - maxFrozenTime <= frame.getAllocTime()) && frame.getReferTime() < minTime ) {
				minTime = frame.getReferTime();
				leastRecUsed = frame;
			}
		}
		
		if (leastRecUsed != null) {
			leastRecUsed.setReferTime(counter);
			leastRecUsed.setAllocTime(counter);
			leastRecUsed.setFrozen(true);
			frameName = leastRecUsed.getName();
		}
		
		return frameName;
	}
	
	@Override
	public void useFrame(char frameName, int counter) {
		for (Frame frame : pageFrameData) {
			if (frameName == frame.getName()) {
				frame.setReferTime(counter);
				frame.setFrozen(false);
			}
		}
	}
}
