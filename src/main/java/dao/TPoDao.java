package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.TPo;
import entity.TPoPK;

public interface TPoDao extends JpaRepository<TPo,TPoPK> {
	
	@Query("select a,b.supName from TPo a,MSupplier b where a.supId = b.supId ")
	public List<Object[]> findAllPo();

	@Query("select a,b.supName from TPo a,MSupplier b where a.supId = b.supId "
			+ "AND (a.poNo like %:cari% or b.supName like %:cari%) ")
	public List<Object[]> findAllPoBySearch(@Param("cari") String cari);
}
