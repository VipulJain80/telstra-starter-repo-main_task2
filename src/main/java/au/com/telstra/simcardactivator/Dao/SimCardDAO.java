package au.com.telstra.simcardactivator.Dao;

import org.springframework.stereotype.Component;

import au.com.telstra.simcardactivator.Entity.SimCardRecord;
import au.com.telstra.simcardactivator.Model.ActuationResult;
import au.com.telstra.simcardactivator.Model.SimCardModel;
import au.com.telstra.simcardactivator.Repository.SimCardRecordRepository;

@Component
public class SimCardDAO {
	
    private final SimCardRecordRepository simCardRecordRepository;
    
    public SimCardDAO(SimCardRecordRepository simCardRecordRepository)
    {
        this.simCardRecordRepository = simCardRecordRepository;
    }


    public void save(SimCardModel simCard,ActuationResult actuationResult) {
        SimCardRecord simCardRecord = new SimCardRecord(simCard, actuationResult);
        simCardRecordRepository.save(simCardRecord);
    }

    public SimCardModel querySimCard(long simCardId) {
        var simCardRecord = simCardRecordRepository.findById(simCardId).orElse(null);
        if (simCardRecord == null) {
            return null;
        }
        return new SimCardModel(simCardRecord);
    }
}
