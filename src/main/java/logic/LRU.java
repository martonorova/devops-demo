package logic;

public class LRU extends SwitchAlgorithm {

	public LRU() {
		super();
		algorithmType = AlgorithmType.LRU;
	}
	
	@Override
	public char allocate(int counter) {
		char frameName = '*';
		Frame leastRecUsed = null;
		int minTime = Integer.MAX_VALUE;
		for (Frame frame : pageFrameData) {
			if (frame.getReferTime() < minTime) {
				minTime = frame.getReferTime();
				leastRecUsed = frame;
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
		for (Frame frame : pageFrameData) {
			if (frameName == frame.getName()) {
				frame.setReferTime(counter);
			}
		}
		
	}

	@Override
	public AlgorithmType getType() {
		return algorithmType;
	}

	@Override
	public String toString() {
		return "LRU";
	}
}
