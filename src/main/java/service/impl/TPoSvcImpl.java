package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MCityDao;
import dao.MItemDao;
import dao.MProvinceDao;
import dao.MSupplierDao;
import dao.TPoDao;
import dao.TPoDetailDao;
import dto.TPoDetailDto;
import dto.TPoDto;
import entity.MCity;
import entity.MCityPK;
import entity.MItem;
import entity.MProvince;
import entity.MProvincePK;
import entity.MSupplier;
import entity.MSupplierPK;
import entity.TPo;
import entity.TPoDetail;
import entity.TPoPK;
import service.TPoSvc;

@Transactional
@Service("tPoSvc")
public class TPoSvcImpl implements TPoSvc {

	@Autowired
	private TPoDao tPoDao;

	@Autowired
	private MCityDao mCityDao;

	@Autowired
	private MProvinceDao mProvinceDao;

	@Autowired
	private MSupplierDao mSupplierDao;

	@Autowired
	private MItemDao mItemDao;

	@Autowired
	private TPoDetailDao tPoDetailDao;

	@Override
	public List<TPoDto> findAllTPo() {
		// TODO Auto-generated method stub
		List<Object[]> list = tPoDao.findAllPo();
		List<TPoDto> dtos = new ArrayList<>();
		for (Object[] o : list) {
			TPoDto dto = new TPoDto();
			TPo p = (TPo) o[0];
			String supName = (String) o[1];
			dto.setCityId(p.getCityId());
			dto.setDiscount(p.getDiscount());
			dto.setPoAddress(p.getPoAddress());
			dto.setPoDate(p.getPoDate());
			dto.setPoExpDate(p.getPoExpDate());
			dto.setPoNo(p.getPoNo());
			dto.setPoNotes(p.getPoNotes());
			dto.setPoShipment(p.getPoShipment());
			dto.setSupId(p.getSupId());
			dto.setTotal(p.getTotal());
			dto.setSupName(supName);
			List<Object[]> listDtl = tPoDetailDao.findAllDetail(dto.getPoNo());
			List<TPoDetailDto> detailDtos = new ArrayList<>();
			for (Object[] dtl : listDtl) {
				TPoDetail d = (TPoDetail) dtl[0];
				String itemName = (String) dtl[1];
				TPoDetailDto dt = new TPoDetailDto();
				dt.setItemId(d.getItemId());
				dt.setItemName(itemName);
				dt.setItemPrice(d.getItemPrice());
				dt.setItemQty(d.getItemQty());
				dt.setPoNo(d.getPoNo());
				dt.setSubtotal(d.getSubtotal());
				detailDtos.add(dt);
			}
			dto.setDetailDtos(detailDtos);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<MCity> findCityByprov(String provId) {
		// TODO Auto-generated method stub
		List<MCity> list = mCityDao.findCityByProv(provId);
		return list;
	}

	@Override
	public List<MCity> findAllCity() {
		// TODO Auto-generated method stub
		return mCityDao.findAll();
	}

	@Override
	public List<MProvince> findAllProvince() {
		// TODO Auto-generated method stub
		return mProvinceDao.findAll();
	}

	@Override
	public List<MSupplier> findAllSupplier() {
		// TODO Auto-generated method stub
		return mSupplierDao.findAll();
	}

	@Override
	public List<TPoDto> findAllTPoBySearch(String cari) {
		List<Object[]> list = tPoDao.findAllPoBySearch(cari);
		List<TPoDto> dtos = new ArrayList<>();
		for (Object[] o : list) {
			TPoDto dto = new TPoDto();
			TPo p = (TPo) o[0];
			String supName = (String) o[1];
			dto.setCityId(p.getCityId());
			dto.setDiscount(p.getDiscount());
			dto.setPoAddress(p.getPoAddress());
			dto.setPoDate(p.getPoDate());
			dto.setPoExpDate(p.getPoExpDate());
			dto.setPoNo(p.getPoNo());
			dto.setPoNotes(p.getPoNotes());
			dto.setPoShipment(p.getPoShipment());
			dto.setSupId(p.getSupId());
			dto.setTotal(p.getTotal());
			dto.setSupName(supName);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<MItem> findItemBySupplier(String supId) {
		// TODO Auto-generated method stub

		return mItemDao.findItemBySupplier(supId);
	}

	@Override
	public void save(TPoDto dto) {
		// TODO Auto-generated method stub
		TPo po = new TPo();
		po.setCityId(dto.getCityId());
		po.setDiscount(dto.getDiscount());
		po.setPoAddress(dto.getPoAddress());
		po.setPoDate(dto.getPoDate());
		po.setPoExpDate(dto.getPoExpDate());
		po.setPoNo(dto.getPoNo());
		po.setPoNotes(dto.getPoNotes());
		po.setPoShipment(dto.getPoShipment());
		po.setSupId(dto.getSupId());
		po.setTotal(dto.getTotal());
		tPoDetailDao.deleteByPoNo(dto.getPoNo());
		List<TPoDetailDto> listDtl = dto.getDetailDtos();
		for (TPoDetailDto dtoDtl : listDtl) {
			TPoDetail dtl = new TPoDetail();
			dtl.setItemId(dtoDtl.getItemId());
			dtl.setItemPrice(dtoDtl.getItemPrice());
			dtl.setItemQty(dtoDtl.getItemQty());
			dtl.setPoNo(dto.getPoNo());
			dtl.setSubtotal(dtoDtl.getSubtotal());
			tPoDetailDao.save(dtl);
		}
		tPoDao.save(po);
	}

	@Override
	public MSupplier findOneSupplier(String supId) {
		// TODO Auto-generated method stub
		MSupplierPK pk = new MSupplierPK();
		pk.setSupId(supId);
		MSupplier sup = mSupplierDao.findOne(pk);
		return sup;
	}

	@Override
	public MCity findOneCity(String cityId) {
		// TODO Auto-generated method stub
		MCityPK pk = new MCityPK();
		pk.setCityId(cityId);
		MCity city = mCityDao.findOne(pk);
		return city;
	}

	@Override
	public MProvince findOneProvince(String provId) {
		// TODO Auto-generated method stub
		MProvincePK pk = new MProvincePK();
		pk.setProvId(provId);
		MProvince prov = mProvinceDao.findOne(pk);
		return prov;
	}

	@Override
	public List<TPoDetailDto> findOneDetail(String poNo) {
		// TODO Auto-generated method stub
		List<Object[]> listDtl = tPoDetailDao.findAllDetail(poNo);
		List<TPoDetailDto> detailDtos = new ArrayList<>();
		for (Object[] dtl : listDtl) {
			TPoDetail d = (TPoDetail) dtl[0];
			String itemName = (String) dtl[1];
			TPoDetailDto dt = new TPoDetailDto();
			dt.setItemId(d.getItemId());
			dt.setItemName(itemName);
			dt.setItemPrice(d.getItemPrice());
			dt.setItemQty(d.getItemQty());
			dt.setPoNo(d.getPoNo());
			dt.setSubtotal(d.getSubtotal());
			detailDtos.add(dt);
		}
		return detailDtos;
	}

	@Override
	public List<MItem> findallItem() {
		// TODO Auto-generated method stub
		return mItemDao.findAll();
	}

	@Override
	public void delete(TPoDto dto) {
		// TODO Auto-generated method stub
		TPoPK pk = new TPoPK();
		pk.setPoNo(dto.getPoNo());
		tPoDetailDao.deleteByPoNo(dto.getPoNo());
		tPoDao.delete(pk);
		
	}

}
