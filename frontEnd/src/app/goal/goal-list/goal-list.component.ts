import { Component, OnInit } from '@angular/core';
import { GoalService } from '../goal.service';
import { Goal } from '../goal.model';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-goal-list',
  templateUrl: './goal-list.component.html',
  styleUrls: ['./goal-list.component.css'],
  providers: [GoalService]
})
export class GoalListComponent implements OnInit {
  goals: Goal[] = [];
  sectionId: number;
  SectionView :boolean;

  constructor(private goalService: GoalService,
    private route: ActivatedRoute,
    private router: Router
    ) { 


    }

  ngOnInit() {
    // this.getGoals();
    //  this.goals= this.getGoals();
    this.route.params.subscribe(params => {
      this.sectionId=params['id']; 
      this.SectionView=params['id'] != null;
    });
    if (this.SectionView)
      this.getSectionGoals(this.sectionId);
    else
      this.getGoals();

  }
  // add_new(){
  //   this.router.navigate(['new'],{relativeTo:this.route});
  // }
  getGoals() {
    this.goalService.getGoals()
      .subscribe(goals => {
        this.goals = goals as Goal[]
      });
  }
  getSectionGoals(id: number) {
    this.goalService.getSectionGoal(id)
      .subscribe(goals => {
        this.goals = goals as Goal[]
      });
  }
}
