package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards", url = "http://cards:9000", fallback = CardsFallback.class)     // url = "http://cards:9000" causes that there is no load balancing during call cards service.
public interface CardsFeignClient {

    @GetMapping(value = "/api/fetch", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CardsDto> fetchCardDetails(
            @RequestHeader ("eazybank-correlation-id") String correlationId,
            @RequestParam String mobileNumber);
}
