import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevoHiloComponent } from './nuevo-hilo.component';

describe('NuevoHiloComponent', () => {
  let component: NuevoHiloComponent;
  let fixture: ComponentFixture<NuevoHiloComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NuevoHiloComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NuevoHiloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
