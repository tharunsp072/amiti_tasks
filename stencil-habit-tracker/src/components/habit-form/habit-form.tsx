import { Component, h, State, Event,EventEmitter} from '@stencil/core';

@Component({
  tag: 'habit-form',
  styleUrl: 'habit-form.css',
  shadow: true,
})
export class HabitForm {
  @State() formData = {
    title: '',
    description: '',
    target: 0,
    done: 0,
    completed: false,
  };

  @Event() habitAdded!: EventEmitter<{ title: string; description: string; target: number; done: number; completed: boolean }>;

  private handleInput = (event: Event) => {
    const target = event.target as HTMLInputElement | HTMLTextAreaElement;
    const { name, type, value, checked } = target as HTMLInputElement;

    this.formData = {
      ...this.formData,
      [name]: type === 'checkbox' ? checked : type === 'number' ? Number(value) : value,
    };
  };

  private handleSubmit = (event: Event) => {
    event.preventDefault();

    this.habitAdded.emit(this.formData);
     this.formData = {
       title: '',
       description: '',
       target: 8,
       done: 0,
       completed: false,
     };
  };

  render() {
    const { title, description, target, done, completed } = this.formData;
    return (

      <form onSubmit={this.handleSubmit} class="habit-form">
        <input type="text" name="title" placeholder="Title" value={title} onInput={this.handleInput} required />

        <textarea name="description" placeholder="Description..." rows={3} value={description} onInput={this.handleInput}></textarea>

        <label>
          Target:
          <input type="number" name="target" value={target} onInput={this.handleInput} />
        </label>

        <label>
          Done Today:
          <input type="number" name="done" value={done} onInput={this.handleInput} />
        </label>

        <progress max={target} value={done}></progress>

        <label>
          Completed:
          <input type="checkbox" name="completed" checked={completed} onInput={this.handleInput} />
        </label>

        <button type="submit">Save Habit</button>
      </form>
    );
  }
}
