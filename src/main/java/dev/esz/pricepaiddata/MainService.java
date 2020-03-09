package dev.esz.pricepaiddata;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainService {
    private static final String URL = "http://prod.publicdata.landregistry.gov.uk.s3-website-eu-west-1.amazonaws.com/pp-monthly-update-new-version.csv";

    private List<PricePaid> getData() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.execute(URL, HttpMethod.GET, null, clientHttpResponse -> {
            InputStreamReader reader = new InputStreamReader(clientHttpResponse.getBody());
            CsvToBean<PricePaid> csvToBean = new CsvToBeanBuilder<PricePaid>(reader)
                    .withType(PricePaid.class)
                    .withSeparator(',')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.stream().collect(Collectors.toList());
        });
    }

    private boolean isBetween(PricePaid pricePaid, LocalDate from, LocalDate to) {
        LocalDate date = pricePaid.getDateOfTransfer();
        return date.isAfter(from) && date.isBefore(to);
    }

    public List<PricePaid> getAll() {
        return getData();
    }

    public PricePaid getById(String id) throws PriceNotFoundException {
        return getData().stream()
                .filter(pricePaid -> pricePaid.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new PriceNotFoundException("Item not found!"));
    }

    public List<PricePaid> getBetween(LocalDate from, LocalDate to) {
        return getData().stream()
                .filter(pricePaid -> isBetween(pricePaid, from, to))
                .collect(Collectors.toList());
    }
}
