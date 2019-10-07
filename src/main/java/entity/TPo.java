package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the t_po database table.
 * 
 */
@Entity
@Table(name = "t_po")
@NamedQuery(name = "TPo.findAll", query = "SELECT t FROM TPo t")
@IdClass(TPoPK.class)
public class TPo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "po_no")
	private String poNo;

	@Column(name = "city_id")
	private String cityId;

	private double discount;

	@Column(name = "po_address")
	private String poAddress;

	@Column(name = "po_date")
	private Date poDate;

	@Column(name = "po_exp_date")
	private Date poExpDate;

	@Column(name = "po_notes")
	private String poNotes;

	@Column(name = "po_shipment")
	private String poShipment;

	@Column(name = "sup_id")
	private String supId;

	private double total;

	public TPo() {
	}

	public String getPoNo() {
		return this.poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getCityId() {
		return this.cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getPoAddress() {
		return this.poAddress;
	}

	public void setPoAddress(String poAddress) {
		this.poAddress = poAddress;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public Date getPoExpDate() {
		return poExpDate;
	}

	public void setPoExpDate(Date poExpDate) {
		this.poExpDate = poExpDate;
	}

	public String getPoNotes() {
		return this.poNotes;
	}

	public void setPoNotes(String poNotes) {
		this.poNotes = poNotes;
	}

	public String getPoShipment() {
		return this.poShipment;
	}

	public void setPoShipment(String poShipment) {
		this.poShipment = poShipment;
	}

	public String getSupId() {
		return this.supId;
	}

	public void setSupId(String supId) {
		this.supId = supId;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}