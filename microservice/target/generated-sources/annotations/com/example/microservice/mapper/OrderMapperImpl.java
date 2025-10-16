package com.example.microservice.mapper;

import com.example.microservice.dto.OrderDto;
import com.example.microservice.entity.Order;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-16T00:16:52-0600",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( order.getId() );
        orderDto.setUserId( order.getUserId() );
        orderDto.setOrderNumber( order.getOrderNumber() );
        orderDto.setStatusOrder( order.getStatusOrder() );
        orderDto.setCreatedAt( order.getCreatedAt() );

        return orderDto;
    }
}
