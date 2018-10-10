package logic;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

    private final Simulator simulator = new Simulator();


    @PostMapping("/simulate")
    SimulationResult simulate(@RequestBody SimulationParameters parameters) {
        SimulationResult result = simulator.runSimulation(parameters);
        simulator.resetPageTable(parameters.getAlgorithmType());

        return result;
    }

}
