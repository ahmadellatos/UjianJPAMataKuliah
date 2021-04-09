package com.kuliah.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuliah.main.entity.PlotMataKuliah;
import com.kuliah.main.repository.PlotMataKuliahRepository;

@Service
public class ModelPlotMataKuliah implements ModelPlotMataKuliahInterface{

	@Autowired
	PlotMataKuliahRepository plotMkRepo;
	
	@Override
	public List<PlotMataKuliah> getAllPlotMataKuliah() {
		// TODO Auto-generated method stub
		return (List<PlotMataKuliah>) this.plotMkRepo.findAll();
	}

	@Override
	public PlotMataKuliah addPlotMataKuliah(PlotMataKuliah plotMk) {
		// TODO Auto-generated method stub
		return this.plotMkRepo.save(plotMk);
	}

	@Override
	public PlotMataKuliah cariPlotMataKuliah(String id) {
		// TODO Auto-generated method stub
		return this.plotMkRepo.findById(Long.parseLong(id)).get();
	}
	
	@Override
	public void deletePlotMataKuliah(String id) {
		// TODO Auto-generated method stub
		this.plotMkRepo.deleteById(Long.parseLong(id));
	}

	@Override
	public PlotMataKuliah soalUjian(String id) {
		// TODO Auto-generated method stub
		return this.plotMkRepo.findById(Long.parseLong(id)).get();
	}

	

}
