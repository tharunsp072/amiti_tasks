import { Component,h,Prop, State ,Event,EventEmitter} from "@stencil/core/internal";

@Component({
    tag : 'add-task-from',
    styleUrl : 'add-task-from.css',
    shadow : true

})

export class AddTaskFrom { 
    @Prop() columnId : string ;

    @State() title : string = '';
    @State() description : string = '';
    @State() showForm : boolean = false;

    @Event() taskAdded : EventEmitter<{columnId : string,title : string , description?:string}>

    handleSubmit(e : Event){
        e.preventDefault();

        if(!this.title.trim())return;

        this.taskAdded.emit({
            columnId : this.columnId,
            title : this.title.trim(),
            description : this.description.trim() || undefined
        });

        this.title = '';
        this.description = '';
        this.showForm = false;
    }

   
    render(){
        return (
            <div class="add-task-form">
                {!this.showForm ? (
                    <button class='add-btn' onClick={()=>(this.showForm = true)}>+ Add Task</button>
                ) : (
                    <div>
                        <form onSubmit={(e)=>{this.handleSubmit(e)}}>
                            <input type="text" 
                            id="task-title"
                             placeholder="Enter task title" 
                             value={this.title}
                             onInput={(e:any)=>(
                                this.title = e.target.value
                             )}  required/>
                             <textarea name="description"
                              id="description"
                              placeholder="Description..."
                              onInput={(e: any)=>(this.description = e.target.value)}
                             ></textarea>
                            <div class="actions">
                                <button type="submit">Add</button>
                                <button type="button" onClick={()=>(this.showForm = false)}>Cancel</button>
                            </div>

                        </form>

                </div>)}
            </div>
        )
    }
}