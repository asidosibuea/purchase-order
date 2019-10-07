package entity;

import java.io.Serializable;

public class MSupplierPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String supId;

	public String getSupId() {
		return supId;
	}

	public void setSupId(String supId) {
		this.supId = supId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((supId == null) ? 0 : supId.hashCode());
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
		MSupplierPK other = (MSupplierPK) obj;
		if (supId == null) {
			if (other.supId != null)
				return false;
		} else if (!supId.equals(other.supId))
			return false;
		return true;
	}

}
