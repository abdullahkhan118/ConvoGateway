package com.horux.convo.routes

import com.horux.convo.filters.AuthenticationFilter
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Component
class SecurityRoutes {

    @Bean
    fun routes(routeLocatorBuilder: RouteLocatorBuilder, authenticationFilter: AuthenticationFilter) =
        routeLocatorBuilder.routes()
            .route("profiles-route") { route ->
                route.path("/api/v1/profiles/**") // Adjust path predicate as needed
//                    .filters { filterSpec ->
//                        filterSpec.filter(authenticationFilter) // Apply the authentication filter
//                    }
                    .uri("http://localhost:8091/api/v1/profiles")
            }
            .build()

}