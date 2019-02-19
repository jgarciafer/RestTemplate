import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class RestTemplateServiceShould {


    private static final String URL = "http://private-5e839-jonatangarcia.apiary-mock.com/employee/1";

    @Test
    public void returnResponseWhenIsPossibleConnectWithTheAPI(){
        Employee employee;
        RestTemplate restTemplate = new RestTemplate();

        RestTemplateService restTemplateService = new RestTemplateService(URL, restTemplate);
        employee = restTemplateService.getOneEmployee();

        assertThat(employee.getName(),is(equalTo("Jonatan")));
        assertThat(employee.getFirstName(),is(equalTo("Garcia")));
    }


}
