package service;

import java.util.List;



import dto.TPoDetailDto;
import dto.TPoDto;
import entity.MCity;
import entity.MItem;
import entity.MProvince;
import entity.MSupplier;

public interface TPoSvc {

	public List<TPoDto> findAllTPo();
	public List<TPoDto> findAllTPoBySearch(String cari);
	public List<MCity> findAllCity();
	public List<MItem> findallItem();
	public List<MProvince> findAllProvince();
	public List<MSupplier> findAllSupplier();
	public List<MCity> findCityByprov(String provId);
	public List<MItem> findItemBySupplier(String supId);
	public MSupplier findOneSupplier(String supId);
	public MCity findOneCity(String cityId);
	public MProvince findOneProvince(String provId);
	public void save(TPoDto dto);
	public List<TPoDetailDto> findOneDetail(String poNo);
	public void delete(TPoDto dto);
	
}
