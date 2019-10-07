package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.TPoDetail;
import entity.TPoDetailPK;

public interface TPoDetailDao extends JpaRepository<TPoDetail, TPoDetailPK> {

	@Modifying
	@Query("delete from TPoDetail d where d.poNo = :poNo")
	public void deleteByPoNo(@Param("poNo") String poNo);

	@Query("select d,i.itemName from TPoDetail d, MItem i "
			+ "where d.itemId = i.itemId AND d.poNo = :poNo")
	public List<Object[]> findAllDetail(@Param("poNo") String poNo);

}
