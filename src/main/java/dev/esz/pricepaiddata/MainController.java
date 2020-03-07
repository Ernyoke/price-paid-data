package dev.esz.pricepaiddata;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/all")
public class MainController {
    private static final String URL = "http://prod.publicdata.landregistry.gov.uk.s3-website-eu-west-1.amazonaws.com/pp-monthly-update-new-version.csv";

    @GetMapping
    public List<PricePaid> getDoc() {
        RestTemplate restTemplate = new RestTemplate();

        List<PricePaid> pricePaidList = restTemplate.execute(URL, HttpMethod.GET, null, clientHttpResponse -> {
            InputStreamReader reader = new InputStreamReader(clientHttpResponse.getBody());
            CsvToBean<PricePaid> csvToBean = new CsvToBeanBuilder<PricePaid>(reader)
                    .withType(PricePaid.class)
                    .withSeparator(',')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.stream().collect(Collectors.toList());
        });

        return pricePaidList;
    }
}
