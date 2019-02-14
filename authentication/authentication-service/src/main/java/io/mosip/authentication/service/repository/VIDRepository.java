package io.mosip.authentication.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.mosip.authentication.service.entity.VIDEntity;
import io.mosip.kernel.core.dataaccess.spi.repository.BaseRepository;

/**
 * The Interface VIDRepository is used to fetch VIDEntity.
 *  @author Rakesh Roshan
 */
@Repository
public interface VIDRepository extends BaseRepository<VIDEntity, String> {
	
	@Query("Select uin from VIDEntity where id = :vidNumber")
	Optional<String> findUinByVid(@Param("vidNumber") String uinRefId);
	
	@Query(value="SELECT * FROM ida.vid where uin=:uin ORDER BY generated_dtimes DESC",nativeQuery=true)
	List<VIDEntity> findByUIN(@Param("uin") String uin,Pageable pagaeable);
	
	@Query(value="Select VIDEntity where uin = :uin order by generatedOn desc",nativeQuery=true)
	List<VIDEntity> findByUIN(@Param("uin") String uin);
}
