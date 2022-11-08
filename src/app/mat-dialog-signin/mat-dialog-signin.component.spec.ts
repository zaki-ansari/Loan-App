import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatDialogSigninComponent } from './mat-dialog-signin.component';

describe('MatDialogSigninComponent', () => {
  let component: MatDialogSigninComponent;
  let fixture: ComponentFixture<MatDialogSigninComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatDialogSigninComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatDialogSigninComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
