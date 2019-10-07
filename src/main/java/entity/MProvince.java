package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the m_province database table.
 * 
 */
@Entity
@Table(name="m_province")
@NamedQuery(name="MProvince.findAll", query="SELECT m FROM MProvince m")
@IdClass(MProvincePK.class)
public class MProvince implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="prov_id")
	private String provId;

	@Column(name="prov_name")
	private String provName;

	public MProvince() {
	}

	public String getProvId() {
		return this.provId;
	}

	public void setProvId(String provId) {
		this.provId = provId;
	}

	public String getProvName() {
		return this.provName;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

}