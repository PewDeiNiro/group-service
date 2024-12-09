package com.pewde.groupservice.entity;

import com.pewde.groupservice.enums.WallType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "posts", name = "walls")
public class Wall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST}, mappedBy = "wall")
    private Group group;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private WallType type;

}
