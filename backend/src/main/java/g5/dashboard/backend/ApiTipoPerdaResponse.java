package g5.dashboard.backend;

import java.util.Map;

/* Representa um TIPO de perda */
public class ApiTipoPerdaResponse {
  /* Porcentagem de cada tipo de disfunção naquela falha */
  private Map<String, Double> disfuncoes;
  private String tipo;
  /* Representação deste tipo de perda */
  private Double segmento;

  public ApiTipoPerdaResponse(
  String tipo, Map<String,Double> disfuncoes, Double segmento) {
    this.segmento = segmento;
    this.tipo = tipo;
    this.disfuncoes = disfuncoes;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Map<String,Double> getDisfuncoes() {
    return this.disfuncoes;
  }

  public void setDisfuncoes(Map<String,Double> disfuncoes) {
    this.disfuncoes = disfuncoes;
  }

  public Double getSegmento() {
    return this.segmento;
  }

  public void setSegmento(Double segmento) {
    this.segmento = segmento;
  }
}