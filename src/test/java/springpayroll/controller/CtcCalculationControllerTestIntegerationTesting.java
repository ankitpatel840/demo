package springpayroll.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import springpayroll.impl.CtcControllerImpl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CtcCalculationController.class)
@ContextConfiguration(classes =CtcControllerImpl.class)
class CtcCalculationControllerTestIntegerationTesting
{
  @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    @Before
   public void setUp(WebApplicationContext context)
{
      this.mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
}


@Test
public void postTest() throws Exception {
    //    CtcData ctcData=new CtcData("123","Gunjan");


    MockHttpServletResponse response=mockMvc.perform(post("/ctc/")).andReturn().getResponse();

    System.out.println("asfe");
    System.out.println(response.getStatus());
    assertThat(response.getStatus(),is(HttpStatus.CREATED.value()));


}
}