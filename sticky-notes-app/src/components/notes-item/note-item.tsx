import { Component, h, Prop,  Event, EventEmitter,Element} from '@stencil/core';
import { Note } from '../../interfaces/models';

@Component({
  tag: 'note-item',
  styleUrl: './note-item.css',
  shadow: true,
})
export class NoteItem {
  @Element() el!: HTMLElement;
  @Prop() note: Note;

  @Event() noteDragStart: EventEmitter<{ noteId: string }>;

  @Event() noteMoved: EventEmitter<{ noteId: string; x: number; y: number }>;

  @Event() removeNote: EventEmitter<{ noteId: string }>;

  @Event() editNote: EventEmitter<{ noteId: string }>;

  private handleEdit = () => {};
  private handleDragStart = (e: DragEvent) => {
    if (this.note.pinned) {
      e.preventDefault();
      return;
    }
    e.dataTransfer?.setData('noteId', this.note.id);
    this.noteDragStart.emit({ noteId: this.note.id });
  };

  private handleRemove = () => {
    this.removeNote.emit({
      noteId: this.note.id,
    });
  };

  private handleDragEnd = (e: DragEvent) => {
    if (!e.clientX || !e.clientY) return;

    const board = this.el.closest('.notes-board') as HTMLElement; // <-- use closest
    if (!board) return;

    const x = e.clientX - board.getBoundingClientRect().left + board.scrollLeft;
    const y = e.clientY - board.getBoundingClientRect().top + board.scrollTop;

    this.noteMoved.emit({ noteId: this.note.id, x, y });
  };

  render() {
    const { title, description, pinned, tags, color } = this.note;
    return (
      <div
        class={`note ${color}`}
        draggable={true}
        onDragStart={this.handleDragStart}
        onDragEnd={this.handleDragEnd}
        style={{
          left: `${this.note.position.x}px`,
          top: `${this.note.position.y}px`,
          position: 'absolute',
        }}
      >
        <div class="note-header">
          <strong>{title}</strong>
          {pinned && <span class="pin">📌</span>}
        </div>

        {description && <p class="desc">{description}</p>}

        {tags.length > 0 && (
          <div class="tags">
            {tags.map(tag => (
              <span class="tag">{tag}</span>
            ))}
          </div>
        )}
        <div class="action-btns">
          <button onClick={this.handleEdit}>Edit</button>
          <button onClick={this.handleRemove}>Remove</button>
        </div>
      </div>
    );
  }
}