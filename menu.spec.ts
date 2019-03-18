import { Menu } from './menu';

describe('Menu', () => {
  it('should create an instance', () => {
    expect( new Menu(1000,'Idly',500,'veg',100,'Breakfast')).toBeTruthy();
  });
});
