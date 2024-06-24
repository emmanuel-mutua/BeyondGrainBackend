package org.emmutua.beyondgrain.mapper;

import org.bson.types.ObjectId;
import org.emmutua.beyondgrain.userManagement.model.AppUser;
import org.springframework.stereotype.Service;

@Service
public class ObjectMapper {
    public AppUserDto toAppUserDto(AppUser appUser) {
        return AppUserDto.builder()
                .id(appUser.get_id())
                .username(appUser.getUsername())
                .email(appUser.getEmail())
                .phone(appUser.getPhone())
                .idNumber(appUser.getIdNo())
                .role(appUser.getRole())
                .isEnabled(appUser.isEnabled())
                .build();
    }

    public ObjectId toObjectId(String hexString){
        return new ObjectId(hexString);
    }
}
