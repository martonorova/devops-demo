package logic;

import java.util.ArrayList;
import java.util.List;

public class SimulationParameters {
    private SwitchAlgorithm.AlgorithmType algorithmType;
    private List<Integer> referredPageIDs;

    public SimulationParameters(SwitchAlgorithm.AlgorithmType algorithmType, List<Integer> referredPageIDs) {
        this.algorithmType = algorithmType;
        this.referredPageIDs = referredPageIDs;
    }

    public SimulationParameters(SwitchAlgorithm.AlgorithmType algorithmType) {
        this.algorithmType = algorithmType;
        referredPageIDs = new ArrayList<>();
    }

    public SwitchAlgorithm.AlgorithmType getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(SwitchAlgorithm.AlgorithmType algorithmType) {
        this.algorithmType = algorithmType;
    }

    public List<Integer> getReferredPageIDs() {
        return referredPageIDs;
    }

    public void setReferredPageIDs(List<Integer> referredPageIDs) {
        this.referredPageIDs = referredPageIDs;
    }

    public void addReferredPageID(int pageID) {
        referredPageIDs.add(pageID);
    }
}
