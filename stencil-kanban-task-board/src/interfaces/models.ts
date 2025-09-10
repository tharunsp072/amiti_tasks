
export interface Task {
    id : string;
    title : string;
    description? : string;
    due_Date? : string;
    tags? : string[];
}

export interface Column {
    id:string;
    title : string;
    tasks : Task[];
}

export interface Board {
    id : string;
    title : string ;
    columns : Column[]
}