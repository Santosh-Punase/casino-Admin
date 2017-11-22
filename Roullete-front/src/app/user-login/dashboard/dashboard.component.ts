import { Component, OnInit } from '@angular/core';
import {RoulleteServiceService} from '../../roullete-service.service';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';

declare let $: any;
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  firstTwelvePosition = 0;
  secondTwelvePosition = 0;
  thirdTwelvePosition = 0;
  zerothPosition = 0;
  oneToEighteen = 0;
  ninteenToThirtysix = 0;
  oddPosition = 0;
  evenPosition = 0;
  totalsum = 0;

  name = '';
  currentBalance = 0;
  // errorModel = false;
  WinLossBetAmount  = 0;
  oldBalance = 0;

  result = '';
  randomNumber = '';
  data1: Object = {};
  constructor(private service: RoulleteServiceService, private router: Router) { }

  ngOnInit() {
    const retrievedObject = sessionStorage.getItem('userdata');
    const mycustomerdata = JSON.parse(retrievedObject);
    if (mycustomerdata === null) {
      this.router.navigate(['login']);
    }
    this.name = mycustomerdata['name'];
    this.currentBalance = mycustomerdata['total_bal'];
  }

  submitBetForm(form: NgForm) {
    console.log(this.evenPosition);
    this.totalsum = this.thirdTwelvePosition + this.evenPosition + this.firstTwelvePosition + this.ninteenToThirtysix
      + this.oddPosition + this.secondTwelvePosition + this.zerothPosition + this.oneToEighteen;

    const retrievedObject = sessionStorage.getItem('userdata');
    const mycustomerdata = JSON.parse(retrievedObject);
    console.log(mycustomerdata['total_bal']);
    console.log(this.totalsum);
    const id = mycustomerdata['uniq_id'];
    let balanceOld = Number(mycustomerdata['total_bal']);
    this.oldBalance = balanceOld;

    if (balanceOld >= this.totalsum && balanceOld !== 0) {
      // make post request to calculate win/lose
      console.log('yes balance is more');


      const betdata = {
        first12 : this.firstTwelvePosition,
        second12 : this.secondTwelvePosition,
        third12 : this.thirdTwelvePosition,
        zeroth : this.zerothPosition,
        oneTo18 : this.oneToEighteen,
        nineteenTo36 : this.ninteenToThirtysix,
        odd : this.oddPosition,
        even : this.evenPosition
      }
      // service call here
      this.service.findGameResult(betdata, id)
        .subscribe(
          (data) => {
            console.log('new data is');
            console.log(data);
            this.data1 = JSON.parse(data);
            this.randomNumber = this.data1['randomNumberGenerated'].toString();
            // check returned data to show winning amount;

            const newUpdatedBalance = Number(this.data1['total_bal']);
            // this.WinLossBetAmount=this.oldBalance-newUpdatedBalance;
            // set new data to the session
            sessionStorage.setItem('userdata', data);
            // if -ve then show loss
            if ((this.oldBalance - newUpdatedBalance) > 0) {
              console.log('old balance ' + this.oldBalance);
              console.log('new balance ' + newUpdatedBalance);

              this.result = 'Lost';
              this.WinLossBetAmount = this.oldBalance - newUpdatedBalance;
            } else {
              this.result = 'Won';
              this.WinLossBetAmount = newUpdatedBalance - this.oldBalance;
            }
            // render the game result model
            console.log('rendering model for result');
            $('#resultModal').modal();
            console.log('rendered model for result');
          }
          ,
          function (err) {
            console.log('error occurred in component ', err);
          }
        );
    } else {
      $('#errorModal').modal();
    }
  }

  logout() {
    console.log('session storage clean');
    sessionStorage.removeItem('userdata');
    this.router.navigate(['login']);
  }
  resetSelection() {
    this.firstTwelvePosition = 0;
    this.secondTwelvePosition = 0;
    this.thirdTwelvePosition = 0;
    this.zerothPosition = 0;
    this.oneToEighteen = 0;
    this.ninteenToThirtysix = 0;
    this.evenPosition = 0;
    this.oddPosition = 0;

  }
  resetAfterResult() {
    location.reload(true);
    // this.router.navigate(['login']);
  }
}
