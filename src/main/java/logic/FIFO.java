package logic;

public class FIFO extends SwitchAlgorithm {
	
	public FIFO() {
		super();
	}
	
	@Override
	public char allocate(int counter)/* throws Exception */{
		char frameName = '*';
		int minTime = Integer.MAX_VALUE;
		Frame oldest = null;
		for (Frame frame : pageFrameData) {
			if (frame.getAllocTime() < minTime) {
				minTime = frame.getAllocTime();
				oldest = frame;
			}
		}

		if (oldest != null) {
            oldest.setAllocTime(counter);
            frameName = oldest.getName();

        } else {
            throw new IllegalArgumentException("Each frame has maximum allocation time.");
        }

		return frameName;
	}
	
	@Override
	public void useFrame(char frameName, int counter) {}

	@Override
	public String toString() {
		return "FIFO";
	}
}
