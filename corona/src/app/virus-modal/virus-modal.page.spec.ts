import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { VirusModalPage } from './virus-modal.page';

describe('VirusModalPage', () => {
  let component: VirusModalPage;
  let fixture: ComponentFixture<VirusModalPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VirusModalPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(VirusModalPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
