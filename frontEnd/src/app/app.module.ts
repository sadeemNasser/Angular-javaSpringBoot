import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { GoalComponent } from './goal/goal.component';
import { SectionComponent } from './section/section.component';
import { DoughnutChartComponent, PieChartComponent, BarChartComponent } from 'angular-d3-charts';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { GoalListComponent } from './goal/goal-list/goal-list.component';
import { GoalEditComponent } from './goal/goal-edit/goal-edit.component';
import { GoalItemComponent } from './goal/goal-list/goal-item/goal-item.component';
import { GoalService } from './goal/goal.service';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { RegisterComponent } from './register/register.component';
// import { BasicAuthInterceptorService } from './Authentication/basic-auth-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    GoalComponent,
    SectionComponent,
    DoughnutChartComponent, 
   PieChartComponent, 
   BarChartComponent,
    GoalListComponent,
    GoalEditComponent,
    GoalItemComponent,
    LoginComponent,
    LogoutComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
    ],
  providers: [GoalService],
  bootstrap: [AppComponent]
})
export class AppModule { }
