package com.adiltech.medi_track.service;

import com.adiltech.medi_track.model.Medicine;
import com.adiltech.medi_track.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository repository;

    public List<Medicine> getAllMedicines() {
        return repository.findAll();
    }

    public Medicine saveMedicine(Medicine medicine) {
        return repository.save(medicine);
    }

    public void deleteMedicine(Long id) {
        repository.deleteById(id);
    }

    public List<Medicine> getMedicinesByTimeOfDay(Medicine.TimeOfDay timeOfDay) {
        return repository.findByTimeOfDay(timeOfDay);
    }

    public Map<String, Long> getMedicineStats() {
        List<Medicine> medicines = repository.findAll();

        // Count medicines for each TimeOfDay
        Map<String, Long> timeOfDayStats = new HashMap<>();
        for (Medicine.TimeOfDay time : Medicine.TimeOfDay.values()) {
            timeOfDayStats.put(time.name(), medicines.stream()
                    .filter(m -> m.getTimeOfDay() == time)
                    .count());
        }
        return timeOfDayStats;
    }

    public Map<String, Map<String, Double>> getChartData() {
        List<Medicine> medicines = repository.findAll();

        // Prepare chart data
        Map<String, Map<String, Double>> chartData = new HashMap<>();
        for (Medicine.TimeOfDay time : Medicine.TimeOfDay.values()) {
            Map<String, Double> timeData = new HashMap<>();
            timeData.put("totalQuantity", medicines.stream()
                    .filter(m -> m.getTimeOfDay() == time)
                    .mapToDouble(Medicine::getQuantity)
                    .sum());
            timeData.put("totalContentVolume", medicines.stream()
                    .filter(m -> m.getTimeOfDay() == time)
                    .mapToDouble(Medicine::getContentVolume)
                    .sum());
            chartData.put(time.name(), timeData);
        }
        return chartData;
    }


}
