package g5.dashboard.backend;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import g5.dashboard.backend.Record;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface RecordRepository extends CrudRepository<Record, Integer> {
    
  // Formula gigante pra calcular o OEE anual de um equipamento
    @Query(value = "SELECT"
    + " COALESCE((SUM(production_time) / (SUM(unplanned_time) + SUM(production_time)))"
    + "* (SUM(theoretical_duration_by_pph_for_calculation) / SUM(theoretical_duration_by_pph))"
    + "* ((SUM(qty_produced) - SUM(metallic_loss)) / SUM(qty_produced)) * 100, 0)"
    + " FROM record"
    + " WHERE year(dt_start) = ?2 and cod_equipment = ?1"
    , nativeQuery = true)
    Double getAnnualOee(String code, Integer year);

    @Query(value = "SELECT"
    + " COALESCE((SUM(production_time) / (SUM(unplanned_time) + SUM(production_time)))"
    + "* (SUM(theoretical_duration_by_pph_for_calculation) / SUM(theoretical_duration_by_pph))"
    + "* ((SUM(qty_produced) - SUM(metallic_loss)) / SUM(qty_produced)) * 100, 0)"
    + " FROM record"
    + " WHERE  year(dt_start) = ?3 and month(dt_start) = ?2 and cod_equipment = ?1"
    , nativeQuery = true)
    Double getMonthlylOee(String code, Integer month, Integer year);

    @Query(value = "SELECT"
    + " COALESCE((SUM(production_time) / (SUM(unplanned_time) + SUM(production_time)))"
    + "* (SUM(theoretical_duration_by_pph_for_calculation) / SUM(theoretical_duration_by_pph))"
    + "* ((SUM(qty_produced) - SUM(metallic_loss)) / SUM(qty_produced)) * 100, 0)"
    + " FROM record"
    + " WHERE  year(dt_start) = ?4 and month(dt_start) = ?3 and day(dt_start) = ?2 and cod_equipment = ?1"
    , nativeQuery = true)
    Double getDailyOee(String code, Integer day, Integer month, Integer year);

/* Disponibilidade Geral (todas as máquinas)*/

@Query(value = "SELECT"
+ "COALESCE(SUM(production_time) / (SUM(unplanned_time) + SUM(production_time))*100,0)"
+ " FROM record"
, nativeQuery = true)
Double getDisponibilidadeGeral();

@Query(value = "SELECT"
+ "COALESCE(SUM(production_time) / (SUM(unplanned_time) + SUM(production_time))*100,0)"
+ " FROM record"
+ " WHERE year(dth_inicial_realizado)= ?1"
, nativeQuery = true)
Double getDisponibilidadeGeralAnual(Integer year);

@Query(value = "SELECT"
+ "COALESCE(SUM(production_time) / (SUM(unplanned_time) + SUM(production_time))*100,0)"
+ " FROM record"
+ " WHERE  year(dt_start) = ?2 AND month(dt_start) = ?1"
, nativeQuery = true)
Double getDisponibilidadeGeralMensal( Integer month, Integer year);

@Query(value = "SELECT"
+ "COALESCE(SUM(production_time) / (SUM(unplanned_time) + SUM(production_time))*100,0)"
+ " FROM record"
+ " WHERE  year(dt_start) = ?3 AND month(dt_start) = ?2 AND day(dt_start) = ?1"
, nativeQuery = true)
Double getDisponibilidadeGeralDiario( Integer day, Integer month, Integer year);

/* Disponiblidade Anual, Mensal e Diário de cada máquina */

@Query(value = "SELECT"
+ "COALESCE(SUM(production_time) / (SUM(unplanned_time) + SUM(production_time))*100,0)"
+ " FROM record"
+ " WHERE year(dth_inicial_realizado)= ?2 AND cod_equipment = ?1"
, nativeQuery = true)
Double getDisponibilidadeAnual(String code, Integer year);

@Query(value = "SELECT"
+ "COALESCE(SUM(production_time) / (SUM(unplanned_time) + SUM(production_time))*100,0)"
+ " FROM record"
+ " WHERE  year(dt_start) = ?3 and month(dt_start) = ?2 and cod_equipment = ?1"
, nativeQuery = true)
Double getDisponibilidadeMensal(String code, Integer month, Integer year);

@Query(value = "SELECT"
+ "COALESCE(SUM(production_time) / (SUM(unplanned_time) + SUM(production_time))*100,0)"
+ " FROM record"
+ " WHERE  year(dt_start) = ?4 and month(dt_start) = ?3 and day(dt_start) = ?2 and cod_equipment = ?1"
, nativeQuery = true)
Double getDisponibilidadeDiario(String code, Integer day, Integer month, Integer year);

/* Performance Anual, Mensal e diário geral (de todas as maquinas) */ 
@Query(value = "SELECT"
+ "COALESCE(SUM(theoretical_duration_by_pph_for_calculation) / SUM(theoretical_duration_by_pph)*100,0)"
+ " FROM record"
, nativeQuery = true)
Double getPerformanceGeral();

@Query(value = "SELECT"
+ "COALESCE(SUM(theoretical_duration_by_pph_for_calculation) / SUM(theoretical_duration_by_pph)*100,0)"
+ " FROM record"
+ " WHERE  year(dt_start) = ?1"
, nativeQuery = true)
Double getPerformanceGeralAnual(Integer year);

@Query(value = "SELECT"
+ "COALESCE(SUM(theoretical_duration_by_pph_for_calculation) / SUM(theoretical_duration_by_pph)*100,0)"
+ " FROM record"
+ " WHERE  year(dt_start) = ?2 and month(dt_start) = ?1"
, nativeQuery = true)
Double getPerformanceGeralMensal(Integer month, Integer year);


@Query(value = "SELECT"
+ "COALESCE(SUM(theoretical_duration_by_pph_for_calculation) / SUM(theoretical_duration_by_pph)*100,0)"
+ " FROM record"
+ " WHERE  year(dt_start) = ?3 and month(dt_start) = ?2 and day(dt_start) = ?1"
, nativeQuery = true)
Double getPerformanceGeralDiario(Integer day, Integer month, Integer year);

/* Performance Anual, Mensal e Diário de cada máquina */
@Query(value = "SELECT"
+ "COALESCE(SUM(theoretical_duration_by_pph_for_calculation) / SUM(theoretical_duration_by_pph)*100,0)"
+ " FROM record"
+ " WHERE year(dth_inicial_realizado)= ?2 AND cod_equipment = ?1"
, nativeQuery = true)
Double getPerformanceAnual(String code, Integer year);

@Query(value = "SELECT"
+ "COALESCE(SUM(theoretical_duration_by_pph_for_calculation) / SUM(theoretical_duration_by_pph)*100,0)"
+ " FROM record"
+ " WHERE  year(dt_start) = ?3 and month(dt_start) = ?2 and cod_equipment = ?1"
, nativeQuery = true)
Double getPerformanceMensal(String code, Integer month, Integer year);

@Query(value = "SELECT"
+ "COALESCE(SUM(theoretical_duration_by_pph_for_calculation) / SUM(theoretical_duration_by_pph)*100,0)"
+ " FROM record"
+ " WHERE  year(dt_start) = ?4 and month(dt_start) = ?3 and day(dt_start) = ?2 and cod_equipment = ?1"
, nativeQuery = true)
Double getPerformanceDiario(String code, Integer day, Integer month, Integer year);

/* Qualidade Anual, Mensal e Diário geral (todas as máquinas */
@Query(value = "SELECT"
+ "COALESCE(((SUM(qty_produced) - SUM(metallic_loss)) / SUM(qty_produced)) * 100, 0)"
+ " FROM record"
, nativeQuery = true)
Double getQualidadeGeralAnual();

@Query(value = "SELECT"
+ "COALESCE(((SUM(qty_produced) - SUM(metallic_loss)) / SUM(qty_produced)) * 100, 0)"
+ " FROM record"
+ " WHERE  year(dt_start) = ?1"
, nativeQuery = true)
Double getQualidadeGeralAnual(Integer year);

@Query(value = "SELECT"
+ "COALESCE(((SUM(qty_produced) - SUM(metallic_loss)) / SUM(qty_produced)) * 100, 0)"
+ " FROM record"
+ " WHERE  year(dt_start) = ?2 AND month(dt_start) = ?1"
, nativeQuery = true)
Double getQualidadeGeralMensal(Integer month, Integer year);

@Query(value = "SELECT"
+ "COALESCE(((SUM(qty_produced) - SUM(metallic_loss)) / SUM(qty_produced)) * 100, 0)"
+ " FROM record"
+ " WHERE  year(dt_start) = ?3 AND month(dt_start) = ?2 AND day(dt_start) = ?1"
, nativeQuery = true)
Double getQualidadeGeralDiario(Integer day, Integer month, Integer year);

/* Qualidade Anual, Mensal e Diário de cada máquina */
@Query(value = "SELECT"
+ "COALESCE(((SUM(qty_produced) - SUM(metallic_loss)) / SUM(qty_produced)) * 100, 0)"
+ " FROM record"
+ " WHERE year(dth_inicial_realizado)= ?2 AND cod_equipment = ?1"
, nativeQuery = true)
Double getQualidadeAnual(String code, Integer year);

@Query(value = "SELECT"
+ "COALESCE(((SUM(qty_produced) - SUM(metallic_loss)) / SUM(qty_produced)) * 100, 0)"
+ " FROM record"
+ " WHERE  year(dt_start) = ?3 and month(dt_start) = ?2 and cod_equipment = ?1"
, nativeQuery = true)
Double getQualidadeMensal(String code, Integer month, Integer year);

@Query(value = "SELECT"
+ "COALESCE(((SUM(qty_produced) - SUM(metallic_loss)) / SUM(qty_produced)) * 100, 0)"
+ " FROM record"
+ " WHERE  year(dt_start) = ?4 and month(dt_start) = ?3 and day(dt_start) = ?2 and cod_equipment = ?1"
, nativeQuery = true)
Double getQualidadeDiario(String code, Integer day, Integer month, Integer year);

    @Query(value = "SELECT DISTINCT EXTRACT(YEAR FROM dt_start)" +
    " FROM record WHERE cod_equipment = ?1", nativeQuery = true)
    Iterable<Integer> findYearsByEquipment(String codEquipment);
  }