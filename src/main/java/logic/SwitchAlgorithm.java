package logic;

import java.util.ArrayList;

public abstract class SwitchAlgorithm {

	public enum AlgorithmType {
	    FIFO,
        LRU,
        LRUPL
    }

    protected AlgorithmType algorithmType;


	protected ArrayList<Frame> pageFrameData = new ArrayList<>();
	
	public SwitchAlgorithm() {
		pageFrameData.add(new Frame('A'));
		pageFrameData.add(new Frame('B'));
		pageFrameData.add(new Frame('C'));
		pageFrameData.add(new Frame('D'));
	}
	

	public abstract void useFrame(char frameName, int counter);
	public abstract char allocate(int counter) /*throws Exception*/;
	public abstract AlgorithmType getType();

	public ArrayList<Frame> getPageFrameData() {
		return pageFrameData;
	}
	
	
}
