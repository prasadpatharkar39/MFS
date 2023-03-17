package com.magicflare.demo.repository;

import com.magicflare.demo.model.SkillEntity;
import com.magicflare.demo.model.SkillTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillTypeEntityRepository extends JpaRepository<SkillTypeEntity,Integer> {
    @Query("""
            select s from SkillTypeEntity s inner join s.skills skills
            where upper(skills.skillName) like upper(concat('%', ?1, '%'))""")
    List<SkillTypeEntity> findBySkills_SkillNameContainsIgnoreCase(String skillName);
}
