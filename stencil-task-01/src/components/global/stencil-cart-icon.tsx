import { Component,h } from "@stencil/core/internal";
import { cartState } from "./store";

@Component({
    tag:"stencil-cart-icon",
    styleUrl:"store.css",
    shadow:true
})

export class StencilCartIcon{

    render(){
        return(
            <div class="cart-icon">
              🛒<p>{cartState.items.length}</p>
            </div>
        );
    }
}