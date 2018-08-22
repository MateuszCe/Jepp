package pl.jeppesen.myapp.myapp.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String serialNumber;

    @NotNull
    private String name;
}
