import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddvegetableComponent } from './addvegetable.component';

describe('AddvegetableComponent', () => {
  let component: AddvegetableComponent;
  let fixture: ComponentFixture<AddvegetableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddvegetableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddvegetableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
