import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GoalComponent } from './goal/goal.component';
import { AppComponent } from './app.component';
import { SectionComponent } from './section/section.component';
import { GoalEditComponent } from './goal/goal-edit/goal-edit.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { RegisterComponent } from './register/register.component';
import { AuthGaurdService } from './Authentication/auth-gaurd.service';


const routes: Routes = [
  { path: 'home', component: SectionComponent, canActivate: [AuthGaurdService] },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'goals', component: GoalComponent, canActivate: [AuthGaurdService]},
  { path: 'goals/section/:id', component: GoalComponent, canActivate: [AuthGaurdService]},
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'logout', component: LogoutComponent, canActivate: [AuthGaurdService] }
];
// ,children: [
//   { path: '', component: SectionComponent },
//   { path: 'section/:id?id=:id', component: GoalComponent}
// ],
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
