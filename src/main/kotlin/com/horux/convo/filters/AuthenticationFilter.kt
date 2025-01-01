package com.horux.convo.filters

import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import javax.naming.AuthenticationException

@Component
class AuthenticationFilter(private val webClient: WebClient.Builder) : GatewayFilter {

    override fun filter(exchange: ServerWebExchange, chain: GatewayFilterChain): Mono<Void> {
//        val token = exchange.request.headers.getFirst(HttpHeaders.AUTHORIZATION)
//        if (token == null) {
//            exchange.response.statusCode = HttpStatus.UNAUTHORIZED
//            return exchange.response.setComplete()
//        }

        return webClient.build()
            .get()
            .uri("http://localhost:8090/api/v1/public/authenticate")
            .retrieve()
            .onStatus({ it == HttpStatus.UNAUTHORIZED }) {
                Mono.error(AuthenticationException("Unauthorized"))
            }
            .bodyToMono(Void::class.java)
            .then(chain.filter(exchange))
    }
}
