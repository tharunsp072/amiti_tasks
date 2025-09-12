import { Component, h, Prop, State, Event, EventEmitter, Method } from '@stencil/core';
import '@stencil/router';
@Component({
  tag: 'app-root',
  styleUrl: 'app-root.css',
  shadow: false
})
export class AppRoot {
  
  render() {
    return (
      // nav-bar
      <div>
        <header class="header">
          <div class="heading">
            <h1>Habits Chart</h1>
          </div>

          <nav class="nav-bar">
            <stencil-route-link url="/" class="nav-btn">
              <button>Dashboard</button>
            </stencil-route-link>

            <stencil-route-link url="/stats" class="nav-btn">
              <button>Stats</button>
            </stencil-route-link>

            <stencil-route-link url="/add" class="nav-btn">
              <button>Add Habit</button>
            </stencil-route-link>

            <stencil-route-link url="/settings" class="nav-btn">
              <button>Settings</button>
            </stencil-route-link>
          </nav>
        </header>

        {/* Router Outlet  */}
        <stencil-router>
          <stencil-route-switch>
            <stencil-route url="/" component="page-dashboard" exact={true}></stencil-route>
            <stencil-route url="/stats" component="page-stats"></stencil-route>
            <stencil-route url="/add" component="page-add-habit"></stencil-route>
            <stencil-route url="/settings" component="page-settings"></stencil-route>
            <stencil-route-redirect from="*" to="/" />
          </stencil-route-switch>
        </stencil-router>
      </div>
    );
  }
}