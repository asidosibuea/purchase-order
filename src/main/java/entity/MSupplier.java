package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the m_supplier database table.
 * 
 */
@Entity
@Table(name="m_supplier")
@NamedQuery(name="MSupplier.findAll", query="SELECT m FROM MSupplier m")
@IdClass(MSupplierPK.class)
public class MSupplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sup_id")
	private String supId;

	@Column(name="sup_address")
	private String supAddress;

	@Column(name="sup_name")
	private String supName;

	public MSupplier() {
	}

	public String getSupId() {
		return this.supId;
	}

	public void setSupId(String supId) {
		this.supId = supId;
	}

	public String getSupAddress() {
		return this.supAddress;
	}

	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}

	public String getSupName() {
		return this.supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

}