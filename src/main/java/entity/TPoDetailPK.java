package entity;

import java.io.Serializable;


/**
 * The primary key class for the t_po_detail database table.
 * 
 */

public class TPoDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String poNo;
	private String itemId;

	public TPoDetailPK() {
	}
	public String getPoNo() {
		return this.poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	public String getItemId() {
		return this.itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TPoDetailPK)) {
			return false;
		}
		TPoDetailPK castOther = (TPoDetailPK)other;
		return 
			this.poNo.equals(castOther.poNo)
			&& this.itemId.equals(castOther.itemId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.poNo.hashCode();
		hash = hash * prime + this.itemId.hashCode();
		
		return hash;
	}
}