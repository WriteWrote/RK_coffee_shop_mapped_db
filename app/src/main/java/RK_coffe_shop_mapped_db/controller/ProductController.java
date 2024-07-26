package RK_coffe_shop_mapped_db.controller;

import RK_coffe_shop_mapped_db.controller.handler.ApiExceptionHandler;
import RK_coffe_shop_mapped_db.controller.handler.ExceptionResponse;
import RK_coffe_shop_mapped_db.dto.ProductDto;
import RK_coffe_shop_mapped_db.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) {
        logger.info("{} POST: create {}", this.getClass(), dto);
        return new ResponseEntity<>(
                productService.create(dto),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) throws Exception {
        logger.info("{} DELETE: delete {}", this.getClass(), id);
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto dto) {
        logger.info("{} PUT: update {}", this.getClass(), dto);
        return new ResponseEntity<>(
                productService.update(dto),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable("id") UUID id) {
        logger.info("{} GET: getById {}", this.getClass(), id);
        return new ResponseEntity<>(
                productService.getById(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAll() {
        logger.info("{} GET: getAll", this.getClass());
        return new ResponseEntity<>(
                productService.getAll(),
                HttpStatus.OK
        );
    }
}
