package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoMapper {

    AutoMapper Mapper = Mappers.getMapper(AutoMapper.class);

    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);
}
