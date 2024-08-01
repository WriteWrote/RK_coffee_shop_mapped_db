package RK_coffe_shop_mapped_db.service;

import RK_coffe_shop_mapped_db.db.repository.UserRepository;
import RK_coffe_shop_mapped_db.dto.RequestUserDto;
import RK_coffe_shop_mapped_db.dto.ResponseUserDto;
import RK_coffe_shop_mapped_db.service.mapper.RequestUserMapper;
import RK_coffe_shop_mapped_db.service.mapper.ResponseUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RequestUserMapper requestUserMapper;
    private final ResponseUserMapper responseUserMapper;

    public RequestUserDto create(RequestUserDto dto) {
        if (dto.getId() == null) {
            log.warn("Warning: " + dto.getClass() + " has empty id. This empty id field was randomized.");
            dto.setId(UUID.randomUUID());
        }
        return requestUserMapper.toDto(userRepository.save(requestUserMapper.toEntity(dto)));
    }

    public void delete(UUID uuid) {
        if (!userRepository.existsById(uuid)) {
            log.error("Delete user error: no user exists with this id.");
            throw new RuntimeException("No user to delete");
        }
        userRepository.delete(uuid);
    }

    public RequestUserDto update(RequestUserDto dto) {
        if (!userRepository.existsById(dto.getId())) {
            log.error("Update user error: no user exists with this id.");
            throw new RuntimeException("No user to update");
        }
        var dbEntity = userRepository.findById(dto.getId()).orElseThrow();
        return requestUserMapper.toDto(userRepository.update(requestUserMapper.merge(dbEntity, dto)));
    }

    public ResponseUserDto getById(UUID uuid) {
        return responseUserMapper.toDto(userRepository.findById(uuid).orElseThrow());
    }

    public List<ResponseUserDto> getAll() {
        return userRepository.findAll().stream()
                .map(responseUserMapper::toDto)
                .collect(Collectors.toList());
    }
}
