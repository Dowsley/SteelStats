import axios from "axios";

const API_URL = "http://localhost:8080";
const EQUIPAMENTO_API_URL = `${API_URL}/cofatoresAnual`;

class CofatoresService {
  retrieveCofatores(equipamento) {
    var url = EQUIPAMENTO_API_URL;
    // Parametro de path
    if (equipamento != null) {
      url += `/${equipamento}`;
    }
    return axios.get(url);
  }
}

export default new CofatoresService();