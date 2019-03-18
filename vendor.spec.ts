import { Vendor } from './vendor';

describe('Vendor', () => {
  it('should create an instance', () => {
    expect(new Vendor(500, "KFC", "Deepak", "password", "deepak@kfc.com", 123123123, "#123, 4th street,5th phase BTM, Bangalore, Karnataka")).toBeTruthy();
    console.log('vendor');
  });
});
