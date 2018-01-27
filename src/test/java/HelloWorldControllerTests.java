import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import prv.hjh.boot.Application;
import prv.hjh.boot.controller.SpringBootHelloWorldController;

/**
 * @author 洪家豪
 *         Created by HJH on 2017/10/24.
 */

@SpringBootTest(classes = Application.class)
public class HelloWorldControllerTests {
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new SpringBootHelloWorldController()).build();
    }


    @Test
    public void helloWorldTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/helloWorld").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }

}
