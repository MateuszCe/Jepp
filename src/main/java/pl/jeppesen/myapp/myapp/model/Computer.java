package pl.jeppesen.myapp.myapp.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table (name = "computer")

public class Computer {

    @Id
    @NotNull
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private String name;


    @NotNull
    private String serialNumber;
}
