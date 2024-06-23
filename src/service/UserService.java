package service;

import db.repository.UserRepository;
import model.dto.CreateUserDto;
import model.dto.UserDto;
import model.mapper.CreateUserMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserService {
	private final UserRepository repository;
	private final CreateUserMapper mapper;
	
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
