package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the m_item database table.
 * 
 */
@Entity
@Table(name="m_item")
@NamedQuery(name="MItem.findAll", query="SELECT m FROM MItem m")
@IdClass(MItemPK.class)
public class MItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="item_id")
	private String itemId;

	@Column(name="item_name")
	private String itemName;

	@Column(name="item_price")
	private int itemPrice;

	@Column(name="sup_id")
	private String supId;

	public MItem() {
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return this.itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getSupId() {
		return this.supId;
	}

	public void setSupId(String supId) {
		this.supId = supId;
	}

}