import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Countries } from '../constants';
import { ModalController } from '@ionic/angular';
import { VirusModalPage } from '../virus-modal/virus-modal.page';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {
  global: any;
  constructor(public modalController: ModalController, public countries : Countries, private http: HttpClient) {
    let data = this.http.get('http://54.212.120.20:8090/findGlobalValue').subscribe(resp => {
      this.global = resp
      console.log(resp)
    });
    this.countries.getAllCases(null)
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
