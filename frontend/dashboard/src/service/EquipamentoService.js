import axios from "axios";

const API_URL = "http://localhost:8080";
const EQUIPMENT_API_URL = `${API_URL}/equipment`;

class EquipamentoService {
  retrieveAnnualOees(equipment) {
    return axios.get(`${EQUIPMENT_API_URL}/${equipment}`);
  }
}

export default new EquipamentoService();