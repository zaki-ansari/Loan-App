import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayschedulesComponent } from './displayschedules.component';

describe('DisplayschedulesComponent', () => {
  let component: DisplayschedulesComponent;
  let fixture: ComponentFixture<DisplayschedulesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayschedulesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayschedulesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
