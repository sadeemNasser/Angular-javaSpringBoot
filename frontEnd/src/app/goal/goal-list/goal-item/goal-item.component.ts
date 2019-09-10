import { Component, OnInit, Input } from '@angular/core';
import { Goal } from '../../goal.model';
import { GoalService } from '../../goal.service';

@Component({
  selector: 'app-goal-item',
  templateUrl: './goal-item.component.html',
  styleUrls: ['./goal-item.component.css']
})
export class GoalItemComponent implements OnInit {
  @Input() goal: Goal;
  constructor(private goalService:GoalService) { }

  ngOnInit() {
  }
  MakeItDone(id:number){
    console.log("Done"+id);
    this.goalService.MakeItDone(id);
    window.location.reload();

  }
  delete(id:number){
    this.goalService.deleteGoal(id);
    window.location.reload();
  }
  section(id:number):string{
   switch(id){
      case 0:
       return 'Health';
       break;
      case 1:
        return 'Work & Employement';
        break;
      case 2:
        return 'Money';
        break;
      case 3:
        return 'Relationship';
        break;
      case 4:
        return 'Community';
        break;
      case 5:
        return 'Religion';
        break;
      case 6:
        return 'Place To Live';
        break;
      case 7:
        return'Self Development';
        break;
   }
  }

}
