package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MCity;
import entity.MCityPK;

public interface MCityDao extends JpaRepository<MCity, MCityPK>{

	@Query("select a from MCity a where a.provId = :provId")
	public List<MCity> findCityByProv(@Param("provId") String provId);
}
