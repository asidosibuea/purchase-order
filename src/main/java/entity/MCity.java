package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the m_city database table.
 * 
 */
@Entity
@Table(name="m_city")
@NamedQuery(name="MCity.findAll", query="SELECT m FROM MCity m")
@IdClass(MCityPK.class)
public class MCity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="city_id")
	private String cityId;

	@Column(name="city_name")
	private String cityName;

	@Column(name="prov_id")
	private String provId;

	public MCity() {
	}

	public String getCityId() {
		return this.cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvId() {
		return this.provId;
	}

	public void setProvId(String provId) {
		this.provId = provId;
	}

}