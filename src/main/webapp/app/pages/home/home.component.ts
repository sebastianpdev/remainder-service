import {Component, inject, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators
} from "@angular/forms";
import { TestCasesDetail } from "../../entities/model/TestCasesDetail";
import {TestCaseService} from "../../services/testcases.service";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule, ReactiveFormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {

  private readonly ONLY_NUMBERS_PATTERN = '^\\d+$';
  private readonly TEST_CASES_PATTERN = '^(\\d+\\s+\\d+\\s+\\d+(,\\s+|$)){1,}$';

  testCasesForm: FormGroup = new FormGroup({
    numberTestCases: new FormControl(''),
    testCases: new FormControl('')
  });
  submitted = false;
  testCasesOutput: any;

  private testCaseService = inject(TestCaseService);
  private formBuilder = inject(FormBuilder);

  testCasesInfo = new TestCasesDetail(0, '');

  ngOnInit(): void {
    this.testCasesForm = this.formBuilder.group({
      numberTestCases: ['', [Validators.required, Validators.pattern(this.ONLY_NUMBERS_PATTERN)]],
      testCases: ['', [Validators.required, Validators.pattern(this.TEST_CASES_PATTERN)]]
    });
  }

  get f(): { [key: string]: AbstractControl } {
    return this.testCasesForm.controls;
  }

  onSubmitTestCasesForm() {
    this.submitted = true;

    if (this.testCasesForm.valid) {
      this.testCasesInfo.numberTestCases = this.testCasesForm.value.numberTestCases;
      this.testCasesInfo.testCases = this.testCasesForm.value.testCases;
      console.log(this.testCasesInfo);
      this.testCaseService.compute(this.testCasesInfo).subscribe(
        response => {
          this.testCasesOutput = response;
        },
        error => {
          console.log('Error on post request.', error)
        }
      );
    }
  }

  onReset() {
    this.submitted = false;
    this.testCasesOutput = '';
    this.testCasesForm.reset();
  }

}
