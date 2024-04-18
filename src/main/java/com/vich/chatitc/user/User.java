package com.vich.chatitc.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "data_user")
public class User {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @Size(min = 3, max = 255)
    private String userName;
    @NotNull
    @Size(min = 3, max = 255)
    private String displayName;
    @NotNull
    @Size(min = 8, max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;

}
