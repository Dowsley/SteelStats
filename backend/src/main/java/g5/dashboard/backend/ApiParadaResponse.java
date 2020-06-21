package g5.dashboard.backend;

import java.util.Map;

public class ApiParadaResponse {
  private String tipoPeriodo; /* Uma string com "anual", "mensal" ou "diario" */
  private String tipoParada;
  private Map<Integer, Double> paradas;

  public String getTipoParada() {
    return this.tipoParada;
  }

  public void setTipoParada(String tipoParada) {
    this.tipoParada = tipoParada;
  }

  public Map<Integer,Double> getParadas() {
    return this.paradas;
  }

  public void setParadas(Map<Integer,Double> paradas) {
    this.paradas = paradas;
  }

  public String getTipoPeriodo() {
    return this.tipoPeriodo;
  }

  public void setTipoPeriodo(String tipoPeriodo) {
    this.tipoPeriodo = tipoPeriodo;
  }
}