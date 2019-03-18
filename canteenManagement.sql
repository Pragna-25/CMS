-- creating Database
create database FTP106;
drop database FTP106;

-- using the Database
use FTP106;

CREATE TABLE VENDOR
(
    V_ID INT PRIMARY KEY,
    V_NAME VARCHAR(20),
    V_USERNAME VARCHAR(20),
    V_PASSWORD VARCHAR(10),
    V_EMAIL VARCHAR(30),
    V_PHONE VARCHAR(20),
    V_ADDRESS VARCHAR(100)
);

CREATE TABLE CUSTOMER
(
    C_ID INT PRIMARY KEY,
    C_NAME VARCHAR(20),
    C_USERNAME VARCHAR(20),
    C_PHONE VARCHAR(20),
    C_EMAIL VARCHAR(30),
    C_WALLET FLOAT,
    C_PASSWORD VARCHAR(10)
);

CREATE TABLE MENU
(
    FOOD_ID INT PRIMARY KEY,
    V_ID INT,
    FOOD_NAME VARCHAR(20),
    FOOD_PRICE FLOAT,
    FOOD_CATEGORY VARCHAR(20),
    FOOD_DESCRIPTION VARCHAR(100)
);

CREATE TABLE ORDERS
(
    ORDER_ID INT PRIMARY KEY AUTO_INCREMENT,
    FOOD_ID INT,
    V_ID INT,
    C_ID INT,
    QTY INT(20),
    O_STATUS ENUM('PLACE_ORDER','DELIVERED','CANCELLED'),
    T_PRICE FLOAT,
    E_TIME TIME,
    ORDER_TIME TIME,
    O_REASON VARCHAR(100),
    O_DATE DATETIME
);

DROP TABLE FREEGIFT;

CREATE TABLE FREEGIFT
(
	C_ID INT,
    V_ID INT
);


ALTER TABLE ORDERS
    ADD CONSTRAINT V_ID_FK
    FOREIGN KEY V_ID_FK(V_ID)
    REFERENCES VENDOR(V_ID)
    ON DELETE SET NULL;

ALTER TABLE ORDERS
    ADD CONSTRAINT FOOD_ID_FK
    FOREIGN KEY FOOD_ID_FK(FOOD_ID)
    REFERENCES MENU(FOOD_ID)
    ON DELETE SET NULL;

ALTER TABLE ORDERS
    ADD CONSTRAINT C_ID_FK
    FOREIGN KEY C_ID_FK(C_ID)
    REFERENCES CUSTOMER(C_ID)
    ON DELETE SET NULL;

ALTER TABLE MENU
    ADD CONSTRAINT V_ID_FK_CS
    FOREIGN KEY V_ID_FK_CS(V_ID)
    REFERENCES VENDOR(V_ID)
    ON DELETE SET NULL;
 
ALTER TABLE FREEGIFT
    ADD CONSTRAINT V_ID_FK_CS
    FOREIGN KEY V_ID_FK_CS(V_ID)
    REFERENCES VENDOR(V_ID)
    ON DELETE SET NULL;
    
ALTER TABLE FREEGIFT
    ADD CONSTRAINT C_ID_FK_CS
    FOREIGN KEY C_ID_FK_CS(C_ID)
    REFERENCES CUSTOMER(C_ID)
    ON DELETE SET NULL;
    
insert into vendor 
( V_ID, V_NAME, V_USERNAME, V_PASSWORD, V_EMAIL, V_PHONE, V_ADDRESS)
values
( 500, 'KFC', 'Deepak', 'password', 'deepak@kfc.com','123123123','#123, 4th street,5th phase BTM, Bangalore, Karnataka'),
( 501, 'Mc.Donalds', 'Dhruv', 'password', 'dhruv@mcd.com','456456456','#456, 7th street,8th phase HSR, Bangalore, Karnataka'),
( 502, 'BurgKing', 'Dhanvin', 'password', 'dhanvin@bking.com','789789789','#789, 1st street,2nd phase NR, Bangalore, Karnataka'),
( 503, 'Dominos', 'Divesh', 'password', 'divesh@dominos.com','012012012','#345, 6th street,7th phase GK, Bangalore, Karnataka'),
( 504, 'SubWay', 'Dheer', 'password', 'dheer@subway.com','345345345','#678, 5th street,6th phase MG, Bangalore, Karnataka');

select * from vendor;

INSERT INTO menu
(FOOD_ID,V_ID ,FOOD_NAME ,FOOD_PRICE ,FOOD_CATEGORY ,FOOD_DESCRIPTION) 
VALUES
('1000', '500', 'CHICKENWINGS   ', '80', 'NONVEG          ', 'CRISPY DEEP FRIED CHICKEN                '),
('1001', '500', 'CHICKENBUCKET  ', '400', 'NONVEG          ', 'JUICY CHICKEN LEG                        '),
('1002', '500', 'CHICKENLONGER  ', '150', 'NONVEG          ', 'FAVOURITE CHICKEN WITH BREAD             '),
('1003', '501', 'ALOOTIKKI      ', '40', 'VEG             ', 'BURGER STUFFED WITH POTATO AND PEAS      '),
('1004', '501', 'MAHARAJA       ', '400', 'VEG             ', 'BURGER STUFFED WITH VEGIES               '),
('1005', '501', 'MC.MAHARAJA    ', '400', 'NONVEG          ', 'BURGER STUFFED WITH CHICKEN              '),
('1006', '502', 'WHOOPER        ', '120', 'NONVEG          ', 'BIG BELLY BURGER WITH HUGE CHICKEN CRISP '),
('1007', '502', 'MINI           ', '50', 'NONVEG          ', 'MINI CHICKEN BURGER                       '),
('1008', '502', 'FRESH          ', '80', 'VEG             ', 'FRESH VEG-BURGER                          '),
('1009', '503', 'MARGERETA      ', '150', 'VEG             ', 'FULLY LOADED VEG SURPRISE WITH CHEESE    '),
('1010', '503', 'CHEESEBURST    ', '250', 'VEG             ', 'EXTRA CHEESE LOADED PIZZA                '),
('1011', '503', 'CHEESEBURST    ', '350', 'NONVEG          ', 'CHICKEN AND CHEESE PIZZA                 '),
('1012', '504', '3 inch LONG SUB', '175', 'NONVEG          ', 'SUB FILLED WITH OLIVES AND TURKEY        '),
('1013', '504', '6 inch LONG SUB', '275', 'VEG             ', 'SUB FILLED WITH CARROT,PEASE AND ONION   ');

select * from menu;

INSERT INTO CUSTOMER
( C_ID ,C_NAME ,C_USERNAME,C_PHONE , C_EMAIL ,C_WALLET , C_PASSWORD)
VALUES
(01,'JOHN','JOHN',7586469254, 'JOHN@GMAIL.COM', 1000, 'JOHN@123'),
(02,'KEVIN','KEVIN',8665469254, 'KEVINZ@GMAIL.COM', 1200, 'KEVIN@123'),
(03,'STEVEN','STEVEN',9665469254, 'STEVEN@YAHOO.COM', 1300, 'STEVEN@123'),
(04,'PAUL','PAUL',7952990254, 'PAUL@GYAHOO.COM', 1400, 'PAUL@123'),
(05,'ROCK','ROCK',8995269254, 'ROCK@YAHOO.COM', 1500, 'ROCK@123');

select * from customer;

select O_STATUS,count(O_STATUS)
from orders 
group by(O_STATUS);

select FOOD_ID,food_name 'Order from'
from menu;

select C_ID,C_WALLET
from customer; 

select c.C_NAME,o.C_ID,max(qty) 'maxv'
from orders o join customer c
on o.C_ID=c.C_ID
group by o.C_ID
having maxv;

select c_id from orders
where qty=(select max(qty) from orders);

select c_id from orders
where qty=(select min(qty) from orders);

select c.C_NAME,o.c_id
from orders o join customer c
using (C_ID)
where qty=(select min(qty) from orders);

select c.C_NAME,o.c_id
from orders o join customer c
using (C_ID)
where qty=(select max(qty) from orders);

select V_NAME,V_ID,sum(qty) 'Total_orders'
from orders o join vendor v 
using(v_id)
group by V_ID
having Total_orders>3;

select C_NAME,V_NAME,sum(qty) 'Total'
from customer c join orders o using(c_id) 
join vendor v using(v_id)
group by v.v_id;

select c.c_name,c.c_id,m.FOOD_NAME
from customer c join orders o
on c.C_ID=o.C_ID
join menu m
on o.V_ID=m.V_ID
where ORDER_ID=5
group by(o.v_id);

select c.c_name,c.c_id,m.FOOD_NAME,v.V_NAME,o.O_STATUS
from customer c join orders o
on c.C_ID=o.C_ID
join menu m
on o.V_ID=m.V_ID
join vendor v
on m.V_ID=v.V_ID
where O_STATUS='place order'
group by(o.v_id);

select *
from vendor v left outer join menu m 
on v.v_id=m.v_id;

select o_status,count(order_id)
from orders
group by(O_STATUS);

select v_name,count(O_STATUS) 'cnt'
from vendor v join orders o
on v.V_ID=o.V_ID
where O_STATUS='cancelled';

select *
from orders
where day(O_DATE)=10;

select c.c_id,c.c_name,datediff()
from customer c join orders o
on c.C_ID=o.C_ID;


select O_DATE,C_ID, (max(o_date)-min(O_DATE))/365
from orders;
-- group by C_ID,O_DATE;

select food_price,food_name
from orders o join vendor v
on o.V_ID=v.V_ID
join menu m
on v.v_id=m.v_id
where m.FOOD_PRICE <all (select FOOD_PRICE from menu where v_id=4);

select c_id,c_name
from customer c
where exists(select 1 from orders o where o.c_id=c.C_ID);

select c_id,c_name
from customer c
where not exists(select 1 from orders o where o.c_id=c.C_ID);

select *from menu;
select v.v_name, m.food_name, food_price
	from vendor v join menu m
    on v.v_id=m.v_id where food_price >
		(select food_price from menu where food_name='alootikki');
        
select food_price from menu where food_name='alootikki';

select 0.05*sum(t_price)
from orders
where v_id=504 and month(o_date)=3 and year(o_date)=2019 and  O_STATUS='DELIVERED';