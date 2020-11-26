package apap.tutorial.traveloke.service;


import apap.tutorial.traveloke.rest.Setting;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
public class APIRestServiceImpl implements APIRestService{
    private final WebClient webClient;


    public APIRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .defaultHeader("x-rapidapi-key", "eab73620e4mshebb6112ebe834dbp198ad4jsnec560de169c1")
                .defaultHeader("x-rapidapi-host", "hotels-com-free.p.rapidapi.com")
                .defaultHeader("useQueryString", "true")
                .baseUrl(Setting.cityUrl).build();
    }


    @Override
    public Mono<String> find(String name) {
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("query", name);
        data.add("locale", "en_us");
        return this.webClient.get().uri(uriBuilder -> uriBuilder.queryParams(data).build()).retrieve().bodyToMono(String.class);
    }

}
