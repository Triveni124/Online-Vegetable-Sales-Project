import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VieworderlistComponent } from './vieworderlist.component';

describe('VieworderlistComponent', () => {
  let component: VieworderlistComponent;
  let fixture: ComponentFixture<VieworderlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VieworderlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VieworderlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
