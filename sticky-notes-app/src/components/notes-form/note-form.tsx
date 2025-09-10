import { Component, h, State, Event, EventEmitter } from '@stencil/core';
import { NoteColor, NoteDraft } from '../../interfaces/models';

@Component({
  tag: 'note-form',
  styleUrl: './note-form.css',
  shadow: true,
})
export class NoteForm {
  @State() open = false;
  @State() title = '';
  @State() description = '';
  @State() color: NoteColor = 'yellow';
  @State() tagsInput = '';
  @State() pinned = false;

  @Event() noteCreated: EventEmitter<NoteDraft>;
  handleSubmit = (e: Event) => {
    e.preventDefault();
    const title = this.title.trim();
    if (!title) return;
    const tags = this.tagsInput
      .split(',')
      .map(t => t.trim())
      .filter(Boolean);

    const draft: NoteDraft = {
      title,
      description: this.description.trim() || undefined,
      color: this.color,
      pinned: this.pinned,
      tags,
    };

    this.noteCreated.emit(draft);
    console.log('New note added');
    this.reset();
  };

  reset = () => {
    this.title = '';
    this.description = '';
    this.color = 'yellow';
    this.tagsInput = '';
    this.pinned = false;
    this.open = false;
  };
  render() {
    return (
      <div class="note-form">
        {!this.open ? (
          <button
            class="open-btn"
            onClick={() => {
              this.open = true;
            }}
          >
            + New Note
          </button>
        ) : (
          <form onSubmit={this.handleSubmit}>
            <div class="row">
              <input
                type="text"
                value={this.title}
                onInput={(e: any) => {
                  this.title = e.target.value;
                }}
                required
              />

              <select
                onInput={(e: Event) => {
                  const target = e.target as HTMLSelectElement;
                  this.color = target.value as NoteColor;
                }}
              >
                <option value="yellow">Yellow</option>
                <option value="blue">Blue</option>
                <option value="pink">Pink</option>
                <option value="green">Green</option>
              </select>
            </div>
            <textarea placeholder="Description (Optional)" value={this.description} rows={3}></textarea>

            <input
              placeholder="Tags (Comma Seperated)"
              value={this.tagsInput}
              onInput={(e: any) => {
                this.tagsInput = e.target.value;
              }}
            />
            <div class="pinbutton">
              <label>
                Pin Note :
                <input
                  class="checkbox"
                  type="checkbox"
                  checked={this.pinned}
                  onInput={(e: any) => {
                    this.pinned = e.target.checked;
                  }}
                />
              </label>
            </div>
            <div class="actions">
              <button type="submit">Add Note</button>
              <button type="button" class="secondnary" onClick={() => this.reset()}>
                Back
              </button>
            </div>
          </form>
        )}
      </div>
    );
  }
}
