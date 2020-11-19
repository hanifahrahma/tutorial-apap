package apap.tutorial.traveloke.service;

import reactor.core.publisher.Mono;

public interface APIRestService {
    Mono<String> find(String name);
}
