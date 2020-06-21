package g5.dashboard.backend;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface PerdaRepository extends CrudRepository<Perda, Integer> {
  /* Unidade de tempo: Minutos */
  @Query(value = "SELECT"
  + " COALESCE(SUM(TIMESTAMPDIFF(minute,dth_inicial_realizado,dth_final_realizado)),0)"
  + " FROM perda WHERE (?1 is null or des_tipo_falha=?1)"
  + " and (?2 is null or year(dth_inicial_realizado)=?2)"
  + " and (?3 is null or month(dth_inicial_realizado)=?3)"
  + " and (?4 is null or day(dth_inicial_realizado)=?4)"
  , nativeQuery = true)
  Double getParada(String tipo, Integer ano, Integer mes, Integer dia);

  /* Queries para achar períodos que houveram falhas */
  @Query(value = "SELECT DISTINCT EXTRACT(YEAR FROM dth_inicial_realizado)"
  + " FROM perda WHERE (?1 is null or des_tipo_falha=?1)",
  nativeQuery = true)
  Iterable<Integer> getAnosAtivos(String tipo);

  @Query(value = "SELECT DISTINCT EXTRACT(MONTH FROM dth_inicial_realizado)"
  + " FROM perda WHERE (?1 is null or des_tipo_falha=?1)"
  + " and year(dth_inicial_realizado)=?2", nativeQuery = true)
  Iterable<Integer> getMesesAtivos(String tipo, 
                                  Integer ano);

  @Query(value = "SELECT DISTINCT EXTRACT(DAY FROM dth_inicial_realizado)"
  + " FROM perda WHERE (?1 is null or des_tipo_falha=?1)"
  + " and year(dth_inicial_realizado)=?2 and month(dth_inicial_realizado)=?3",
  nativeQuery = true)
  Iterable<Integer> getDiasAtivos(String tipo, 
                                  Integer ano, 
                                  Integer mes);
  
  /* Retorna todos os diferentes tipos de falha */
  @Query(value = "SELECT DISTINCT des_tipo_falha FROM perda", nativeQuery=true)
  Iterable<String> getDistinctTipoFalha();

  /* Retorna todos os diferentes disfuncoes de 
  processo para um determinado tipo de falha */
  @Query(value = "SELECT DISTINCT des_disfuncao_processo FROM perda"
  + " WHERE des_tipo_falha=?1" ,nativeQuery=true)
  Iterable<String> getDistinctDisfuncaoProcesso(String tipo);

  /* Retorna a porcentagem (decimal) de um determinado 
  tipo de falha comparado ao total */
  @Query(value = "SELECT sum(IF(des_tipo_falha=?1, 1, 0) )"
  + " / count(*) FROM perda" ,nativeQuery=true)
  Double getPorcentagemTipoFalha(String tipo);

  /* Retorna a porcentagem (decimal) de um determinado 
  disfuncao de processo comparado ao total (no grupo de uma falha) */
  @Query(value = "SELECT sum(IF(des_disfuncao_processo=?2,1,0))"
  + " / count(*) FROM gerdaufake.perda WHERE des_tipo_falha=?1"
  , nativeQuery = true)
  Double getPorcentagemDisfuncaoProcesso(String tipo, String disf);
}