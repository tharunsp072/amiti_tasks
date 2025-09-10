

export type NoteColor = 'yellow' | 'blue' | 'green' | 'pink';

export interface Note { 
    id : string;
    title : string;
    description? :string;
    color : NoteColor;
    tags? : string[];
    pinned : boolean;
    position : { x : number; y : number};
    createdAt?  : string;
}



export interface  NoteDraft { 
    title : string;
    description? : string;
    color : NoteColor;
    tags : string[];
    pinned : boolean;
}