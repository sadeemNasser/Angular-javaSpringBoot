import { Section } from '../section/section.model';

export class Goal{
    public goalID:number;
    public goalName:string;
    public description: string;
    public userID:number;
    public goalSection: number;
    public status: string;

    constructor(id:number,name:string,description:string,userID:number,section:number,status:string){
        this.goalID=id;
        this.goalName=name;
        this.description=description;
        this.userID=userID;
        this.goalSection=section;
        this.status=status;

    }
}