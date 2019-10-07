package entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the t_po_detail database table.
 * 
 */
@Entity
@Table(name = "t_po_detail")
@NamedQuery(name = "TPoDetail.findAll", query = "SELECT t FROM TPoDetail t")
@IdClass(TPoDetailPK.class)
public class TPoDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "po_no")
	private String poNo;
	@Id
	@Column(name = "item_id")
	private String itemId;

	@Column(name = "item_price")
	private int itemPrice;

	@Column(name = "item_qty")
	private int itemQty;

	private double subtotal;

	public TPoDetail() {
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getItemPrice() {
		return this.itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemQty() {
		return this.itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public double getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

}