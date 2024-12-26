package com.adiltech.medi_track.repository;

import com.adiltech.medi_track.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findByTimeOfDay(Medicine.TimeOfDay timeOfDay);
}
