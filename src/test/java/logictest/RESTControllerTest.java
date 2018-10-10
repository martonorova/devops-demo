package logictest;

import logic.RESTController;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(RESTController.class)
public class RESTControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testRESTSimulationFIFO()throws Exception{

        String inputJson = "{\"algorithmType\":\"FIFO\",\"referredPageIDs\":[1,2,3,4,1,5]}";
        String outputJson = "{\"algorithmType\":\"FIFO\",\"usedFrameNames\":[A,B,C,D,-,A], \"pageFails\":5}";

        assertEquals(outputJson,
                this.mvc.perform(post("/simulate").content(inputJson)).andExpect(status().isOk())
                        .andReturn().getResponse().getContentAsString());
    }



}
