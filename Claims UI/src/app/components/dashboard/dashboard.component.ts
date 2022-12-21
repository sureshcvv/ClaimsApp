import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDrawer } from '@angular/material/sidenav';
import { DashboardClaimsData } from '../mock-data/dashboard-claims.constant';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  showFiller = true;
  @ViewChild(MatDrawer) drawer: any;
  navOptions = "home";
  years: any
  public claims: any = [];
  public openClaims: any[] = [];
  public closedClaims: any[] = [];
  public statusData: any = {};
  public openBarChartColor = '#36A2EB';
  public closedBarChartColor = '#FF6484';
  public openSize = 3000;
  public closedSize = 50000;
  selectedDataItems = [];
  tempData: any = []
  show = true;
  selectedDay: any;
  notifyObj = new Notifier();
  facilityId:string='';
  constructor() { }

  ngOnInit(): void {
    this.claims = DashboardClaimsData;
    this.tempData = this.claims
    this.initFilter();
  }

  public initFilter(): void {
    this.openClaims = this.claims.filter((claim: any) => claim.status === 'Open');
    this.openClaims.forEach((elem: any) => {
      elem.claimedAmount = +elem.claimedAmount.toString().substring(1).replace(',', '');
    })
    this.openClaims = this.openClaims.sort((a: any, b: any) => b.claimedAmount - a.claimedAmount);
    this.closedClaims = this.claims.filter((claim: any) => claim.status === 'Closed');
    this.closedClaims.forEach((elem: any) => {
      elem.claimedAmount = +elem.claimedAmount.toString().substring(1).replace(',', '');
    })
    this.closedClaims = this.closedClaims.sort((a: any, b: any) => b.claimedAmount - a.claimedAmount);
    this.claims.forEach((element: any) => {
      if (this.statusData.hasOwnProperty(element.status)) {
        this.statusData[element.status] += 1;
      } else {
        this.statusData[element.status] = 1;
      }
    })
    this.openClaims = this.claims;
    this.closedClaims = this.claims;
  }

  facilityChange(facilityId: string) {
    this.facilityId = facilityId;
  }

  yearrange(event: any) {
    this.selectedDay = {
      value: event.value,
      text: event.source.triggerValue
    };
    this.claims = [].concat(this.tempData.filter((x: any) => {
      let event12 = new Date(x.date);
      if (event12.getFullYear() == this.selectedDay.text) {
        return true;
      } else {
        return false;
      }
    }))
    this.notifyObj.valueChanged(this.claims);
  }
  selectedData(e: any) {
    this.selectedDataItems = e;
    this.navOptions = 'addClaim';
  }
  getYear(e: any) {
    this.show = false;
    this.years = Number(e.value);
    this.ngOnInit();

    setTimeout(() => {
      this.claims = this.claims.filter((data: any) => {
        let event = new Date(data.date);
        if (event.getFullYear() == this.years) {
          return true;
        } else {
          return false;
        }

      })
      this.initFilter();
      this.show = true
    }, 0)
  }
}

export class Notifier {
  valueChanged: (data: any) => void = (data: any) => { };
}
