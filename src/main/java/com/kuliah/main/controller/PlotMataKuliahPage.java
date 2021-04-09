package com.kuliah.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kuliah.main.entity.MataKuliah;
import com.kuliah.main.entity.Pertanyaan;
import com.kuliah.main.entity.PlotMataKuliah;
import com.kuliah.main.services.ModelDosen;
import com.kuliah.main.services.ModelMahasiswa;
import com.kuliah.main.services.ModelMataKuliah;
import com.kuliah.main.services.ModelPertanyaan;
import com.kuliah.main.services.ModelPlotMataKuliah;
import com.kuliah.main.services.ModelPlotMataKuliahInterface;
import com.kuliah.main.services.ModelSoal;

@Controller
public class PlotMataKuliahPage {

	@Autowired
	ModelPlotMataKuliah modelPlotMk;
	
	@Autowired
	ModelDosen modelDosen;
	
	@Autowired
	ModelMataKuliah modelMataKuliah;
	
	@Autowired
	ModelMahasiswa modelMahasiswa;
	
	@Autowired
	ModelSoal modelSoal;
	
	@Autowired
	ModelPertanyaan modelPertanyaan;
	
	@GetMapping("/plotmk/view")
	public String viewIndexPlotMk(Model model) {
		model.addAttribute("listPlotMk",modelPlotMk.getAllPlotMataKuliah());
		model.addAttribute("active",6);
		
		return "view_plotmk";
	}
	
	@GetMapping("/plotmk/add")
	public String viewAddPlotMk(Model model) {
		model.addAttribute("plotmk", new PlotMataKuliah());
		model.addAttribute("listDosen", modelDosen.getAllDosen());
		model.addAttribute("listMahasiswa", modelMahasiswa.getAllMahasiswa());
		model.addAttribute("listMataKuliah", modelMataKuliah.getAllMataKuliah());
		model.addAttribute("listSoal", modelSoal.getAllSoal());
		return "add_plotmk";
	}
	
	@PostMapping("/plotmk/view")
	public String addPlotMk(@ModelAttribute PlotMataKuliah plotMk, Model model) {
		this.modelPlotMk.addPlotMataKuliah(plotMk);
		model.addAttribute("listPlotMk",modelPlotMk.getAllPlotMataKuliah());
		return "redirect:/plotmk/view";
	}
	
	@GetMapping("/plotmk/update/{id}")
	public String viewUpdatePlotMataKuliah(@PathVariable String id, Model model) {
		
		PlotMataKuliah plotMataKuliah = modelPlotMk.cariPlotMataKuliah(id);
		// buat penampung data MataKuliah di halaman htmlnya
		model.addAttribute("plotmk",plotMataKuliah);
		
		return "add_plotmk";
	}
	
	@GetMapping("/plotmk/delete/{id}")
	public String deletePlotMataKuliah(@PathVariable String id, Model model) {
		
		this.modelPlotMk.deletePlotMataKuliah(id);
		model.addAttribute("listPlotMk",modelPlotMk.getAllPlotMataKuliah());
		
		
		return "redirect:/plotmk/view";
	}
	
	@GetMapping("/plotmk/ujian/{id}")
	public String viewUjian(@PathVariable String id, Model model) {
		
		Pertanyaan soalUjian = modelPertanyaan.soalUjian(id);
		model.addAttribute("soalujian", soalUjian);
		
		return "view_ujian";
	}
	
}
