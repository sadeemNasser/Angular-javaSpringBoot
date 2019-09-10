import { Component, ElementRef, ViewChild, AfterViewInit, OnInit } from "@angular/core";
import * as am4core from "@amcharts/amcharts4/core";
import * as am4charts from "@amcharts/amcharts4/charts";
import am4themes_animated from "@amcharts/amcharts4/themes/animated";
import am4themes_material from "@amcharts/amcharts4/themes/material";
import { ActivatedRoute, Router } from '@angular/router';


am4core.useTheme(am4themes_material);
am4core.useTheme(am4themes_animated);

@Component({
  selector: 'app-section',
  templateUrl: './section.component.html',
  styleUrls: ['./section.component.css']
   })


export class SectionComponent implements OnInit{

   private chart: am4charts.PieChart;
   
   constructor(private route:ActivatedRoute,
               private router:Router){}
               
   ngOnInit() {
      
      let router1=this.router;
      let chart = am4core.create("chartdiv", am4charts.PieChart);
   // Add data 

   chart.data = [ {
     "Section": "Health",
     "id":0,
     "litres": 300
   }, {
      "Section":"Work & Employement",
      "id":1,
      "litres": 300
   }, {
      "Section": "Money",
      "id":2,
      "litres": 300
   }, {
      "Section": "Relationship",
      "id":3,
      "litres": 300
   }, {
      "Section": "Community",
      "id":4,
      "litres": 300
   }, {
      "Section": "Religion",
      "id":5,
      "litres": 300
   }
   , {
      "Section": "Place To Live",
      "id":6,
      "litres": 300
   }, {
      Section: "About me",
      "id":7,
      "litres": 300
   } 
];
   
   // Add and configure Series
   let pieSeries = chart.series.push(new am4charts.PieSeries());
   pieSeries.dataFields.value = "litres";
   pieSeries.dataFields.category = '{Section}';
   pieSeries.slices.template.stroke = am4core.color("#fff");
   pieSeries.slices.template.strokeWidth = 2;
   pieSeries.slices.template.strokeOpacity = 1;
   pieSeries.slices.template.fontSize=4;
   pieSeries.ticks.template.disabled = true;
   pieSeries.slices.template.tooltipText = "";
   pieSeries.alignLabels = false;
   pieSeries.labels.template.text = "{Section}";
   pieSeries.labels.template.radius = am4core.percent(-40);
   pieSeries.labels.template.fill = am4core.color("white");
   pieSeries.labels.template.align = "center";
   pieSeries.labels.template.fontSize=12;

   
   //  pieSeries.dataItem.dataContext="{Section}";

   pieSeries.clickable=true;
   pieSeries.slices.template.events.on("hit",function(ev){
      let id = ev.target.dataItem.index;
      router1.navigate(['goals/section/'+id])
   });

    
   
   
   // This creates initial animation
   pieSeries.hiddenState.properties.opacity = 1;
   pieSeries.hiddenState.properties.endAngle = -90;
   pieSeries.hiddenState.properties.startAngle = -90;
}

}
