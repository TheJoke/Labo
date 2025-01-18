package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Member_Tools;
import com.example.demo.entity.Member_Tools_Id;

public interface Member_ToolsRepository extends JpaRepository<Member_Tools, Member_Tools_Id> {
	@Query("select m from Member_Tools m where m.id.member_id=:x")
	List<Member_Tools> findByToolsId(@Param("x") Long memId);
}
