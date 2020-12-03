import { Component, OnInit, Input } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { NavParams } from '@ionic/angular';

@Component({
  selector: 'app-virus-modal',
  templateUrl: './virus-modal.page.html',
  styleUrls: ['./virus-modal.page.scss'],
})
export class VirusModalPage implements OnInit {

  @Input() country: string;

  constructor(public modalController: ModalController) { }

  ngOnInit() {
  }
  dismiss() {
    // using the injected ModalController this page
    // can "dismiss" itself and optionally pass back data
    this.modalController.dismiss({
      'dismissed': true
    });
  }
}
