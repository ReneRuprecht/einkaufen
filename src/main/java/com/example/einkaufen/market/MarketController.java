package com.example.einkaufen.market;

import com.example.einkaufen.market.dto.MarketCreateDto;
import com.example.einkaufen.market.request.MarketCreateRequest;
import com.example.einkaufen.market.response.MarketCreateResponse;
import com.example.einkaufen.market.response.MarketGetAllResponse;
import com.example.einkaufen.market.utils.MarketMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/market")
@AllArgsConstructor
public class MarketController {

  private final MarketService marketService;

  @PostMapping
  public ResponseEntity<MarketCreateResponse> save(
      @RequestBody MarketCreateRequest marketCreateRequest) {

    MarketCreateDto marketCreateDto = new MarketCreateDto(marketCreateRequest.name(),
        marketCreateRequest.streetName(), marketCreateRequest.postalCode());

    Market market = marketService.save(marketCreateDto);

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