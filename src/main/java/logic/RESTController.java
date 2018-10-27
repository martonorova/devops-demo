package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTController {

    private final Simulator simulator = new Simulator();

    @Autowired
    private SimulationRepository simulationRepository;


    @PostMapping("/simulate")
    public SimulationResult simulate(@RequestBody SimulationParameters parameters) {
        SimulationResult result = simulator.runSimulation(parameters);
        simulator.resetPageTable(parameters.getAlgorithmType());

        saveSimulationRecord(parameters, result);

        return result;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Simulation> getAllSimulations() {
        return simulationRepository.findAll();
    }


    private void saveSimulationRecord(SimulationParameters parameters, SimulationResult result) {

        StringBuilder sbReferred = new StringBuilder();
        parameters.getReferredPageIDs().forEach(integer -> {
            sbReferred.append(integer).append(",");
        });
        String referredPageIds = sbReferred.toString();

        StringBuilder sbUsedFrames = new StringBuilder();
        result.getUsedFrameNames().forEach(character -> {
            sbUsedFrames.append(character).append(",");
        });
        String usedFrames = sbUsedFrames.toString();

        Simulation simulation = new Simulation();
        simulation.setAlgorithmType(parameters.getAlgorithmType());
        simulation.setReferredPageIDs(referredPageIds);
        simulation.setUsedFrameNames(usedFrames);
        simulation.setPageFails(result.getPageFails());

        simulationRepository.save(simulation);
    }

}
