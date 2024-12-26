package com.adiltech.medi_track.controller;

import com.adiltech.medi_track.model.Medicine;
import com.adiltech.medi_track.repository.MedicineRepository;
import com.adiltech.medi_track.service.MedicineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MedicineControllerTest {
    @Autowired
    MedicineService medicineService;

    @Autowired
    MedicineRepository medicineRepository;

    @Test
    void testGetMedicineStats() {
        Medicine med1 = new Medicine();
        med1.setTimeOfDay(Medicine.TimeOfDay.MORNING);
        Medicine med2 = new Medicine();
        med2.setTimeOfDay(Medicine.TimeOfDay.AFTERNOON);

        when(medicineRepository.findAll()).thenReturn(List.of(med1, med2));

        Map<String, Long> stats = medicineService.getMedicineStats();
        assertEquals(1L, stats.get("MORNING"));
        assertEquals(1L, stats.get("AFTERNOON"));
        assertEquals(0L, stats.get("EVENING"));
    }

    @Test
    void testGetChartData() {
        Medicine med1 = new Medicine();
        med1.setTimeOfDay(Medicine.TimeOfDay.MORNING);
        med1.setQuantity(5);
        med1.setContentVolume(500.0);

        Medicine med2 = new Medicine();
        med2.setTimeOfDay(Medicine.TimeOfDay.AFTERNOON);
        med2.setQuantity(3);
        med2.setContentVolume(300.0);

        when(medicineRepository.findAll()).thenReturn(List.of(med1, med2));

        Map<String, Map<String, Double>> chartData = medicineService.getChartData();
        assertEquals(5.0, chartData.get("MORNING").get("totalQuantity"));
        assertEquals(500.0, chartData.get("MORNING").get("totalContentVolume"));
        assertEquals(3.0, chartData.get("AFTERNOON").get("totalQuantity"));
        assertEquals(300.0, chartData.get("AFTERNOON").get("totalContentVolume"));
    }


}