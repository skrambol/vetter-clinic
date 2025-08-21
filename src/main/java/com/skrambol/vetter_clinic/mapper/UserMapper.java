package com.skrambol.vetter_clinic.mapper;

import org.mapstruct.Mapper;
import com.skrambol.vetter_clinic.dto.request.auth.RegisterUserDto;
import com.skrambol.vetter_clinic.entity.User;

/**
 * UserMapper
 */
@Mapper
public interface UserMapper {
	RegisterUserDto toUserDto(User user);

	User toUser(RegisterUserDto userDto);
}
