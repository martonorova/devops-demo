package logic;

import java.util.HashMap;
import java.util.Map;

public class Simulator {
    private Map<SwitchAlgorithm.AlgorithmType, PageTable> pageTableMap = new HashMap<>();

    public Simulator() {
        initPageTables();
    }

    public SimulationResult runSimulation(SimulationParameters parameters) {
        SimulationResult result = new SimulationResult();
        result.setAlgorithmType(parameters.getAlgorithmType());

        PageTable pageTableToUse = pageTableMap.get(parameters.getAlgorithmType());

        parameters.getReferredPageIDs().forEach(referredPageID -> {
            result.addUsedFrameName(pageTableToUse.referPage(referredPageID));
        });

        result.setPageFails(pageTableToUse.getPageFails());

        return result;
    }

    private void initPageTables() {
        pageTableMap.put(SwitchAlgorithm.AlgorithmType.FIFO,
                new PageTable(new FIFO()));
        pageTableMap.put(SwitchAlgorithm.AlgorithmType.LRU,
                new PageTable(new LRU()));
        pageTableMap.put(SwitchAlgorithm.AlgorithmType.LRUPL,
                new PageTable(new LRUPL()));
    }

}
