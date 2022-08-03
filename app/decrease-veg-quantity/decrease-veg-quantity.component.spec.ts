import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DecreaseVegQuantityComponent } from './decrease-veg-quantity.component';

describe('DecreaseVegQuantityComponent', () => {
  let component: DecreaseVegQuantityComponent;
  let fixture: ComponentFixture<DecreaseVegQuantityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DecreaseVegQuantityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DecreaseVegQuantityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
