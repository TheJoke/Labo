package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EnseignantChercheur;
import com.example.demo.entity.Etudiant;
import com.example.demo.entity.Member;
import com.example.demo.service.IMemberService;

import lombok.AllArgsConstructor;

@RestController
public class MemberRestController {
	@Autowired
	IMemberService memberService;

	@RequestMapping(value = "/membres", method = RequestMethod.GET)
	public List<Member> findMembres() {
		return memberService.findAll();
	}

	@GetMapping(value = "/membres/{id}")
	public Member findOneMemberById(@PathVariable Long id) {
		return memberService.findMember(id);
	}
	@GetMapping(value = "/membres/search/email")
	public Member findOneMemberByEmail(@RequestParam String email) {
		return memberService.findByEmail(email);
	}
	@GetMapping(value = "/membres/search")
	public List<EnseignantChercheur> findMembersByGrade(@RequestParam String grade) {
		return memberService.findByGrade(grade);
	}
	@GetMapping(value = "/membres/search/etablissement")
	public List<EnseignantChercheur> findMembersByEtablissement(@RequestParam String etab) {
		return memberService.findByEtablissement(etab);
	}
	
	
	@PostMapping(value = "/membres/enseignant")
	public Member addMembre(@RequestBody EnseignantChercheur m) {
		return memberService.addMember(m);
	}

	@PostMapping(value = "/membres/etudiant")
	public Member addMembre(@RequestBody Etudiant e) {
		return memberService.addMember(e);
	}

	@DeleteMapping(value = "/membres/{id}")
	public void deleteMembre(@PathVariable Long id) {
		memberService.deleteMember(id);
	}

	@PutMapping(value = "/membres/etudiant/{id}")
	public Member updatemembre(@PathVariable Long id, @RequestBody Etudiant p) {
		p.setId(id);
		return memberService.updateMember(p);
	}

	@PutMapping(value = "/membres/enseignant/{id}")
	public Member updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p) {
		p.setId(id);
		return memberService.updateMember(p);
	}

	@GetMapping("/fullmember/{id}")
	public Member findAFullMember(@PathVariable(name = "id") Long id) {
		Member mbr = memberService.findMember(id);
		mbr.setPubs(memberService.findArticleParAuteur(id));
		return mbr;
	}
}