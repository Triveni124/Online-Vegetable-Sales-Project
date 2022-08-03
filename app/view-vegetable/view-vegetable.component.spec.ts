import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewVegetableComponent } from './view-vegetable.component';

describe('ViewVegetableComponent', () => {
  let component: ViewVegetableComponent;
  let fixture: ComponentFixture<ViewVegetableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewVegetableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewVegetableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
