import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateBillingDetailsComponent } from './update-billing-details.component';

describe('UpdateBillingDetailsComponent', () => {
  let component: UpdateBillingDetailsComponent;
  let fixture: ComponentFixture<UpdateBillingDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateBillingDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateBillingDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
