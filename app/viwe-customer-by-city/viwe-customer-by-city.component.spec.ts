import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViweCustomerByCityComponent } from './viwe-customer-by-city.component';

describe('ViweCustomerByCityComponent', () => {
  let component: ViweCustomerByCityComponent;
  let fixture: ComponentFixture<ViweCustomerByCityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViweCustomerByCityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViweCustomerByCityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
