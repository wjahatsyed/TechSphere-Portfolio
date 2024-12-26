package com.adiltech.medi_track.controller;

import com.adiltech.medi_track.model.Medicine;
import com.adiltech.medi_track.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {
    @Autowired
    private MedicineService service;

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return service.getAllMedicines();
    }

    @PostMapping
    public Medicine addMedicine(@RequestBody Medicine medicine) {
        return service.saveMedicine(medicine);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable Long id) {
        service.deleteMedicine(id);
    }

    @GetMapping("/time/{timeOfDay}")
    public List<Medicine> getMedicinesByTimeOfDay(@PathVariable Medicine.TimeOfDay timeOfDay) {
        return service.getMedicinesByTimeOfDay(timeOfDay);
    }

    @GetMapping("/stats")
    public Map<String, Long> getMedicineStats() {
        return service.getMedicineStats();
    }

    @GetMapping("/charts")
    public Map<String, Map<String, Double>> getChartData() {
        return service.getChartData();
    }


}
