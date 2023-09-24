package dev.naman.mc_ecomuserservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyUserRequestDto {
    private String email;
    private String password;
}
