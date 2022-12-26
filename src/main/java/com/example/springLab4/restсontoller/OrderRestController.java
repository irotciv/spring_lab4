package com.example.springLab4.restсontoller;

import com.example.springLab4.entity.MenuItems;
import com.example.springLab4.entity.Order;
import com.example.springLab4.service.MenuItemsService;
import com.example.springLab4.service.OrderService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "OpenAPI Documentation",
                description = "Documentation of RESTful webservice in Lab4",
                version = "v.1.0.0"
        )
)

@Tag(
        name = "Orders",
        description = "Operation with orders"
)

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {
    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(
            summary = "Get orders",
            description = "Get all orders from server"
    )
    @ApiResponse(responseCode = "200", description = "Successful orders getting")
    @ApiResponse(responseCode = "404", description = "The orders are not found", content = @Content)
    @GetMapping()
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @Operation(
            summary = "Get order",
            description = "Get the order by ID"
    )
    @Parameter(name = "id", description = "The order's ID")
    @ApiResponse(responseCode = "200", description = "Successful order's getting")
    @ApiResponse(responseCode = "404", description = "The order is not found", content = @Content)
    @GetMapping("/{id}")
    ResponseEntity<Order> getOrder(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            throw new OrderNotFoundException(id);
//            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @Operation(
            summary = "Delete the order",
            description = "Delete the order from collection"
    )
    @Parameter(name = "id", description = "The order's ID")
    @ApiResponse(responseCode = "200", description = "Successful order's deleting")
    @ApiResponse(responseCode = "404", description = "The order is not found", content = @Content)
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            throw new OrderNotFoundException(id);
//            return ResponseEntity.notFound().build();
        }
        orderService.deleteOrder(order);
        return ResponseEntity.ok().build();
    }
}
