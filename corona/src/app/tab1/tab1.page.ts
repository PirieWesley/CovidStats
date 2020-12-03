import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ModalController } from '@ionic/angular';
import { VirusModalPage } from '../virus-modal/virus-modal.page';
import { Storage } from '@ionic/storage';
import { Countries } from '../constants';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {
  constructor(public countries : Countries, private http: HttpClient, public modalController: ModalController, private storage: Storage) {
    this.countries.getAllCases(null)
  }
  
  doRefresh(event) {
    this.countries = undefined;
    this.countries.getAllCases(event)
  }

  filterList(evt: any) {
    this.countries.initializeFilteredItems()
    const searchTerm = evt.srcElement.value;
    if (!searchTerm) {
      return;
    }

    this.countries.filteredCountries = this.countries.filteredCountries.filter(country => {
      if (country['Country,Other'] && searchTerm) {
        if (country['Country,Other'].toLowerCase().indexOf(searchTerm.toLowerCase()) > -1) {
          return true;
        }
        return false;
      }
    });
  }

  async presentModal(country: any) {
    const modal = await this.modalController.create({
      component: VirusModalPage,
      componentProps: {
        'country': country
      }
    });
    return await modal.present();
  }
}
// ActiveCases: "7,263"
// "Country,Other": "China"
// NewCases: "+34"
// NewDeaths: "+8"
// "Serious,Critical": "2,274"
// TotalCases: "80,928"
// TotalDeaths: "3,245"
// TotalRecovered: "70,420"
// "Tot Cases/1M pop": "56"
// id: 130