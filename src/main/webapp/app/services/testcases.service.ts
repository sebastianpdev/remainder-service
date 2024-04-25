import { Injectable, inject } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import {TestCasesDetail} from "../entities/model/TestCasesDetail";
import {environment} from "../../environments/environment.development";

@Injectable({
  providedIn: 'root'
})
export class TestCaseService {
  private readonly COMPUTE_TEST_CASES = '/api/testcases';

  private http = inject(HttpClient);

  compute(testCases: TestCasesDetail) {
    return this.http.post(environment.apiPath + this.COMPUTE_TEST_CASES, testCases);
  }
}
