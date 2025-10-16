package com.example.microservice.mapper;

import com.example.microservice.dto.OrderDto;
import com.example.microservice.entity.Order;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    OrderDto toDto(final Order order);

}