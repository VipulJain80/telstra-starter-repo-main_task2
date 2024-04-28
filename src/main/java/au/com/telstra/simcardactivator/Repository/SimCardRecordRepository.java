package au.com.telstra.simcardactivator.Repository;

import org.springframework.data.repository.CrudRepository;

import au.com.telstra.simcardactivator.Entity.SimCardRecord;

public interface SimCardRecordRepository extends CrudRepository<SimCardRecord, Long>{

}
