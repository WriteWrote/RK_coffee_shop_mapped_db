package RK_coffe_shop_mapped_db.service;

import RK_coffe_shop_mapped_db.db.repository.UserRepository;
import RK_coffe_shop_mapped_db.dto.CreateUserDto;
import RK_coffe_shop_mapped_db.dto.UserDto;
import RK_coffe_shop_mapped_db.service.mapper.CreateUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
	private final UserRepository repository;
	private final CreateUserMapper mapper;
	
	@Autowired
	public UserService(UserRepository repository, CreateUserMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public CreateUserDto create(CreateUserDto dto) {
		return mapper.fromEntity(repository.save(mapper.toEntity(dto)));
	}
	
	public void delete(UUID uuid) throws Exception {
		repository.delete(uuid);
	}
	
	public CreateUserDto update(CreateUserDto dto) throws Exception {
		return mapper.fromEntity(repository.update(mapper.toEntity(dto)));
	}
	
	public UserDto getById(UUID uuid) throws Exception {
		return mapper.fromEntity(repository.findById(uuid));
	}
	
	public List<UserDto> getAll() {
		return repository.findAll().stream().map(mapper::fromEntity).collect(Collectors.toList());
	}
}
