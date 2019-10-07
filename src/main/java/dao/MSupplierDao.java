package dao;


import org.springframework.data.jpa.repository.JpaRepository;

import entity.MSupplier;
import entity.MSupplierPK;

public interface MSupplierDao extends JpaRepository<MSupplier, MSupplierPK>{


}
