package RK_coffe_shop_mapped_db.service;

import RK_coffe_shop_mapped_db.db.repository.UserRepository;
import RK_coffe_shop_mapped_db.dto.RequestUserDto;
import RK_coffe_shop_mapped_db.dto.ResponseUserDto;
import RK_coffe_shop_mapped_db.service.mapper.RequestUserMapper;
import RK_coffe_shop_mapped_db.service.mapper.ResponseUserMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserRepository userRepository;
    private final RequestUserMapper requestUserMapper;
    private final ResponseUserMapper responseUserMapper;

    public RequestUserDto create(RequestUserDto dto) {
        if (dto.getId() == null) {
			logger.warn("Warning: " + dto.getClass() + " has empty id. This empty id field was randomized.");
            dto.setId(UUID.randomUUID());
        }
        return requestUserMapper.toDto(userRepository.save(requestUserMapper.toEntity(dto)));
    }

    public void delete(UUID uuid) throws Exception {
        if (!userRepository.existsById(uuid)) {
			logger.error("Delete user error: no user exists with this id.");
            throw new Exception("No user to delete");
        }
        userRepository.delete(uuid);
    }

    public RequestUserDto update(RequestUserDto dto) throws Exception {
        if (!userRepository.existsById(dto.getId())) {
			logger.error("Update user error: no user exists with this id.");
            throw new Exception("No user to update");
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
