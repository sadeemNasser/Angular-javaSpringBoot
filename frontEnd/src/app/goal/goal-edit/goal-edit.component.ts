import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { GoalService } from '../goal.service';
import { Goal } from '../goal.model';


@Component({
  selector: 'app-goal-edit',
  templateUrl: './goal-edit.component.html',
  styleUrls: ['./goal-edit.component.css']
})
export class GoalEditComponent implements OnInit {
  id: number;
  GoalForm: FormGroup;
  constructor(
    private route: ActivatedRoute,
    private goalService: GoalService,
    private router: Router
  ) { }

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.id = +params['id'];
    });
     this.initForm();
}

  onSubmit(){
    // this.goal=this.GoalForm.value;
    // console.log(this.GoalForm.value);
    this.goalService.save(this.GoalForm.value);
    window.location.reload();

    // this.onCancel();
    

  }
  onCancel(){
    this.router.navigate(['../'], { relativeTo: this.route });

  }
  private initForm() {
    let Goal_Name = '';
    let Goal_desc = '';
    let Goal_Section = ''+this.id;
    let Goal_Status="";
    this.GoalForm = new FormGroup({
      goalName: new FormControl(Goal_Name, Validators.required),
      goalSection: new FormControl(Goal_Section, Validators.required),
      status: new FormControl(Goal_Status, Validators.required),
      description: new FormControl(Goal_desc, Validators.required),
    });
  }
}
/*    public goalID:number;
    public goalName:string;
    public description: string;
    public userID:number;
    public goalSection: number;
    public status: string; */