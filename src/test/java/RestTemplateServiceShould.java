import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RestTemplateServiceShould {

    //https://dmunozfer.es/tutorial-jenkins-2-configuracion-pipeline/
    private static final String URL = "http://private-5e839-jonatangarcia.apiary-mock.com/employee/1";

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void returnResponseWhenIsPossibleConnectWithTheAPI(){
        Employee employee;
        RestTemplate restTemplate = new RestTemplate();

        RestTemplateService restTemplateService = new RestTemplateService(URL, restTemplate);
        employee = restTemplateService.getOneEmployee();

        assertThat(employee.getName(),is(equalTo("Jonatan")));
        assertThat(employee.getFirstName(),is(equalTo("Garcia")));
    }

    @Test
    public void returnResponseWhenIsPossibleConnectWithTheAPIWithMock(){

        Employee expectedEmployee = createEmployee();

        when(restTemplate.getForObject(URL,Employee.class)).thenReturn(expectedEmployee);

        RestTemplateService restTemplateService = new RestTemplateService(URL,this.restTemplate);
        Employee actualEmployee = restTemplateService.getOneEmployee();

        assertThat(actualEmployee.getName(),is(equalTo("Jonatan")));
        assertThat(actualEmployee.getFirstName(),is(equalTo("Garcia")));

    }

    private Employee createEmployee() {
        Employee employee = new Employee();
        employee.setName("Jonatan");
        employee.setFirstName("Garcia");
        return employee;
    }


}
