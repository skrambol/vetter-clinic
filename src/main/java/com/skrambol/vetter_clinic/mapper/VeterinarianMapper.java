package com.skrambol.vetter_clinic.mapper;

import org.mapstruct.Mapper;

import com.skrambol.vetter_clinic.dto.request.auth.RegisterVeterinarianDto;
import com.skrambol.vetter_clinic.entity.Veterinarian;

/**
 * UserMapper
 */
@Mapper
public interface VeterinarianMapper {
	RegisterVeterinarianDto toVeterinarianDto(Veterinarian veterinarian);

	Veterinarian toVeterinarian(RegisterVeterinarianDto veterinarianDto);
}
