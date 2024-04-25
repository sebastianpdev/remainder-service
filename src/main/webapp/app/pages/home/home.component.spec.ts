import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from "@angular/router/testing";
import { HomeComponent } from './home.component';
import {TestCaseService} from "../../services/testcases.service";
import {ReactiveFormsModule} from "@angular/forms";
import {TestCasesDetail} from "../../entities/model/TestCasesDetail";
import {of} from "rxjs";

describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;
  let testCaseServiceMock: jasmine.SpyObj<TestCaseService>;

  const testCasesDetailMock = new TestCasesDetail(2, '1 2 3, 4 5 6');

  beforeEach(async () => {
    testCaseServiceMock = jasmine.createSpyObj('TestCaseService', ['compute']);

    await TestBed.configureTestingModule({
      imports: [RouterTestingModule, HomeComponent, ReactiveFormsModule],
      providers: [
        {
          provide: TestCaseService,
          useValue: testCaseServiceMock
        }
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  xit('should send testcases form', () => {
    testCaseServiceMock.compute.and.returnValue(of('response'));

    component.testCasesForm.patchValue({
      numberTestCases: testCasesDetailMock.numberTestCases,
      testCases: testCasesDetailMock.testCases
    });

    expect(component.submitted).toBeTruthy();
    expect(component.testCasesOutput).toEqual('response');
    expect(testCaseServiceMock.compute).toHaveBeenCalledWith(testCasesDetailMock);
  });
});
