package logic;

import java.util.ArrayList;
import java.util.List;

public class SimulationResult {
    private SwitchAlgorithm.AlgorithmType algorithmType;
    private List<Character> usedFrameNames = new ArrayList<>();
    private int pageFails;


    public void addUsedFrameName(char frameName) {
        usedFrameNames.add(frameName);
    }

    public void setPageFails(int pageFails) {
        this.pageFails = pageFails;
    }

    public List<Character> getUsedFrameNames() {
        return usedFrameNames;
    }

    public int getPageFails() {
        return pageFails;
    }

    public SwitchAlgorithm.AlgorithmType getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(SwitchAlgorithm.AlgorithmType algorithmType) {
        this.algorithmType = algorithmType;
    }
}
