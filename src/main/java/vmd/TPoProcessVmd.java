package vmd;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.Button;
import org.zkoss.zul.Messagebox.ClickEvent;

import dto.TPoDetailDto;
import dto.TPoDto;
import entity.MCity;
import entity.MItem;
import entity.MProvince;
import entity.MSupplier;
import service.TPoSvc;

@VariableResolver(DelegatingVariableResolver.class)
public class TPoProcessVmd {

	@WireVariable
	private TPoSvc tPoSvc;

	private List<MSupplier> listSupplier = new LinkedList<MSupplier>();
	private List<MProvince> listProvince = new LinkedList<>();
	private List<MCity> listCities = new LinkedList<>();
	private List<TPoDetailDto> listPoDetail = new LinkedList<>();
	private List<MItem> listItems = new LinkedList<>();

	private MSupplier supplier = new MSupplier();
	private MProvince province = new MProvince();
	private MCity city = new MCity();
	private MItem item = new MItem();

	private TPoDto poDto = new TPoDto();
	private TPoDetailDto detailDto = new TPoDetailDto();
	
	private long aging;
	private boolean popUp = false;

	public List<MSupplier> getListSupplier() {
		return listSupplier;
	}

	public void setListSupplier(List<MSupplier> listSupplier) {
		this.listSupplier = listSupplier;
	}

	public List<MProvince> getListProvince() {
		return listProvince;
	}

	public void setListProvince(List<MProvince> listProvince) {
		this.listProvince = listProvince;
	}

	public List<MCity> getListCities() {
		return listCities;
	}

	public void setListCities(List<MCity> listCities) {
		this.listCities = listCities;
	}

	public List<TPoDetailDto> getListPoDetail() {
		return listPoDetail;
	}

	public void setListPoDetail(List<TPoDetailDto> listPoDetail) {
		this.listPoDetail = listPoDetail;
	}

	public MSupplier getSupplier() {
		return supplier;
	}

	public void setSupplier(MSupplier supplier) {
		this.supplier = supplier;
	}

	public MProvince getProvince() {
		return province;
	}

	public void setProvince(MProvince province) {
		this.province = province;
	}

	public MCity getCity() {
		return city;
	}

	public void setCity(MCity city) {
		this.city = city;
	}

	public TPoDto getPoDto() {
		return poDto;
	}

	public void setPoDto(TPoDto poDto) {
		this.poDto = poDto;
	}

	public TPoDetailDto getDetailDto() {
		return detailDto;
	}

	public void setDetailDto(TPoDetailDto detailDto) {
		this.detailDto = detailDto;
	}

	public long getAging() {
		return aging;
	}

	public void setAging(long aging) {
		this.aging = aging;
	}

	public List<MItem> getListItems() {
		return listItems;
	}

	public void setListItems(List<MItem> listItems) {
		this.listItems = listItems;
	}

	public MItem getItem() {
		return item;
	}

	public void setItem(MItem item) {
		this.item = item;
	}

	public boolean isPopUp() {
		return popUp;
	}

	public void setPopUp(boolean popUp) {
		this.popUp = popUp;
	}

	@Init
	public void loadForm(){
		if(Sessions.getCurrent().getAttribute("editSession") != null){
			poDto = (TPoDto) Sessions.getCurrent().getAttribute("editSession");
			city = tPoSvc.findOneCity(poDto.getCityId());
			province = tPoSvc.findOneProvince(city.getProvId());
			supplier = tPoSvc.findOneSupplier(poDto.getSupId());
			listPoDetail = poDto.getDetailDtos();
		}
		listSupplier = tPoSvc.findAllSupplier();
		listProvince = tPoSvc.findAllProvince();
		listCities = tPoSvc.findAllCity();
		listItems = tPoSvc.findallItem();
		
	}
	
	@Command
	@NotifyChange({"listCities", "city"})
	public void selectProvince(){
		listCities = tPoSvc.findCityByprov(province.getProvId());
		city = null;
	}
	
	@Command
	public void kembali(){
		Sessions.getCurrent().removeAttribute("editSession");
		Executions.sendRedirect("/page/PO_index.zul");
	}
	
	@Command
	public void simpan(){
		
		Messagebox.show("Apakah anda yakin ingin menyimpan ?",
                "perhatian",
                new Button[] { Button.YES, Button.NO },
                Messagebox.QUESTION, Button.NO,
                new EventListener<Messagebox.ClickEvent>() {
                    @Override
                    public void onEvent(ClickEvent event)
                            throws Exception {
                        // TODO Auto-generated method stub
                        if (Messagebox.ON_YES.equals(event.getName())) {
                        	poDto.setCityId(city.getCityId());
                    		poDto.setSupId(supplier.getSupId());
                    		poDto.setPoAddress(supplier.getSupAddress());
                    		poDto.setDetailDtos(listPoDetail);
                    		tPoSvc.save(poDto);
                    		Sessions.getCurrent().removeAttribute("editSession");
                    		Executions.sendRedirect("/page/PO_index.zul");
                            Clients.showNotification(
                                    "Data berhasil di simpan",
                                    Clients.NOTIFICATION_TYPE_INFO, null,
                                    null, 500);
                           /* BindUtils.postNotifyChange(null, null,
                                    MstCustomerDetailVmd.this,
                                    "customerDto");*/
                        }

                    }
                });
		
		
	}
	
	@Command
	@NotifyChange("aging")
	public void calculateAging(){
		long diff = this.poDto.getPoExpDate().getTime() - this.poDto.getPoDate().getTime();
		
		this.aging = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	@Command
	@NotifyChange("detailDto")
	public void hitungSubtotal(){
		long subtotal = this.detailDto.getItemQty() * this.item.getItemPrice();
		this.detailDto.setSubtotal(subtotal);
	}
	
	@Command
	@NotifyChange({"popUp", "detailDto"})
	public void addItem(){
		if( supplier.getSupName() == null || poDto.getPoNo() == null)
			Messagebox.show("Silahkan Isi Po.No dan Supplier Terlebih Dahulu");
		else {
			this.item = new MItem();
			this.detailDto = new TPoDetailDto();
			setPopUp(true);
		}
	}
	
	@Command
	@NotifyChange({"popUp", "detailDto",  "listPoDetail", "poDto"})
	public void saveDetail(){
		
		if(this.item.getItemId() == null || this.detailDto.getItemQty() == 0){
			Messagebox.show("Silahkan pilih product ");
		} else {
			detailDto.setItemId(item.getItemId());
			detailDto.setItemName(item.getItemName());
			detailDto.setItemPrice(item.getItemPrice());
			listPoDetail.add(detailDto);
			item = new MItem();
			
			long subtotalz = 0;
			for(TPoDetailDto dto : listPoDetail){
				subtotalz += dto.getSubtotal();
			}
			double totalz = subtotalz - (poDto.getDiscount() / 100) * subtotalz;
			poDto.setTotal(totalz);
            setPopUp(false);
					
		}
	}
	
	@Command
	@NotifyChange({"popUp", "detailDto", "item"})
	public void backDetail(){
		this.detailDto = new TPoDetailDto();
		this.item = new MItem();
		this.setPopUp(false);
	}
	
	@Command
	@NotifyChange("poDto")
	public void calculateTotal(){
		long subtotalz = 0;
		for(TPoDetailDto dto : listPoDetail){
			subtotalz += dto.getSubtotal();
		}
		double totalz = subtotalz - (this.poDto.getDiscount() / 100) * subtotalz;
		this.poDto.setTotal(totalz);
	}
	
	@Command
	@NotifyChange("listPoDetail")
	public void deleteItem(){
		if(this.detailDto == null){
			Messagebox.show("Silahkan pilih item ");
		} else{
			
			listPoDetail.remove(detailDto);
        	Executions.sendRedirect("/page/PO_process.zul");
		}
	}
}
