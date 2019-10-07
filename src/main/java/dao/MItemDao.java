package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MItem;
import entity.MItemPK;

public interface MItemDao extends JpaRepository<MItem, MItemPK>{
	
	@Query("select a from MItem a where a.supId = :supId")
	public List<MItem> findItemBySupplier(@Param("supId") String supId);

}
