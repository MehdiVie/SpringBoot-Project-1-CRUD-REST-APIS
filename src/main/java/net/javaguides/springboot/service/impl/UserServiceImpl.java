package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.mapper.AutoMapper;
import net.javaguides.springboot.mapper.UserMapper;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        //Convert Dto to Jpa
        // User user = UserMapper.mapToUser(userDto);
        // User user = modelMapper.map(userDto, User.class);
        User user = AutoMapper.Mapper.mapToUser(userDto);

        User savedUser = userRepository.save(user);

        //convert Jpa to Dto
        //UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        //UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        UserDto savedUserDto = AutoMapper.Mapper.mapToUserDto(savedUser);
        return savedUserDto;
    }


    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        //UserDto userDto = UserMapper.mapToUserDto(optionalUser.get());
        //UserDto userDto = modelMapper.map(optionalUser.get(), UserDto.class);
        UserDto userDto = AutoMapper.Mapper.mapToUserDto(optionalUser.get());
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        //return users.stream().map(UserMapper::mapToUserDto)
        //        .collect(Collectors.toList());
//        return users.stream().map((user) -> modelMapper.map(user, UserDto.class))
//                .collect(Collectors.toList());
        return users.stream().map((user) -> AutoMapper.Mapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existingUser);

        //UserDto updatedUserDto = UserMapper.mapToUserDto(updatedUser);
        //UserDto updatedUserDto = modelMapper.map(updatedUser,UserDto.class);
        UserDto updatedUserDto = AutoMapper.Mapper.mapToUserDto(updatedUser);
        return updatedUserDto;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }



}
