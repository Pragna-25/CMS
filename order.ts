export class Order {
  public checked: boolean;
    constructor
    (
        public orderId: number,
        public foodId: number,
        public vid: number,
        public cid: number, 
        public qty: number,
        public ostatus: string,
        public tprice: number, 
        public etime: string, 
        public otime: string, 
        public oreason: string,
        public odate: string
    ){}

}
