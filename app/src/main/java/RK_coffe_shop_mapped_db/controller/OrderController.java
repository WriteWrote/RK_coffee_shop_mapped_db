package RK_coffe_shop_mapped_db.controller;

import RK_coffe_shop_mapped_db.controller.handler.ApiExceptionHandler;
import RK_coffe_shop_mapped_db.controller.handler.ExceptionResponse;
import RK_coffe_shop_mapped_db.dto.OrderDto;
import RK_coffe_shop_mapped_db.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final OrderService orderService;
    private final ApiExceptionHandler<OrderDto> handler;

    @PostMapping
    public ExceptionResponse<?> create(@RequestBody OrderDto dto) {
        logger.info("{} POST: create {}", this.getClass(), dto);
        return handler.handle(() -> orderService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ExceptionResponse<?> delete(@PathVariable("id") UUID id) {
        logger.info("{} DELETE: delete {}", this.getClass(), id);
        return handler.handle(() -> {
            orderService.delete(id);
            return null;
        });
    }

    @PutMapping
    public ExceptionResponse<?> update(@RequestBody OrderDto dto) {
        logger.info("{} PUT: update {}", this.getClass(), dto);
        return handler.handle(() -> orderService.update(dto));
    }

    @GetMapping("/{id}")
    public ExceptionResponse<?> getById(@PathVariable("id") UUID id) {
        logger.info("{} GET: getById {}", this.getClass(), id);
        return handler.handle(() -> orderService.getById(id));
    }

    @GetMapping("/all")
    public ExceptionResponse<?> getAll() {
        logger.info("{} GET: getAll", this.getClass());
        return new ApiExceptionHandler<List<OrderDto>>().handle(orderService::getAll);
    }
}
