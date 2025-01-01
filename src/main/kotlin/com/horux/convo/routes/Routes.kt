package com.horux.convo.routes

import com.horux.convo.filters.AuthenticationFilter
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class Routes {

    @Bean
    fun profileRoutes(routeLocatorBuilder: RouteLocatorBuilder, authenticationFilter: AuthenticationFilter) =
        routeLocatorBuilder.routes()
            .route("profile-route") { route ->
                route.path("/api/v1/profiles/**") // Adjust path predicate as needed
//                    .filters { filterSpec ->
//                        filterSpec.filter(authenticationFilter) // Apply the authentication filter
//                    }
                    .uri("http://localhost:8091")
            }
            .build()
    @Bean
    fun securityRoutes(routeLocatorBuilder: RouteLocatorBuilder, authenticationFilter: AuthenticationFilter) =
        routeLocatorBuilder.routes()
            .route("security-route") { route ->
                route.path("/api/v1/public/login/**") // Adjust path predicate as needed
//                    .filters { filterSpec ->
//                        filterSpec.filter(authenticationFilter) // Apply the authentication filter
//                    }
                    .uri("http://localhost:8090")
            }
            .build()

}