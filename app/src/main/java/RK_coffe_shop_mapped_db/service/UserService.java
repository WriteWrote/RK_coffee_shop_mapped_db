package RK_coffe_shop_mapped_db.service;

import RK_coffe_shop_mapped_db.db.repository.UserRepository;
import RK_coffe_shop_mapped_db.dto.CreateUserDto;
import RK_coffe_shop_mapped_db.dto.UserDto;
import RK_coffe_shop_mapped_db.service.mapper.CreateUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final CreateUserMapper userMapper;
	
	public CreateUserDto create(CreateUserDto dto) {
		return userMapper.fromEntity(userRepository.save(userMapper.toEntity(dto)));
	}
	
	public void delete(UUID uuid) throws Exception {
		if (userRepository.existsById(uuid))
			userRepository.deleteById(uuid);
		else throw new Exception("No user to delete");
	}
	
	public CreateUserDto update(CreateUserDto dto) throws Exception {
		if (userRepository.existsById(dto.getUuid()))
			return userMapper.fromEntity(userRepository.save(userMapper.toEntity(dto)));
		else throw new Exception("No user to update");
	}
	
	public UserDto getById(UUID uuid) {
		return userMapper.fromEntity(userRepository.findById(uuid).orElseThrow());
	}
	
	public List<UserDto> getAll() {
		return StreamSupport.stream(userRepository.findAll().spliterator(), false)
			.map(userMapper::fromEntity)
			.collect(Collectors.toList());
	}
}
