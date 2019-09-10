import { Injectable, OnInit } from '@angular/core';
import { map, tap, take, exhaustMap } from 'rxjs/operators';
import { Goal } from './goal.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { thresholdFreedmanDiaconis } from 'd3';
import { Section } from '../section/section.model';
import { string } from '@amcharts/amcharts4/core';


@Injectable({
  providedIn: 'root'
})
export class GoalService {
    headers:any;
    private goals:Goal[];
    private GoalsUrl: string;
    httpOptions = {
      headers: new HttpHeaders({
        Authorization: 'Basic ' + btoa('sadeem@gmail.com:password'),
        'Content-Type': 'application/json',
        'Content-Encoding': 'none',
        'Access-Control-Allow-Origin':'*'
      })
    }  

    constructor(private http: HttpClient) {
        this.GoalsUrl = 'http://localhost:8080/2/goals';
      }
    // setGoals(goals: Goal[]) {
    //     this.goals = goals;
    //   }
      
      // public findBySection(sectionId:number){
      //   this.goals[sectionId]
      //   // return this.http.get<Goal[]>(this.GoalsUrl+"/"+sectionId);
      // }
      public save(goal:Goal){
        this.headers = new HttpHeaders({
          Authorization: 'Basic' + btoa('sadeem@gmail.com:password'),
          'Content-Type': 'application/json',
          'Content-Encoding': 'none',
          'Access-Control-Allow-Origin':'*'
         });

         this.http.post('http://localhost:8080/2/goals',JSON.stringify(goal)
         ,this.httpOptions).subscribe(
          data =>console.log('success'+data),
          error=>console.log('oops'+error.error)
        );
        // .subscribe(data => {
        //   console.log(data['_body']);
        //  }, error => {
        //   console.log(error);
        // });
      }
     public deleteGoal(id:number) {
      this.headers = new HttpHeaders({
        'Authorization': 'Basic' + btoa('sadeem@gmail.com:password'),
        'Content-Type': 'application/json',
        'Content-Encoding': 'none',
        'Access-Control-Allow-Origin':'*'
       });
             console.log('http://localhost:8080/2/goals/'+id);
       return this.http.delete<Goal>('http://localhost:8080/2/goals/'+id,this.httpOptions).subscribe(
        data =>console.log('success'+data),
        error=>console.log('oops'+error.error)
      );
     }
    getGoals(){
            // const url = 'http://localhost:8080/2/goals';
            this.headers = new HttpHeaders({
              Authorization: 'Basic' + btoa('sadeem@gmail.com:password'),
              'Content-Type': 'application/json',
              'Content-Encoding': 'none',
              'Access-Control-Allow-Origin':'*'
             });
                         // return this.httpClient.get(url, { headers });
      return this.http.get<Goal[]>('http://localhost:8080/2/goals',this.httpOptions);
   
    }
    // getGoals(UserId:number){
    //   return this.http.get<Goal[]>('http://localhost:8080/'+UserId+'/goals');
   
    // }
    getSectionGoal(id:number){
      this.headers = new HttpHeaders({
        Authorization: 'Basic' + btoa('sadeem@gmail.com:password'),
        'Content-Type': 'application/json',
        'Content-Encoding': 'none',
        'Access-Control-Allow-Origin':'*'
       });
             return this.http.get<Goal[]>('http://localhost:8080/2/goals/section='+id,this.httpOptions
      );

    }
    MakeItDone(id:number){
      ///@PutMapping {userId}/goals/{goalId}/Done
      //http://localhost:8080/2/goals/15/Done
      console.log("http://localhost:8080/2/goals"+"/"+id+"/"+"Done");
      this.headers = new HttpHeaders({
        Authorization: 'Basic' + btoa('sadeem@gmail.com:password'),
        'Content-Type': 'application/json',
        'Content-Encoding': 'none',
        'Access-Control-Allow-Origin':'*'
       });
      return this.http.put<Goal>("http://localhost:8080/2/goals"+"/"+id+"/"+"Done",'',this.httpOptions).subscribe(
        data =>console.log('success'+data),
        error=>console.log('oops'+error.error)
      );
    }
      




}