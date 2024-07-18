package RK_coffe_shop_mapped_db.service;

import RK_coffe_shop_mapped_db.db.repository.UserRepository;
import RK_coffe_shop_mapped_db.dto.RequestUserDto;
import RK_coffe_shop_mapped_db.dto.ResponseUserDto;
import RK_coffe_shop_mapped_db.service.mapper.RequestUserMapper;
import RK_coffe_shop_mapped_db.service.mapper.ResponseUserMapper;
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
	private final RequestUserMapper requestUserMapper;
	private final ResponseUserMapper responseUserMapper;
	
	public RequestUserDto create(RequestUserDto dto) {
		return requestUserMapper.toDto(userRepository.save(requestUserMapper.toEntity(dto)));
	}
	
	public void delete(UUID uuid) throws Exception {
		if (userRepository.existsById(uuid))
			userRepository.delete(uuid);
		else throw new Exception("No user to delete");
	}
	
	public RequestUserDto update(RequestUserDto dto) throws Exception {
		if (userRepository.existsById(dto.getId()))
			return requestUserMapper.toDto(userRepository.save(requestUserMapper.toEntity(dto)));
		else throw new Exception("No user to update");
	}
	
	public ResponseUserDto getById(UUID uuid) {
		return responseUserMapper.toDto(userRepository.findById(uuid).orElseThrow());	//todo create proper mapper
	}
	
	public List<ResponseUserDto> getAll() {
		return userRepository.findAll().stream()
			.map(responseUserMapper::toDto)
			.collect(Collectors.toList());
	}
}
