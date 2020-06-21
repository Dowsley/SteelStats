import axios from "axios";

const API_URL = "http://localhost:8080";
const EQUIPAMENTO_API_URL = `${API_URL}/oee`;

class EquipamentoService {
  retrieveOee(equipamento, ano, mes) {
    var url = EQUIPAMENTO_API_URL;
    // Parametro de path
    if (equipamento != null) {
      url += `/${equipamento}`;
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

export default new EquipamentoService();