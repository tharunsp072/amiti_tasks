export interface Habit {

    id : number;
    title : string;
    description? :string;
    target : number;
    done   : number;
    completed : boolean;
    streak: number;
}