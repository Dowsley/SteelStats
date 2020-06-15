package g5.dashboard.backend;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import g5.dashboard.backend.Perda;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface PerdaRepository extends CrudRepository<Perda, Integer> {
  @Query(value = "SELECT"
  + " COALESCE(SUM(TIMESTAMPDIFF(minute, dth_inicial_realizado, dth_final_realizado)),0) "
  + " FROM perda"
  , nativeQuery = true)
  Double getParadaGeral();

  @Query(value = "SELECT"
  + " COALESCE(SUM(TIMESTAMPDIFF(minute, dth_inicial_realizado, dth_final_realizado)),0) "
  + " FROM perda"
  + " WHERE des_tipo_falha = ?1"
  , nativeQuery = true)
  Double getParada(String tipo);

    @Query(value = "SELECT"
    + " COALESCE(SUM(TIMESTAMPDIFF(minute, dth_inicial_realizado, dth_final_realizado)),0) "
    + " FROM perda"
    + " WHERE year(dth_inicial_realizado)= ?1"
    , nativeQuery = true)
    Double getParadaGeralAnual(Integer year);

    @Query(value = "SELECT"
    + " COALESCE(SUM(TIMESTAMPDIFF(minute, dth_inicial_realizado, dth_final_realizado)),0) "
    + " FROM perda"
    + " WHERE des_tipo_falha= ?2  AND year(dth_inicial_realizado)= ?1"
    , nativeQuery = true)
    Double getParadaAnual(Integer year, String tipo);

    @Query(value = "SELECT"
    + " COALESCE(SUM(TIMESTAMPDIFF(minute, dth_inicial_realizado, dth_final_realizado)),0) "
    + " FROM perda"
    + " WHERE month(dth_inicial_realizado)= ?2 AND year(dth_inicial_realizado)= ?1"
    , nativeQuery = true)
    Double getParadaGeralMensal(Integer year, Integer month);

    @Query(value = "SELECT"
    + " COALESCE(SUM(TIMESTAMPDIFF(minute, dth_inicial_realizado, dth_final_realizado)),0) "
    + " FROM perda"
    + " WHERE des_tipo_falha= ?3 AND month(dth_inicial_realizado)= ?2 AND year(dth_inicial_realizado)= ?1"
    , nativeQuery = true)
    Double getParadaMensal(Integer year,  Integer month,String tipo);

    @Query(value = "SELECT"
    + " COALESCE(SUM(TIMESTAMPDIFF(minute, dth_inicial_realizado, dth_final_realizado)),0) "
    + " FROM perda"
    + " WHERE day(dth_inicial_realizado)= ?3 AND month(dth_inicial_realizado)= ?2 AND year(dth_inicial_realizado)= ?1"
    , nativeQuery = true)
    Double getParadaGeralDiaria(Integer year, Integer month, Integer day);

    @Query(value = "SELECT"
    + " COALESCE(SUM(TIMESTAMPDIFF(minute, dth_inicial_realizado, dth_final_realizado)),0) "
    + " FROM perda"
    + " WHERE des_tipo_falha= ?4 AND day(dth_inicial_realizado)= ?3 AND month(dth_inicial_realizado)= ?2 AND year(dth_inicial_realizado)= ?1"
    , nativeQuery = true)
    Double getParadaDiaria(Integer year,  Integer month, Integer day ,String tipo);


}