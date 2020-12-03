package haj.com.workflow.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import haj.com.workflow.entity.CovoidCases;
import haj.com.workflow.service.ModelService;

@RestController
public class WorkflowController {

	protected final Log  logger = LogFactory.getLog(this.getClass());
	@Autowired
	private ModelService modelService;

	@RequestMapping("/hello")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "Hello " + name;
	}

	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "/loadjson", method = RequestMethod.GET)
	public String loadjson(@RequestParam(value = "json") String key) {
		logger.info("GET: /loadjson : json: " + key);
		String      json = "";
		CovoidCases cc   = new Gson().fromJson(key, CovoidCases.class);
		try {
			List<CovoidCases> ccExisting = modelService.findByCountryOther(cc.getCountryOther());
			if (!ccExisting.isEmpty()) {
				CovoidCases cce = ccExisting.get(0);
				Long        id  = cce.getId();
				BeanUtils.copyProperties(cc, cce);
				cce.setId(id);
				modelService.save(cce);
			} else {
				modelService.save(cc);
			}
		} catch (Exception e) {
			logger.fatal(e.getMessage(), e);
		}
		return json;
	}

	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "/getcases", method = RequestMethod.GET)
	public String getCases() {
		logger.info("GET: /getcases");
		List<CovoidCases>     result   = new ArrayList<>();
		Iterable<CovoidCases> iterable = modelService.findAll();
		iterable.forEach(result::add);
		return new Gson().toJson(result);
	}

	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "/getnewcases", method = RequestMethod.GET)
	public String getNewCases() {
		logger.info("GET: /getcases");
		List<CovoidCases>     result   = new ArrayList<>();
		Iterable<CovoidCases> iterable = modelService.findByNewCasesNotNull();
		iterable.forEach(result::add);
		return new Gson().toJson(result);
	}

	@CrossOrigin(origins = "*")
	@ResponseBody
	@RequestMapping(value = "/findGlobalValue", method = RequestMethod.GET)
	public String findGlobalValue() {
		logger.info("GET: /findGlobalValue");
		CovoidCases       cc         = null;
		List<CovoidCases> ccExisting = modelService.findByCountryOther("World");
		if (!ccExisting.isEmpty()) {
			cc = ccExisting.get(0);
		}
		return new Gson().toJson(cc);
	}

}
