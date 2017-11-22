import { Component, OnInit } from '@angular/core';
import {RoulleteServiceService} from '../roullete-service.service';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';

@Component({
  selector : 'app-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  errorMsg: string = '';
  private uuid: string = '';
  error: boolean = false;
  userData: Object = {};
  constructor(private service: RoulleteServiceService, private router: Router) { }

  ngOnInit() {
    const retrievedObject = sessionStorage.getItem('userdata');
    const mycustomerdata = JSON.parse(retrievedObject);
    console.log('IN ON INIT FUNCTION OF LOGIN PAGE PRINT DATA' + mycustomerdata['uuid']);
    console.log(typeof mycustomerdata['uuid']);
    if (mycustomerdata['uuid'] != null) {
      this.router.navigate(['dashboard']);
    }
  }
  redirect() {
    this.router.navigate(['dashboard']);
  }
  submitForm(form: NgForm) {
    if (form.dirty === false) {
      this.errorMsg = '* incorrect id...Please Try Again';
    }else {
      this.service.checkUuid(this.uuid)
        .subscribe(
          data => {
            console.log(data);
            this.userData = JSON.parse(data);

            // console.log(this.userData['id']);
            if (this.userData['id'] !== 0) {
              console.log(this.userData['id']);
              // Put the object into storage
              sessionStorage.setItem('userdata', data);

              // var retrievedObject = sessionStorage.getItem('userdata');
              //
              // console.log('retrievedObject: ', JSON.parse(retrievedObject));
              //
              // console.log(retrievedObject['id']);
              this.redirect();
            } else {
              this.errorMsg = '* incorrect id...Please Try Again';
            }
          },
          function (err) {
            console.log('error occurred in component ', err);
          });
    }
  }

}
