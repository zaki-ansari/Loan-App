import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatDialogSignupComponent } from './mat-dialog-signup.component';

describe('MatDialogSignupComponent', () => {
  let component: MatDialogSignupComponent;
  let fixture: ComponentFixture<MatDialogSignupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatDialogSignupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatDialogSignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
