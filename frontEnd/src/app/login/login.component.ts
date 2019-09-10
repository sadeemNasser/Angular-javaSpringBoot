import { Component, OnInit } from '@angular/core';
// import { AuthinticationService } from '../Authentication/authintication.service';
import { Router } from '@angular/router';
import { AuthenticationService } from '../Authentication/authintication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email = ''
  password = ''
  invalidLogin = false

  constructor(private router: Router,
    private loginservice: AuthenticationService) { }

  ngOnInit() {
  }

  checkLogin() {
    if (this.loginservice.authenticate(this.email, this.password)
    ) {
      this.router.navigate([''])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  }
  register(){
    this.router.navigate(['register']);
  }
}
