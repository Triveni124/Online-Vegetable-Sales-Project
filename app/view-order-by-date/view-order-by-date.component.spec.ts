import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewOrderByDateComponent } from './view-order-by-date.component';

describe('ViewOrderByDateComponent', () => {
  let component: ViewOrderByDateComponent;
  let fixture: ComponentFixture<ViewOrderByDateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewOrderByDateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewOrderByDateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
