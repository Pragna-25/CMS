    export class Menu {
      qty: number;
      isSelected: boolean;
      tPrice: number;
   
        constructor( public foodId:number, 
            public foodName: string,    
        public vid: number,  
        public foodCategory: string,       
        public foodPrice: number,       
        public foodDescription:string ){
        }
        }