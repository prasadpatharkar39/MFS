package com.magicflare.demo.model;

import javax.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "SKILL_TYPE",
        indexes = {@Index(name = "INDEX_SKILL_TYPE_ID", columnList = "ID", unique = true)})
@Builder
public class SkillTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Integer id;

    @Column(name = "SKILL_TYPE_NAME")
    private  String skillTypeName;


    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "skill_type_entity_id")
    private Set<SkillEntity> skills = new LinkedHashSet<>();


}
