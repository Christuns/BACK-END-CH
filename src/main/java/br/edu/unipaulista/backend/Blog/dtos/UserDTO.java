package br.edu.unipaulista.backend.Blog.dtos;

import br.edu.unipaulista.backend.Blog.domainModel.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {

    private UUID id;

    @NotBlank(message = "O nome é obrigatorio")
    @Size(max = 100, message = "O nome deve ter no maximo 100 caracteres")
    private String name;

    @NotBlank(message = "O email é obrigatorio")
    @Email(message = "O email deve ser valido ")
    @Size(max = 100, message = "O email deve ter no maximo 100 caracteres")
    private String email;

    @NotBlank(message = "A senha é obrigatorio")
    @Size(min = 6, message = "A senha deve ter no minimo 6 caracteres")
    private String password;

    // Métodos de conversão (static)

    public static UserDTO fromEntity(User user){
        if (user == null){
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        return dto;
    }
    public static User toEntity(UserDTO dto){
        if (dto == null){
            return null;
        }
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
