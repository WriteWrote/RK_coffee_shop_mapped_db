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
import java.util.stream.StreamSupport;

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
		if (repository.existsById(uuid))
			repository.deleteById(uuid);
		else throw new Exception("No user to delete");
	}
	
	public CreateUserDto update(CreateUserDto dto) throws Exception {
		if (repository.existsById(dto.getUuid()))
			return mapper.fromEntity(repository.save(mapper.toEntity(dto)));
		else throw new Exception("No user to update");
	}
	
	public UserDto getById(UUID uuid) {
		return mapper.fromEntity(repository.findById(uuid).orElseThrow());
	}
	
	public List<UserDto> getAll() {
		return StreamSupport.stream(repository.findAll().spliterator(), false)
				.map(mapper::fromEntity)
				.collect(Collectors.toList());
	}
}
