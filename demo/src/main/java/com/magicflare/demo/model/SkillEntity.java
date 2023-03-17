package com.magicflare.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "SKILL",
        indexes = {@Index(name = "INDEX_SKILL_ID", columnList = "ID", unique = true)})
@Builder
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Integer id;

    @Column(name = "SKILL_NAME")
    private  String skillName;



//    @Column(name = "SKILL_TYPE")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "skill_type_entity_id")
    private SkillTypeEntity skillType;


}
