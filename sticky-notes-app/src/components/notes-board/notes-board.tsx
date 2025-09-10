import { Component, h, Prop, State, Event, EventEmitter, Method } from '@stencil/core';
import { Note } from '../../interfaces/models';


@Component({
  tag: 'notes-board',
  styleUrl: './notes-board.css',
  shadow: true,
})
export class NotesBoard {
  @Prop() notes: Note[] = [];
  @Event() noteMoved: EventEmitter<{ noteId: string; x: number; y: number }>;

  @Event() noteRemoved: EventEmitter<{ noteId: string }>;
  handleDragOver = (e: DragEvent) => {
    e.preventDefault();
  };

  handleDrop = (e: DragEvent) => {
    e.preventDefault();
    const noteId = e.dataTransfer?.getData('noteId');
    if (!noteId) return;

    const board = e.currentTarget as HTMLElement;
    const boardRect = board.getBoundingClientRect();

    const x = e.clientX - boardRect.left + board.scrollLeft - parseFloat(getComputedStyle(board).paddingLeft);
    const y = e.clientY - boardRect.top + board.scrollTop - parseFloat(getComputedStyle(board).paddingTop);

    this.noteMoved.emit({ noteId, x, y });
  };

  render() {
    return (
      <div class="notes-board" onDragOver={this.handleDragOver} onDrop={this.handleDrop}>
        {this.notes.map(note => (
          <note-item
            note={note}
            style={{
              position: 'absolute',
              left: `${note.position.x}px`,
              top: `${note.position.y}px`,
            }}
            onRemoveNote={(event: CustomEvent<{ noteId: string }>) => {
              this.noteRemoved.emit(event.detail);
            }}
          ></note-item>
        ))}
      </div>
    );
  }
}