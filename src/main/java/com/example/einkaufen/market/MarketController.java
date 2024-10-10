package com.example.einkaufen.market;

import com.example.einkaufen.market.request.MarketCreateRequest;
import com.example.einkaufen.market.response.MarketCreateResponse;
import com.example.einkaufen.market.response.MarketGetAllResponse;
import com.example.einkaufen.market.utils.MarketMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/market")
@AllArgsConstructor
public class MarketController {

    private final MarketService marketService;

    @PostMapping
    public ResponseEntity<MarketCreateResponse> save(@RequestBody MarketCreateRequest marketCreateRequest) {

        Market market = marketService.save(marketCreateRequest);

        return new ResponseEntity<>(
                MarketMapper.toMarketCreateResponse(market),
                HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<MarketGetAllResponse> findAll() {

        List<Market> markets = marketService.findAll();

        return new ResponseEntity<>(
                new MarketGetAllResponse(markets),
                HttpStatus.OK
        );

    }
}