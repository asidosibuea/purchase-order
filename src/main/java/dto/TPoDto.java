package dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class TPoDto {

	private String poNo;
	private String cityId;
	private double discount;
	private String poAddress;
	private Date poDate;
	private Date poExpDate;
	private String poNotes;
	private String poShipment;
	private String supId;
	private double total;
	private String supName;
	private List<TPoDetailDto> detailDtos;

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getPoAddress() {
		return poAddress;
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
		return poNotes;
	}

	public void setPoNotes(String poNotes) {
		this.poNotes = poNotes;
	}

	public String getPoShipment() {
		return poShipment;
	}

	public void setPoShipment(String poShipment) {
		this.poShipment = poShipment;
	}

	public String getSupId() {
		return supId;
	}

	public void setSupId(String supId) {
		this.supId = supId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public List<TPoDetailDto> getDetailDtos() {
		return detailDtos;
	}

	public void setDetailDtos(List<TPoDetailDto> detailDtos) {
		this.detailDtos = detailDtos;
	}
	
	

}
