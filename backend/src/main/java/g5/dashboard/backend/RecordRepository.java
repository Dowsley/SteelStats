package g5.dashboard.backend;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface RecordRepository extends CrudRepository<Record, Integer> {
  /* Queries para achar períodos em que um equipamento esteve ativo */
  @Query(value = "SELECT DISTINCT EXTRACT(YEAR FROM dt_start)"
  + " FROM record WHERE (cod_equipment = ?1 or ?1 is null)",
  nativeQuery = true)
  Iterable<Integer> getAnosAtivos(String cod);

  @Query(value = "SELECT DISTINCT EXTRACT(MONTH FROM dt_start)"
  + " FROM record WHERE (cod_equipment = ?1 or ?1 is null)"
  + " and year(dt_start)=?2", nativeQuery = true)
  Iterable<Integer> getMesesAtivos(String cod, 
                                  Integer ano);

  @Query(value = "SELECT DISTINCT EXTRACT(DAY FROM dt_start)"
  + " FROM record WHERE (cod_equipment = ?1 or ?1 is null)"
  + " and year(dt_start)=?2 and month(dt_start)=?3", nativeQuery = true)
  Iterable<Integer> getDiasAtivos(String cod, 
                                  Integer ano, 
                                  Integer mes);

  /* Calculos de Disponibilidade
  * performance e qualidade */
  @Query(value = "SELECT"
  + " COALESCE(SUM(production_time) / (SUM(unplanned_time) + SUM(production_time)),0)"
  + " FROM record WHERE (?1 is null or cod_equipment=?1)"
  + " and (?2 is null or year(dt_start)=?2)"
  + " and (?3 is null or month(dt_start)=?3)"
  + " and (?4 is null or day(dt_start)=?4)"
  , nativeQuery = true)
  Double getDisponibilidade(String cod, Integer ano, Integer mes, Integer dia);

  @Query(value = "SELECT"
  + " COALESCE(SUM(theoretical_duration_by_pph_for_calculation) /"
  + " SUM(theoretical_duration_by_pph),0)"
  + " FROM record WHERE (?1 is null or cod_equipment=?1)"
  + " and (?2 is null or year(dt_start)=?2)"
  + " and (?3 is null or month(dt_start)=?3)"
  + " and (?4 is null or day(dt_start)=?4)"
  , nativeQuery = true)
  Double getPerformance(String cod, Integer ano, Integer mes, Integer dia);

  @Query(value = "SELECT"
  + " COALESCE(((SUM(qty_produced) - SUM(metallic_loss)) / SUM(qty_produced)), 0)"
  + " FROM record WHERE (?1 is null or cod_equipment=?1)"
  + " and (?2 is null or year(dt_start)=?2)"
  + " and (?3 is null or month(dt_start)=?3)"
  + " and (?4 is null or day(dt_start)=?4)"
  , nativeQuery = true)
  Double getQualidade(String cod, Integer ano, Integer mes, Integer dia);
}