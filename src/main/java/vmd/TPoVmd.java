package vmd;

import java.util.List;

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
import dto.TPoDto;
import service.TPoSvc;

@VariableResolver(DelegatingVariableResolver.class)
public class TPoVmd {

	@WireVariable
	private TPoSvc tPoSvc;

	private List<TPoDto> listPO;
	private TPoDto poDto;
	private String pencarian;

	public List<TPoDto> getListPO() {
		return listPO;
	}

	public void setListPO(List<TPoDto> listPO) {
		this.listPO = listPO;
	}

	public TPoDto getPoDto() {
		return poDto;
	}

	public void setPoDto(TPoDto poDto) {
		this.poDto = poDto;
	}

	public String getPencarian() {
		return pencarian;
	}

	public void setPencarian(String pencarian) {
		this.pencarian = pencarian;
	}
	
	@Init
	public void loadDataPO(){
		this.listPO = tPoSvc.findAllTPo();
	}
	
	
	@NotifyChange("listPO")
	@Command
	public void cari() {
		listPO = tPoSvc.findAllTPoBySearch(this.pencarian);
	}
	
	@Command
	public void tambah(){
		this.poDto = new TPoDto();
		Executions.sendRedirect("/page/PO_process.zul");
	}
	
	@Command
	public void edit(){
		if(this.poDto==null){
			Messagebox.show("Silahkan Pilih Data");
		}else{
			Sessions.getCurrent().setAttribute("editSession", this.poDto);
			Executions.sendRedirect("/page/PO_process.zul");
		}
	}
	
	@Command
	public void hapus(){
		if (this.poDto==null){
			Messagebox.show("Silahkan Pilih Data");
		}else{
			Messagebox.show(String.format("Apakah anda yakin ingin menghapus order dengan ID : %s?", this.poDto.getPoNo()),
                    "Peringatan",
                    new Button[] { Button.YES, Button.NO },
                    Messagebox.QUESTION, Button.NO,
                    new EventListener<Messagebox.ClickEvent>() {
                        @Override
                        public void onEvent(ClickEvent event)
                                throws Exception {
                            // TODO Auto-generated method stub
                            if (Messagebox.ON_YES.equals(event.getName())) {
                                tPoSvc.delete(poDto);
                                Executions.sendRedirect("/page/PO_index.zul");
                                Clients.showNotification(
                                        "Data berhasil di hapus",
                                        Clients.NOTIFICATION_TYPE_INFO, null,
                                        null, 500);
                            }
 
                        }
                    });
		}
	}

}
