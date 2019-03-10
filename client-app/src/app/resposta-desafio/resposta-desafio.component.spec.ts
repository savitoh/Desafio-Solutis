import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RespostaDesafioComponent } from './resposta-desafio.component';

describe('RespostaDesafioComponent', () => {
  let component: RespostaDesafioComponent;
  let fixture: ComponentFixture<RespostaDesafioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RespostaDesafioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RespostaDesafioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
