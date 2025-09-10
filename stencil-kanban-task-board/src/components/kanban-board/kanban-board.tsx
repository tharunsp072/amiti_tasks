import { Component, h, State } from "@stencil/core";
import { Board, Task } from '../../interfaces/models'


@Component({
    tag: 'kanban-board',
    styleUrl : 'kanban-board.css',
    shadow : true
})

export class KanbanBoard {
    @State() board : Board ={
        id : 'board1',
        title : 'My Kanban Board',
        columns : [
            {id:'build',title:'Build',tasks:[]},
            {id:'test',title:'Test',tasks:[]},
            {id:'done',title:'Done',tasks:[]}
        ]
    };

    // addTask(columnId : string , title : string, description? : string){
    //     const newTask = {
    //         id : `task-${Date.now}`,
    //         title,
    //         description
    //     };
    //     this.board =  {
    //         ...this.board,columns: this.board.columns.map((col)=>(
    //             col.id === columnId? { ...col,tasks : [...col.tasks , newTask]} : col
    //         ))
    //     };
    //     console.log("After adding:",this.board.columns);
    // }

    addTask(columnId : string, title: string , description : string){
        const newTask = {
            id : `task-${Date.now}`,
            title, 
            description
        };
        
        this.board = {
            ...this.board,columns : this.board.columns.map((col)=>(
                col.id == columnId? {...col,tasks : [...col.tasks,newTask]} : col
            ))
        };
    }

    // moveTask(taskId:string,fromColumnId : string,toColumnId : string){
    //     let movedTask : Task;

    //     const UpdatedColumns = this.board.columns.map((col)=>{
    //         if(col.id == fromColumnId){
    //             const remaining = col.tasks.filter((task)=>{
    //                 if(task.id == taskId){
    //                     movedTask = task;
    //                     return false;
    //                 }
    //                 return true;
    //             });
    //             return {...col,tasks:remaining};
    //         }
    //         return col;
    //     })
    //     if(movedTask){
    //         this.board = {
    //             ...this.board,columns : UpdatedColumns.map((col)=>
    //             col.id == toColumnId ? {...col,tasks : [...col.tasks,movedTask]} : col)
    //         };
    //     }
    // }
    // moveTask(taskId : string, fromColumnId : string, toColumnId : string){
    //     let movedTask : Task;

    //     const UpdatedColumns = this.board.columns.map((col)=>{
    //         if(col.id == fromColumnId){
    //             const remaining = col.tasks.filter((task)=>{
    //                 if(task.id == taskId){
    //                     movedTask = task;
    //                     return false;
    //                  }
    //                 return true;
    //             });
    //             return {...col,tasks :remaining};
    //         }   
    //         return col;
    //     });

    //     if(movedTask){
    //         this.board = {
    //             ...this.board  ,columns : UpdatedColumns.map((col)=>
    //             col.id === toColumnId ? {...col,tasks: [...col.tasks,movedTask]} : col)
    //         };
    //     }

    // }

    moveTask(taskId : string, fromColumnId : string, toColumnId : string){
        let movedTask : Task ;

        const UpdatedColumns = this.board.columns.map((col)=>{
            if(col.id == fromColumnId){
                const remaining = col.tasks.filter((task)=>{
                    if(task.id == taskId)  {
                        movedTask = task;
                        return false;
                    }
                    return true;
                });
                return {...col,tasks:remaining};
            }
            return col;
        });

        if(movedTask){
            this.board = {
                ...this.board,columns: UpdatedColumns.map((col)=>
                    col.id == toColumnId ? {...col,tasks : [...col.tasks,movedTask]} : col
                )
            };
        }
    }


    render(){
        return (
            <div class="kanban-board">
                <h2>{this.board.title}</h2>
                <div class="board-columns">
                    {this.board.columns.map((col)=>(
                        <kanban-column column={col} onTaskAdded = {(event : CustomEvent)=>
                            this.addTask(event.detail.columnId,event.detail.title,event.detail.description)
                        }
                        onTaskDropped={(event:CustomEvent)=>{
                            this.moveTask(event.detail.taskId,event.detail.fromColumnId,event.detail.toColumnId)
                        }}
                        ></kanban-column>
                    ))}
                </div>
            </div>
        );
    }
}



