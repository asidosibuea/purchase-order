package entity;

import java.io.Serializable;

public class MProvincePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String provId;

	public String getProvId() {
		return provId;
	}

	public void setProvId(String provId) {
		this.provId = provId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((provId == null) ? 0 : provId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MProvincePK other = (MProvincePK) obj;
		if (provId == null) {
			if (other.provId != null)
				return false;
		} else if (!provId.equals(other.provId))
			return false;
		return true;
	}

}
