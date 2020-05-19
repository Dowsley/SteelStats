package g5.dashboard.backend;

import java.util.Map;

public class ApiEquipmentResponse {
  private String equipmentName;
  private Map<Integer, Double> oees;

  public String getEquipmentName() {
    return this.equipmentName;
  }

  public void setEquipmentName(String equipmentName) {
    this.equipmentName = equipmentName;
  }

  public Map<Integer,Double> getOees() {
    return this.oees;
  }

  public void setOees(Map<Integer,Double> oees) {
    this.oees = oees;
  }
}