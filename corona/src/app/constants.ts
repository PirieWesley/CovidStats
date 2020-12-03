import { HttpClient } from '@angular/common/http';
import { Storage } from '@ionic/storage';
import {Injectable} from '@angular/core';

@Injectable()
export class Countries {

    allcountries: any;
    countries: any;
    newcountries: any;
    filteredCountries: any;
    pinnedCountries: any;
    pinnedCountryNames: string[];
    onlyNewCases;

    constructor(private http: HttpClient, private storage: Storage) {
      }

    getAllCases(event) {
        let data = this.http.get('http://54.212.120.20:8090/getcases').subscribe(resp => {
            this.allcountries = resp;
            this.findPinnedCountries()
            if (event) {
                event.target.complete();
            }
        });
    }
    initializeFilteredItems() {
        if (this.onlyNewCases) {
            this.onlyNewCountries()
        } else {
            this.filteredCountries = this.countries;
            this.newcountries = this.filteredCountries.filter(country => {
                return country.NewCases;
            });
        }
    }
    onlyNewCountries() {
        if (this.onlyNewCases) {
            this.filteredCountries = this.newcountries;
        } else {
            this.filteredCountries = this.countries;
        }
    }

    findPinnedCountries() {
        this.storage.get('pinnedCountries').then((val) => {
            this.pinnedCountryNames = val;
            if (val) {
                this.pinnedCountries = this.allcountries.filter(country => {
                    if (country['Country,Other']) {
                        if (val.indexOf(country['Country,Other']) > -1) {
                            return true;
                        }
                        return false;
                    }
                });
                this.countries = this.allcountries.filter(country => {
                    if (val && country['Country,Other']) {
                        if (val.indexOf(country['Country,Other']) > -1) {
                            return false;
                        }
                        return true;
                    }
                });
            } else {
                this.countries = this.allcountries
            }

            this.initializeFilteredItems()
        });

    }

    addPinnedCountries(countryName: string) {
        if (!this.pinnedCountryNames) this.pinnedCountryNames = [countryName];
        else this.pinnedCountryNames.push(countryName);
        this.storage.set('pinnedCountries', this.pinnedCountryNames).then((val) => { this.findPinnedCountries(); });
    }

    removePinnedCountry(countryName: string) {
        this.pinnedCountryNames = this.pinnedCountryNames.filter(country => {
            if (country.toLowerCase().indexOf(countryName.toLowerCase()) > -1) {
                return false;
            }
            return true;
        });
        this.storage.set('pinnedCountries', this.pinnedCountryNames).then((val) => { this.findPinnedCountries(); });
    }
}