package entity;

import java.io.Serializable;

public class TPoPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String poNo;

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((poNo == null) ? 0 : poNo.hashCode());
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
		TPoPK other = (TPoPK) obj;
		if (poNo == null) {
			if (other.poNo != null)
				return false;
		} else if (!poNo.equals(other.poNo))
			return false;
		return true;
	}

}
