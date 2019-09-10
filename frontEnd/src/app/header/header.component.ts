import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../Authentication/authintication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private loginService:AuthenticationService) { }

  ngOnInit() {
  }

}
