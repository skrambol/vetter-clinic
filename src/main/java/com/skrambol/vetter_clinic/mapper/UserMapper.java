package com.skrambol.vetter_clinic.mapper;

import org.mapstruct.Mapper;

import com.skrambol.vetter_clinic.dto.request.auth.RegisterOwnerDto;
import com.skrambol.vetter_clinic.dto.request.auth.RegisterUserDto;
import com.skrambol.vetter_clinic.dto.request.auth.RegisterVeterinarianDto;
import com.skrambol.vetter_clinic.entity.User;

/**
 * UserMapper
 */
@Mapper
public interface UserMapper {
	RegisterOwnerDto toUserDto(User user);

	User toUser(RegisterOwnerDto userDto);

	User toUser(RegisterVeterinarianDto veterinarianDto);
}
