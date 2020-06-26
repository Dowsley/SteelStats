import axios from "axios";

const API_URL = "http://localhost:8080";
const PARADA_API_URL = `${API_URL}/parada`;

class TipoPerdaService {
  retrieveTempoParada(tipo, ano, mes) {
    // Substituir ESCAPE chars do parametro
    tipo = tipo.replace('/', '_');
    tipo = tipo.replace(' ', '%20');
    console.log(tipo);
    
    var url = PARADA_API_URL;
    // Parametro de path
    if (tipo != null && tipo.toLowerCase() != 'todos') {
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

export default new TipoPerdaService();