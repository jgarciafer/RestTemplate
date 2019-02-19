import org.springframework.web.client.RestTemplate;

public class RestTemplateService {
    private String url;
    private RestTemplate restemplate;

    public RestTemplateService(String url, RestTemplate restemplate) {
        this.url = url;
        this.restemplate = restemplate;
    }

    public Employee getOneEmployee() {
        return this.restemplate.getForObject(url,Employee.class);
    }
}
