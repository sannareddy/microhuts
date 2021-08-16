package in.codehut.gateway.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
@Component
public class GPreFilter implements GlobalFilter{
	private Logger logger = LogManager.getLogger(GPreFilter.class);
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("******************Pre Filter******************");
		return chain.filter(exchange);
	}
}
