import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IncreaseVegQuantityComponent } from './increase-veg-quantity.component';

describe('IncreaseVegQuantityComponent', () => {
  let component: IncreaseVegQuantityComponent;
  let fixture: ComponentFixture<IncreaseVegQuantityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IncreaseVegQuantityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IncreaseVegQuantityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
