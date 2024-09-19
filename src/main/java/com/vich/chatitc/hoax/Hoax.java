package com.vich.chatitc.hoax;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vich.chatitc.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="data_hoax")
public class Hoax {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min = 10, max = 5000)
    @Column(length = 5000)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
//    @Column(length = 300)
    @ManyToOne//(mappedBy="hoaxes")
    //@JsonIgnore
    private User currentUser;
}
