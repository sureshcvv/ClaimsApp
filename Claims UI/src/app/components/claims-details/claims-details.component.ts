import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ColumnMode, SelectionType } from '@swimlane/ngx-datatable';
import { ClaimsApiService } from 'src/app/claims-api.service';
import { Claim } from '../model/claim.model';

@Component({
  selector: 'app-claims-details',
  templateUrl: './claims-details.component.html',
  styleUrls: ['./claims-details.component.css']
})
export class ClaimsDetailsComponent implements OnInit, OnDestroy {
  ordersList: any = [];
  filteredColumns: any = [];
  ColumnMode = ColumnMode;
  SelectionType = SelectionType;
  claimAmount: any = {};
  claimData: any = {};
  userMode: string | null = 'user';
  firstFormGroup!: FormGroup;
  contactInformation!: FormGroup;
  costDetails!: FormGroup;
  paymentInformation!: FormGroup;
  additionalInfo!: FormGroup;
  claimsUpdatedData!: Claim;
  sendEditDataModel!: any;

  facilityList: any = [];
  customerList: string[] = [];

  constructor(public dialogRef: MatDialogRef<ClaimsDetailsComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, 
              private _formBuilder: FormBuilder, 
              private http: ClaimsApiService, 
              private _snackBar: MatSnackBar,) { }

  ngOnInit(): void {
    this.initializeForm();
    this.userMode = localStorage.getItem('userDetails') ? localStorage.getItem('userDetails') : 'user';
    this.http.getFacility().subscribe((data: any) => {
      this.facilityList = data;
    });

    // this.customerList = this.http.getCustomer();
    setTimeout(() => {
      this.ordersList = this.data.orders;

    }, 500)
    this.filteredColumns = [{ "name": "Item", "props": "item", width: 60 }, 
                            { "name": "Description", props: "des" }, 
                            { "name": "Date Code", props: "dateCode" },
                            { "name": "LOT", props: "lot" }, 
                            { "name": "Quantity", props: "quantity" },
                            { "name": "LPN", props: "LPN" },
                            { "name": "NET", props: "NET" }];

  }

  initializeForm() {
    this.firstFormGroup = this._formBuilder.group({
      createdDate: [new Date(this.data.rowData.creationDate), Validators.required],
      closedDate: [new Date(this.data.rowData.dateClosed), Validators.required],
      customerClaim: [this.data.rowData.serviceProviderClaimId],
      customer: ['', Validators.required],
      facility: [this.data.rowData.facilityId, Validators.required],
      wmsAccount: ['', Validators.required],
      claimType: [this.data.rowData.claimType.toLowerCase().charAt(0).toUpperCase() + this.data.rowData.claimType.toLowerCase().slice(1), Validators.required],
      claimCategory: [this.data.rowData.category, Validators.required],
      status: [this.data.rowData.claimStatus, Validators.required],
      priorityFlag: ['', Validators.required],
      commonType: ['', Validators.required],
      issueType: ['', Validators.required],
    });

    this.contactInformation = this._formBuilder.group({
      name: ['admin', Validators.required],
      phone: ['1111111111', Validators.required],
      email: ['admin@miracle', Validators.required],

    });

    this.costDetails = this._formBuilder.group({
      amountBasis: ['Product', Validators.required],
      cost: [this.data.rowData.claimedAmount, Validators.required],
      currency: ['USD', Validators.required],

    });

    this.paymentInformation = this._formBuilder.group({
      apVendor: ['', Validators.required], 
      paidAmount: ['', Validators.required],
      paymentReference: ['', Validators.required], 
      paymentDate: ['', Validators.required],
      invoiceNumber: ['', Validators.required], 
      costCenter: ['', Validators.required],
      glCode: ['',], accuralAmount: ['', Validators.required],
      invoiceAmount: [''], claimedAmount: [0, Validators.required],
      currencyType: ['', Validators.required],

    });

    this.additionalInfo = this._formBuilder.group({
      notes: [''], 
      document: ['']
    });
  }

  saveClaimDetails() {

    this.claimsUpdatedData = new Claim();
    this.claimsUpdatedData.create_date = this.formatDate(this.firstFormGroup.value.createdDate);
    this.claimsUpdatedData.closed_date = this.formatDate(this.firstFormGroup.value.closedDate)

    this.sendBackEditData(this.firstFormGroup.value, this.costDetails.value);
    this.dialogRef.close({data: this.sendEditDataModel});

  }

  sendBackEditData(firstFormGroup: any, costDetails: any) {
    this.sendEditDataModel = {};
    this.sendEditDataModel._id = this.data.rowData._id;
    this.sendEditDataModel.claimId = this.data.rowData.claimId;
    this.sendEditDataModel.facilityId = firstFormGroup.facility;
    this.sendEditDataModel.palletQuantity = this.data.rowData.palletQuantity;
    this.sendEditDataModel.documentType = this.data.rowData.documentType;
    this.sendEditDataModel.claimedAmount = costDetails.cost;
    this.sendEditDataModel.serviceProviderClaimId = firstFormGroup.customerClaim;
    this.sendEditDataModel.claimStatus = firstFormGroup.status;
    this.sendEditDataModel.claimType = firstFormGroup.claimType;
    this.sendEditDataModel.lastUpdateId = this.data.rowData.lastUpdateId;
    this.sendEditDataModel.createDate = this.formatDate(firstFormGroup.createdDate);
    this.sendEditDataModel.lastUpdateDate = this.data.rowData.lastUpdateDate;
    this.sendEditDataModel.creationDate = this.formatDate(firstFormGroup.createdDate);
    this.sendEditDataModel.date = this.formatDate(firstFormGroup.createdDate);
    this.sendEditDataModel.masterAcct = this.data.rowData.masterAcct;
    this.sendEditDataModel.facility = this.data.rowData.facility;
    this.sendEditDataModel.account = this.data.rowData.account;
    this.sendEditDataModel.amcClaim = this.data.rowData.amcClaim;
    this.sendEditDataModel.category = this.data.rowData.category;
    this.sendEditDataModel.status = this.data.rowData.status;
    this.sendEditDataModel.paidAmount = this.data.rowData.paidAmount;
    this.sendEditDataModel.dateClosed = this.formatDate(firstFormGroup.closedDate);
    return this.sendEditDataModel;
  }

  ngOnDestroy(): void {
    this._snackBar.open("Progress Saved", "Close");
  }

  addQuantity(e: any, row: any) {
    console.log(row);
    this.claimAmount[row.item] = e.target.value * 5;
    let total = 0;
    for (let amount of Object.keys(this.claimAmount)) {
      total += this.claimAmount[amount];
    }
    this.costDetails.setValue({
      amountBasis: this.costDetails.value.amountBasis ? this.costDetails.value.amountBasis : 'Product',
      cost: total,
      currency: this.costDetails.value.currency ? this.costDetails.value.currency : 'USD'
    })
    this.paymentInformation.controls['claimedAmount'].setValue(total);
    this.paymentInformation.controls['currencyType'].setValue(this.costDetails.value.currency ? this.costDetails.value.currency : 'USD');
  }

  formatDate(date: any) {
    let d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [month, day, year].join('/');
}
}
