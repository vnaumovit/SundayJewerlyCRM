package com.sunday.jewelry.service.impl;

import com.sunday.jewelry.exception.UserNotFoundException;
import com.sunday.jewelry.mapper.UserMapper;
import com.sunday.jewelry.model.security.Role;
import com.sunday.jewelry.model.User;
import com.sunday.jewelry.model.dto.UserDto;
import com.sunday.jewelry.repository.RoleRepository;
import com.sunday.jewelry.repository.UserRepository;
import com.sunday.jewelry.service.abst.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Objects.nonNull;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public User passwordCoder(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    @SneakyThrows
    public User registration(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        long ROLE_ID = 1L;
        String roleNotFoundException = String.format("Роль с %s id не найдена", ROLE_ID);
        Role role = roleRepository
                .findById(ROLE_ID)
                .orElseThrow(() -> new RoleNotFoundException(roleNotFoundException));
        user.setRoles(Set.of(role));
        return save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(passwordCoder(user));
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByUsernameAndPassword(String username, String password) {
        User user = findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found"));
        if (nonNull(user)) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}

