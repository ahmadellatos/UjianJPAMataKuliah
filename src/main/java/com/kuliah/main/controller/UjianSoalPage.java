package com.kuliah.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kuliah.main.services.ModelPertanyaan;
import com.kuliah.main.services.ModelSoal;
import com.kuliah.main.services.ModelUjianSoal;

@Controller
public class UjianSoalPage {

	@Autowired
	ModelPertanyaan modelPertanyaan;
	
	@Autowired
	ModelSoal modelSoal;
	
	@GetMapping("/ujian/view/{id}")
	public String viewUjianSoal(Model model) {
		model.addAttribute("listsoalujian", modelPertanyaan.getAllPertanyaan());
		
		return "view_ujian";
	}
	
}
