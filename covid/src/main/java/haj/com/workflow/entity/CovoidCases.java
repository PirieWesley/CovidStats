package haj.com.workflow.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "covoid_cases")
public class CovoidCases {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@SerializedName("Country,Other")
	@Expose
	private String countryOther;

	@SerializedName("TotalCases")
	@Expose
	private String totalCases;

	@SerializedName("NewCases")
	@Expose
	private String newCases;

	@SerializedName("TotalDeaths")
	@Expose
	private String totalDeaths;

	@SerializedName("NewDeaths")
	@Expose
	private String newDeaths;

	@SerializedName("TotalRecovered")
	@Expose
	private String totalRecovered;

	@SerializedName("ActiveCases")
	@Expose
	private String activeCases;

	@SerializedName("Serious,Critical")
	@Expose
	private String seriousCritical;

	@SerializedName("Tot\u00a0Cases/1M pop")
	@Expose
	private String totCases1MPop;

	public String getCountryOther() {
		return countryOther;
	}

	public void setCountryOther(String countryOther) {
		this.countryOther = countryOther;
	}

	public String getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(String totalCases) {
		this.totalCases = totalCases;
	}

	public String getNewCases() {
		return newCases;
	}

	public void setNewCases(String newCases) {
		this.newCases = newCases;
	}

	public String getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(String totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public String getNewDeaths() {
		return newDeaths;
	}

	public void setNewDeaths(String newDeaths) {
		this.newDeaths = newDeaths;
	}

	public String getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public String getActiveCases() {
		return activeCases;
	}

	public void setActiveCases(String activeCases) {
		this.activeCases = activeCases;
	}

	public String getSeriousCritical() {
		return seriousCritical;
	}

	public void setSeriousCritical(String seriousCritical) {
		this.seriousCritical = seriousCritical;
	}

	public String getTotCases1MPop() {
		return totCases1MPop;
	}

	public void setTotCases1MPop(String totCases1MPop) {
		this.totCases1MPop = totCases1MPop;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
