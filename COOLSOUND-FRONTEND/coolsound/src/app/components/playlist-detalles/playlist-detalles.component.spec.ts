import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaylistDetallesComponent } from './playlist-detalles.component';

describe('PlaylistDetallesComponent', () => {
  let component: PlaylistDetallesComponent;
  let fixture: ComponentFixture<PlaylistDetallesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlaylistDetallesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlaylistDetallesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
