
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
export class User{
  constructor(
    public status:string,
     ) {}
}
export class JwtResponse{
  constructor(
    public jwttoken:string,
     ) {}
}
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  constructor(private httpClient:HttpClient) { 
     }

     authenticate(username, password) {
      // return this.httpClient.post<any>('http://localhost:8080/authenticate',{username,password}).pipe(
      //  map(
      //    userData => {
      //     sessionStorage.setItem('username',username);
      //     let tokenStr= 'Bearer '+userData.token;
      //     sessionStorage.setItem('token', tokenStr);
      //     return userData;
      //    }
      //  )
      // );
      // const url = 'http://localhost:8080/2/goals';
      // const headers = new HttpHeaders({Authorization: 'Basic ' + btoa('sadeem@gmail.com:password')});
      // return this.httpClient.get(url, { headers });

        if (username === "sadeem@gmail.com" && password === "password") {
          sessionStorage.setItem('username', username)
          return true;
        } else {
          return false;
        }
      }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    //console.log(!(user === null))
    return !(user === null)
  }
  logOut() {
    sessionStorage.removeItem('username')
  }
}