import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayloansComponent } from './displayloans.component';

describe('DisplayloansComponent', () => {
  let component: DisplayloansComponent;
  let fixture: ComponentFixture<DisplayloansComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayloansComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayloansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
