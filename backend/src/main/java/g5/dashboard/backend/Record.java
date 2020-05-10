package g5.dashboard.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp; // Para criar campos do tipo DATETIME em SQL

@Entity // This tells Hibernate to make a table out of this class
public class Record {
    /* Fields */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String codEquipment;
	
	private String idEquipmentStatus;

	private String codShift;

	private String codCrew;

	private Boolean equipmentStatusMode;

    private Double unplannedTime;
    
    private Double stoppedTime;

    private Double productionTime;

    private String idMaterialDefinition;

    private Timestamp dtStart;

    private Timestamp dtEnd;

    private Double qtyProduced;

    private Double metallicLoss;

    private Double theoreticalDurationByPph;

    private Double theoreticalDurationByPphForCalculation;

    /* Methods */
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcodEquipment() {
        return this.codEquipment;
    }

    public void setcodEquipment(String codEquipment) {
        this.codEquipment = codEquipment;
    }

    public String getidEquipmentStatus() {
        return this.idEquipmentStatus;
    }

    public void setidEquipmentStatus(String idEquipmentStatus) {
        this.idEquipmentStatus = idEquipmentStatus;
    }

    public String getcodShift() {
        return this.codShift;
    }

    public void setcodShift(String codShift) {
        this.codShift = codShift;
    }

    public String getcodCrew() {
        return this.codCrew;
    }

    public void setcodCrew(String codCrew) {
        this.codCrew = codCrew;
    }

    public Boolean isequipmentStatusMode() {
        return this.equipmentStatusMode;
    }

    public Boolean getequipmentStatusMode() {
        return this.equipmentStatusMode;
    }

    public void setequipmentStatusMode(Boolean equipmentStatusMode) {
        this.equipmentStatusMode = equipmentStatusMode;
    }

    public Double getunplannedTime() {
        return this.unplannedTime;
    }

    public void setunplannedTime(Double unplannedTime) {
        this.unplannedTime = unplannedTime;
    }

    public Double getstoppedTime() {
        return this.stoppedTime;
    }

    public void setstoppedTime(Double stoppedTime) {
        this.stoppedTime = stoppedTime;
    }

    public Double getproductionTime() {
        return this.productionTime;
    }

    public void setproductionTime(Double productionTime) {
        this.productionTime = productionTime;
    }

    public String getidMaterialDefinition() {
        return this.idMaterialDefinition;
    }

    public void setidMaterialDefinition(String idMaterialDefinition) {
        this.idMaterialDefinition = idMaterialDefinition;
    }

    public Timestamp getdtStart() {
        return this.dtStart;
    }

    public void setdtStart(Timestamp dtStart) {
        this.dtStart = dtStart;
    }

    public Timestamp getdtEnd() {
        return this.dtEnd;
    }

    public void setdtEnd(Timestamp dtEnd) {
        this.dtEnd = dtEnd;
    }

    public Double getqtyProduced() {
        return this.qtyProduced;
    }

    public void setqtyProduced(Double qtyProduced) {
        this.qtyProduced = qtyProduced;
    }

    public Double getmetallicLoss() {
        return this.metallicLoss;
    }

    public void setmetallicLoss(Double metallicLoss) {
        this.metallicLoss = metallicLoss;
    }

    public Double gettheoreticalDurationByPph() {
        return this.theoreticalDurationByPph;
    }

    public void settheoreticalDurationByPph(Double theoreticalDurationByPph) {
        this.theoreticalDurationByPph = theoreticalDurationByPph;
    }

    public Double gettheoreticalDurationByPphForCalculation() {
        return this.theoreticalDurationByPphForCalculation;
    }

    public void settheoreticalDurationByPphForCalculation(Double theoreticalDurationByPphForCalculation) {
        this.theoreticalDurationByPphForCalculation = theoreticalDurationByPphForCalculation;
    }
}