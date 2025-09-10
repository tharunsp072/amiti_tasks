import { Component, h, Prop , Event, EventEmitter } from "@stencil/core";
import { Column, Task } from "../../interfaces/models";

@Component({
    tag : 'kanban-column',
styleUrl: './kanban-column.css',
    shadow : true
})



export class KanbanColumn {

    @Prop() column: Column;

    @Event() taskAdded: EventEmitter<{ columnId: string; title: string; description?: string }>;
    @Event() taskDropped : EventEmitter<{ taskId : string;fromColumnId : string;toColumnId : string}>;
    handleDragOver =(ev : DragEvent)=>{
        ev.preventDefault();
    };

    // handleDrop = (ev : DragEvent)=>{
    //     ev.preventDefault();
    //     const data = ev.dataTransfer?.getData("application/json");
    //     if(data) {
    //         const {taskId,fromColumnId} = JSON.parse(data);
    //         this.taskDropped.emit({
    //             taskId,
    //             fromColumnId,
    //             toColumnId : this.column.id
    //         });
    //     }
    // };
    handleDrop = (event : DragEvent)=>{
        event.preventDefault();
        const data = event.dataTransfer?.getData("application/json");
        if(data){
            const { taskId,fromColumnId} = JSON.parse(data);
            this.taskDropped.emit({
                taskId,
                fromColumnId,
                toColumnId : this.column.id
            });
        }
    };

     render(){  
       console.log('Rendering kanban-column', this.column);
        return (
            <div class='kanban-column' onDragOver={this.handleDragOver} onDrop={this.handleDrop}>
                <h3 class='column-title'>{this.column.title}</h3>

                <div class="task-list">
                    {this.column.tasks.length == 0 ? (
                        <p class="empty">No tasks yet</p>
                    ):( this.column.tasks.map((task : Task)=>(
                        <kanban-task task ={task} columnId={this.column.id}></kanban-task>
                        // <div>{task.title}</div> 
                    )))}
                </div>

                <add-task-from columnId = {this.column.id}></add-task-from>
            </div>  
        );
     }
}   