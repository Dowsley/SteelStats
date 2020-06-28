package g5.dashboard.backend;

import java.util.Map;

public class ApiCofatoresResponse {
  private String nomeEquipamento;
  private Map<Integer, Double> qualidade;
  private Map<Integer, Double> performance;
  private Map<Integer, Double> disponibilidade;

  public ApiCofatoresResponse(String nomeEquipamento, Map<Integer,Double> qualidade, Map<Integer,Double> performance, Map<Integer,Double> disponibilidade) {
    this.nomeEquipamento = nomeEquipamento;
    this.qualidade = qualidade;
    this.performance = performance;
    this.disponibilidade = disponibilidade;
  }

  public String getNomeEquipamento() {
    return this.nomeEquipamento;
  }

  public void setNomeEquipamento(String nomeEquipamento) {
    this.nomeEquipamento = nomeEquipamento;
  }

  public Map<Integer,Double> getQualidade() {
    return this.qualidade;
  }

  public void setQualidade(Map<Integer,Double> qualidade) {
    this.qualidade = qualidade;
  }

  public Map<Integer,Double> getPerformance() {
    return this.performance;
  }

  public void setPerformance(Map<Integer,Double> performance) {
    this.performance = performance;
  }

  public Map<Integer,Double> getDisponibilidade() {
    return this.disponibilidade;
  }

  public void setDisponibilidade(Map<Integer,Double> disponibilidade) {
    this.disponibilidade = disponibilidade;
  }

}