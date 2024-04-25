import {TestCaseService} from "./testcases.service";
import {TestBed} from "@angular/core/testing";
import {TestCasesDetail} from "../entities/model/TestCasesDetail";
import {HttpClientTestingModule, HttpTestingController} from "@angular/common/http/testing";
import {environment} from "../../environments/environment.development";

describe('TestCaseService', () => {
  let service: TestCaseService;
  let httpMock: HttpTestingController;

  const testCasesDetailMock: TestCasesDetail = {
    numberTestCases: 7,
    testCases: '7 5 12345\n' +
      '5 0 4\n' +
      '10 5 15\n' +
      '17 8 54321\n' +
      '499999993 9 1000000000\n' +
      '10 5 187\n' +
      '2 0 999999999'
  }

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [
        TestCaseService
      ]
    });

    service = TestBed.inject(TestCaseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should compute function to be called successfully', () => {
    service.compute(testCasesDetailMock).subscribe(response => {
      expect(response).toBeTruthy();
    });

    const postRequest = httpMock.expectOne(environment.apiPath + '/api/testcases');
    expect(postRequest.request.method).toBe('POST');
    postRequest.flush(testCasesDetailMock);
  });

});
