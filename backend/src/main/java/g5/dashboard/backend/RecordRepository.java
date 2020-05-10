package g5.dashboard.backend;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import g5.dashboard.backend.Record;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface RecordRepository extends CrudRepository<Record, Integer> {
    
  // Formula gigante pra calcular o OEE anual de um equipamento
    @Query(value = "SELECT"
    + " (SUM(production_time) / (SUM(unplanned_time) + SUM(production_time)))"
    + "* (SUM(theoretical_duration_by_pph_for_calculation) / SUM(theoretical_duration_by_pph))"
    + "* ((SUM(qty_produced) - SUM(metallic_loss)) / SUM(qty_produced)) * 100"
    + " FROM record"
    + " WHERE year(dt_start) = ?2 and cod_equipment = ?1"
    , nativeQuery = true)
    Double getAnnualOee(String code, Integer year);
  }