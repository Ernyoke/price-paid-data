package dev.esz.pricepaiddata;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MainController {
    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/all")
    public List<PricePaid> getAll() {
        return mainService.getAll();
    }

    @GetMapping("/id/{id}")
    public PricePaid getById(@PathVariable("id") String id) throws Exception {
        return mainService.getById(id);
    }

    @GetMapping("/between/{from}/{to}")
    public List<PricePaid> getBetween(@PathVariable("from") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,
                                      @PathVariable("to") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to) {
        return mainService.getBetween(from, to);
    }

    @ExceptionHandler(value = PriceNotFoundException.class)
    public ResponseEntity exceptionHandler() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
