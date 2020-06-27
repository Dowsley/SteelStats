import axios from "axios";

const API_URL = "http://localhost:8080";
const PERDA_API_URL = `${API_URL}/perdasOverview`;

class TipoPerdaService {
  retrieveTipoPerda() {
    var url = PERDA_API_URL;
    return axios.get(url);
  }
}

export default new TipoPerdaService();