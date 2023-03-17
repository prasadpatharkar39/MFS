package com.magicflare.demo.repository;

import com.magicflare.demo.model.SkillEntity;
import com.magicflare.demo.model.SkillTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillEntityRepository extends JpaRepository<SkillEntity,Integer> {
    List<SkillEntity> findBySkillType(SkillTypeEntity skillType);

}
