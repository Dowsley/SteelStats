package g5.dashboard.backend;

import java.util.Map;

public class ApiOeeResponse {
  private String tipoPeriodo; /* Uma string com "anual", "mensal" ou "diario" */
  private String nomeEquipamento;
  private Map<Integer, Double> oees;

  public String getNomeEquipamento() {
    return this.nomeEquipamento;
  }

  public void setNomeEquipamento(String nomeEquipamento) {
    this.nomeEquipamento = nomeEquipamento;
  }

  public Map<Integer,Double> getOees() {
    return this.oees;
  }

  public void setOees(Map<Integer,Double> oees) {
    this.oees = oees;
  }

  public String getTipoPeriodo() {
    return this.tipoPeriodo;
  }

  public void setTipoPeriodo(String tipoPeriodo) {
    this.tipoPeriodo = tipoPeriodo;
  }
}