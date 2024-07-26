package RK_coffe_shop_mapped_db.controller;


import RK_coffe_shop_mapped_db.controller.handler.ApiExceptionHandler;
import RK_coffe_shop_mapped_db.controller.handler.ExceptionResponse;
import RK_coffe_shop_mapped_db.dto.RequestUserDto;
import RK_coffe_shop_mapped_db.dto.ResponseUserDto;
import RK_coffe_shop_mapped_db.service.UserService;
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
@RequestMapping("/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

    @PostMapping
    public ResponseEntity<RequestUserDto> create(@RequestBody RequestUserDto dto) {
        logger.info("{} POST: create {}", this.getClass(), dto);
        return new ResponseEntity<>(
                userService.create(dto),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        logger.info("{} DELETE: delete {}", this.getClass(), id);
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<RequestUserDto> update(@RequestBody RequestUserDto dto) {
        logger.info("{} PUT: update {}", this.getClass(), dto);
        return new ResponseEntity<>(
                userService.update(dto),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDto> getById(@PathVariable("id") UUID id) {
        logger.info("{} GET: getById {}", this.getClass(), id);
        return new ResponseEntity<>(
                userService.getById(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseUserDto>> getAll() {
        logger.info("{} GET: getAll", this.getClass());
        return new ResponseEntity<>(
                userService.getAll(),
                HttpStatus.OK
        );
    }
}
