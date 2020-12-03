package haj.com.workflow.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import haj.com.workflow.entity.CovoidCases;


public interface ModelService extends CrudRepository<CovoidCases, Integer> {

	public List<CovoidCases> findByCountryOther(String countryOther);
	public List<CovoidCases> findByNewCasesNotNull();
	@Query(nativeQuery = true, value = "select 1 as id, 'World Wide' as country_other , sum(REPLACE(total_cases, ',', '')) as total_cases , sum(REPLACE(active_cases, ',', '')) as active_cases , sum(REPLACE(total_deaths, ',', '')) as total_deaths , sum(REPLACE(total_recovered, ',', '')) as total_recovered , sum(REPLACE(serious_critical, ',', '')) as serious_critical , sum(REPLACE(new_deaths, ',', '')) as new_deaths , sum(REPLACE(new_cases, ',', '')) as new_cases , sum(REPLACE(tot_cases1mpop, ',', '')) as tot_cases1mpop from covoid_cases")
	public CovoidCases findGlobalValue();
}
