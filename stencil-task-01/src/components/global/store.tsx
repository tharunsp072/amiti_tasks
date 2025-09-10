import { createStore } from '@stencil/store';

export interface Product {
  id: number;
  name: string;
  price: number;
  image : string;
}

interface CartState {
  items: Product[];
}

const { state, onChange } = createStore<CartState>({
  items: []
});

export const cartState = state;

export const addToCart = (product: Product) => {
  state.items = [...state.items, product];
};

export const clearCart = () => {
  state.items = [];
};

export { onChange };
