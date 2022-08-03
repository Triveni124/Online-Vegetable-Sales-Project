import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewvegetableByCategoryComponent } from './viewvegetable-by-category.component';

describe('ViewvegetableByCategoryComponent', () => {
  let component: ViewvegetableByCategoryComponent;
  let fixture: ComponentFixture<ViewvegetableByCategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewvegetableByCategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewvegetableByCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
