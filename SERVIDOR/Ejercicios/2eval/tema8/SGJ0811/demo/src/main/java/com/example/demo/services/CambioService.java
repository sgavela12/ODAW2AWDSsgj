package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.CambiaData;

import reactor.core.publisher.Mono;

@Service
public class CambioService {
    @Autowired
    WebClient webClient;

    public Mono<CambiaData> obtenerTasaCambio(String monedaOrigen, String monedaDestino) {
        String url = "https://api.frankfurter.app/latest?from=" + monedaOrigen + "&to=" + monedaDestino;
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(CambiaData.class);
    }

    public Double calcularImporteCambiado(String monedaOrigen, String monedaDestino, Double importe) {
        CambiaData cambiaData = obtenerTasaCambio(monedaOrigen, monedaDestino).block();
        Float tasaCambio = cambiaData.getRates().get(monedaDestino);
        return importe * tasaCambio;
    }

}
