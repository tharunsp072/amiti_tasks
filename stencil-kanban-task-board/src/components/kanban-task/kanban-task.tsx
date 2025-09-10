import { Component,h,Prop } from "@stencil/core/internal";
import { Task } from "../../interfaces/models";

@Component({
    tag : 'kanban-task',
    styleUrl : './kanban-task.css',
    shadow : true
})

export class KanbanTask {

    @Prop() task : Task;
    @Prop() columnId : string;
    // handleDragStart = (event: DragEvent) => {
    //     event.dataTransfer?.setData(
    //         "application/json",
    //         JSON.stringify({taskId : this.task.id, fromColumnId : this.columnId})
    //     )
    // };

    handleDragStart = (event : DragEvent)=>{
        event.dataTransfer?.setData(
            "application/json",
            JSON.stringify({taskId : this.task.id,fromColumnId : this.columnId})
        )
    };

    render(){
        return (
           <div class="task-card" draggable={true} onDragStart={this.handleDragStart}>
            <h4 class="task-title">{this.task.title}</h4>
            {this.task.description && ( 
                <p class="task-desc">
                    {this.task.description}
                </p>
            )}
            {this.task.due_Date && (
                <p class="task-due-date">
                    {this.task.due_Date}
                </p>
            )}
            {this.task.tags && this.task.tags.length > 0 && (
                <div class="task-tags">
                    {this.task.tags.map((tag)=>(
                        <span class='tag'>{tag} </span>
                    ))} 
                </div>
            )}
           </div>
        );
    }
}