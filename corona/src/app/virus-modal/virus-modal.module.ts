import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { VirusModalPageRoutingModule } from './virus-modal-routing.module';

import { VirusModalPage } from './virus-modal.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    VirusModalPageRoutingModule
  ],
  declarations: [VirusModalPage]
})
export class VirusModalPageModule {}
