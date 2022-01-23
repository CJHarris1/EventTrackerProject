import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchExistingComponent } from './search-existing.component';

describe('SearchExistingComponent', () => {
  let component: SearchExistingComponent;
  let fixture: ComponentFixture<SearchExistingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchExistingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchExistingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
