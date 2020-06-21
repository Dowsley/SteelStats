import axios from "axios";

const API_URL = "http://localhost:8080";
const PARADA_API_URL = `${API_URL}/parada`;

class TempoParadaService {
  retrieveTempoParada(tipo, ano, mes) {
    var url = PARADA_API_URL;
    // Parametro de path
    if (tipo != null) {
      url += `/${tipo}`;
    }
    // Parametros regulares
    if (mes != null) {
      url += `?ano=${ano.toString()}&mes=${mes.toString()}`;
    } else if (ano != null ) {
      url += `?ano=${ano.toString()}`;
    }
    return axios.get(url);
  }
}

export default new TempoParadaService();