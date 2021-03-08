import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevacancionComponent } from './nuevacancion.component';

describe('NuevacancionComponent', () => {
  let component: NuevacancionComponent;
  let fixture: ComponentFixture<NuevacancionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NuevacancionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NuevacancionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
