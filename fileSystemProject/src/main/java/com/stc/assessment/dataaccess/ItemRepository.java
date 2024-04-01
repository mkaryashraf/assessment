package com.stc.assessment.dataaccess;

import com.stc.assessment.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
   Item findByName(String itemName);

   @Query("select it from Item it where it.name= :itemName and it.parent.name= :parentName")
   Optional<Item> findByNameAndParentName(@Param("itemName") String itemName,@Param("parentName") String parentName);

   Item findByNameAndType( String name, String type);
}
