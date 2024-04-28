package au.com.telstra.simcardactivator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.simcardactivator.Dao.SimCardDAO;
import au.com.telstra.simcardactivator.Model.ActuationResult;
import au.com.telstra.simcardactivator.Model.SimCardModel;


@RestController
public class SimCardActivationController {
	
    private final RestTemplate restTemplate;
    
    private final SimCardDAO simcarddao;
	
	public SimCardActivationController(SimCardDAO simcarddao,RestTemplate restTemplate) {
        this.simcarddao=simcarddao;
		this.restTemplate = restTemplate;
    }

	@PostMapping("/simcardactivation")
	public void activateSim(@RequestBody SimCardModel simcardmodelrequest) {
		try {			
			var actuationResult = getAcutate(simcardmodelrequest);
			simcarddao.save(simcardmodelrequest,actuationResult);	        
		}
		catch(Exception e) {
			e.printStackTrace();
	      }
		
	}
	
	public ActuationResult getAcutate(SimCardModel simcardmodelrequest)
	{
		return restTemplate.postForObject("http://localhost:8444/actuate",simcardmodelrequest,ActuationResult.class);
	}
	
	@GetMapping("/query")
	public SimCardModel activeSimCard(@RequestParam Long simCardId) {
		return simcarddao.querySimCard(simCardId);
	}
	
}
