import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicadetalleComponent } from './musicadetalle.component';

describe('MusicadetalleComponent', () => {
  let component: MusicadetalleComponent;
  let fixture: ComponentFixture<MusicadetalleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MusicadetalleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MusicadetalleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
