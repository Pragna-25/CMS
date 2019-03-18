use hr;
select * from employees;
select * from departments;
select department_id,department_name from departments;
select department_id as 'ID',department_name as 'NAME' from departments;
select department_id 'ID',department_name 'NAME' from departments;
select department_id 'ID',department_name 'NAME' from departments;
select employee_id 'ID', first_name 'NAME', salary*12 as 'Annual salary' from employees;
select employee_id 'ID', first_name 'NAME', (commission_pct * salary) + salary as 'Total salary' from employees;
select distinct department_id from employees;
select employee_id, first_name, department_id from employees where department_id=90;
select employee_id, first_name, department_id from employees where first_name='steven';
select last_name, salary from employees where salary<=3000;
select last_name, salary from employees where salary>=3000;
select last_name, salary from employees where salary between 2500 and 3500;
select last_name, salary from employees where salary not between 2500 and 3500;
select first_name, last_name, department_id from employees where employee_id in (100,101,102);
select first_name, last_name, department_id from employees where department_id in (50,90);
select first_name, last_name, department_id from employees where department_id not in (50,90);
select first_name, last_name, department_id from employees where salary>5000 and department_id=90;
select first_name, last_name, department_id from employees where salary between 2500 and 3500 and department_id in(10,20,50,90);
select employee_id, first_name, last_name, salary, commission_pct from employees where commission_pct is null;
select employee_id, first_name, last_name, salary, commission_pct from employees where commission_pct is not null;
select employee_id, first_name, last_name, department_id from employees where first_name like '_i%';
select employee_id, first_name, last_name, department_id from employees where first_name not like '_i%';
select employee_id, first_name, department_id from employees order by department_id desc;
select employee_id, first_name, department_id from employees order by department_id asc;
select employee_id, first_name, department_id from employees order by department_id desc, first_name asc;
select employee_id, first_name, department_id from employees order by first_name asc, department_id desc;

select * from employees where employee_id= 150 | 160;
select first_name,salary,commission_pct,hire_date from employees where salary<10000;
select * from employees where first_name or last_name like '%h';
select * from employees where department_id in(30) and salary between 5000 and 10000 and commission_pct is null;
select * from employees where department_id not between 30 and 70;
select * from employees where department_id is null;

-- min,max,sum,avg,count
select * from employees order by department_id=30;
select employee_id,department_id,max(salary) from employees where department_id=10;
select department_id, sum(salary) from employees where department_id=30;
select count(*) from employees where department_id=30;
select min(salary),max(salary),avg(salary), sum(salary) from employees where department_id = 30;

-- string functions
select last_name, length(last_name) from employees;
select last_name, upper(last_name) from employees;
select last_name, lower(last_name) from employees;
select concat(first_name,' ',last_name) 'full name' from employees;
select substring('good morning',5) 'substring';
select concat('welcome',' ','to',' ','training.') 'string';

select sysdate() 'Sysdate'; -- time at which the statement executes
select current_timestamp() 'Timestamp';
select now() 'Now'; -- time at which statement began to execute 

select  now(), sleep(5), sysdate();
select  sysdate(), sleep(5), now();
select day(sysdate()), dayname(sysdate());
select month(sysdate()), monthname(sysdate());
select year(sysdate());
select month('2015-03-03'),year('2015-03-03'),day('2015-03-03'),dayname('2015-03-03');
select extract(day from '20170412121212') 'day';
select extract(hour from '20170412121212') 'hour';
select extract(hour from '2017-04-12 12:12:12') 'hour';
select date_add('19991231000001', interval 1 month)result;
select date_add('20181220000001', interval 1 month)result;
select datediff(sysdate(),'20181220');
select datediff(sysdate(),'19960806');
select timediff(sysdate(),'20190122083000');
select timediff('121000','083000');
select last_day('20190201');

select abs(-999.30), ceil(999.30), floor(999.30), round(999.30), round(999.60), mod(100,3);

select truncate(1.345,2);
select truncate(123456.345,-2);

select isnull(null);

-- try these
use hr;
select * from employees;
select first_name, hire_date from employees where year(hire_date) between '1996' and '1999';
select * from jobs;
select * from jobs where job_id like 'IT%' or job_id like 'SA%';
				select first_name,hire_date,job_id from eployees where job_id like 'IT%' or job_id like 'SA%';
select * from employees where hire_date>date('19970101');
select first_name,salary,round(salary) from employees;
select * from employees where month(hire_date)=05;
select first_name, datediff(sysdate(),hire_date)/365 'Experience' from employees;
select first_name,last_name,length(first_name) from employees where last_name like'_a%';
select datediff(sysdate(),'20110101') 'Days';
select * from employees where date(hire_date)>15;
select first_name, salary from employees where commission_pct is not null; 

select department_id, job_id, sum(salary) from employees group by department_id, job_id;
select department_id, sum(salary) from employees group by department_id having sum(salary)>8000;
select department_id, sum(salary) from employees group by department_id having sum(salary)>8000 order by sum(salary) desc;
select distinct(commission_pct) from employees;
select commission_pct,count(employee_id) 'count' from employees group by commission_pct;
select commission_pct,count(employee_id) 'count' from employees where commission_pct>0.25 group by commission_pct having count(employee_id)>1;

select job_id,avg(salary) 'avg' from employees group by job_id having avg>7000;
select job_id,avg(salary) 'avg' from employees where job_id like '%man' group by job_id having avg>7000;
select hire_date,count(employee_id) 'count' from employees group by year(hire_date);
select year(hire_date) 'year',count(employee_id) 'count' from employees group by year having count>5;

-- joins
-- inner join
select e.employee_id, e.department_id, d.department_name from employees e, departments d where e.department_id = d.department_id;
select e.employee_id, e.department_id, d.department_name from employees e join departments d using(department_id);
select e.employee_id, e.department_id, d.department_name from employees e join departments d on e.department_id=d.department_id;

-- self join
select concat(worker.last_name,' works for ',manager.last_name) 'Details',
worker.employee_id,worker.manager_id 
from employees worker, employees manager
where worker.manager_id=manager.employee_id;

-- left outer join
select e.employee_id,e.department_id,d.department_id,d.department_name 
from employees e left outer join departments d 
on e.department_id = d.department_id 
order by e.department_id;

-- right outer join
select e.employee_id,e.department_id,d.department_id,d.department_name 
from employees e right outer join departments d 
on e.department_id = d.department_id 
order by e.department_id;

-- cross join or cartesian join
select e.employee_id, e.department_id, d.department_id, d.department_name
from employees e cross join departments d;

-- movies table

create table T1
(
	id int,
    movie varchar(20)
);

create table T2
(
	id int,
    actor varchar(20)
);

insert into T1(id,movie)
values(1,'tiger'),(2,'mahanadi'),(3,'don');

insert into T2(id,actor)
values(3,'srk'),(4,'amir'),(2,'pawn kalyan'),(1,'salman');

-- inner join
select m.id,m.movie,a.id,a.actor from T1 m,T2 a where m.id=a.id;
select m.id,m.movie,a.id,a.actor from T1 m join T2 a using(id);
select m.id,m.movie,a.id,a.actor from T1 m join T2 a on m.id=a.id;

-- left outer join
select m.id,m.movie,a.id,a.actor 
from T1 m left outer join T2 a 
on m.id = a.id 
order by m.id;

-- right outer join
select m.id,m.movie,a.id,a.actor 
from T1 m right outer join T2 a 
on m.id = a.id 
order by m.id;

-- cross join
select m.id,m.movie,a.id,a.actor 
from T1 m cross join T2 a;

-- sub query
select last_name,job_id
from employees
where job_id = ( select job_id 
				 from employees
                 where employee_id=141)
and salary > ( select job_id 
			   from employees
               where employee_id=143);

select department_id from employees where first_name='john' or first_name='valli';

select first_name,department_id
from employees
where department_id in ( select department_id 
						 from employees 
                         where first_name='john' 
                         or first_name='valli');

select first_name , salary
from employees
where salary>( select max(salary) 
			   from employees 
               where department_id=60)
order by salary;

select department_id, min(salary)
from employees
group by department_id
having min(salary) > ( select min(salary)
					   from employees
                       where department_id = 50);
                       
select employee_id,last_name,job_id,salary
from employees
where salary < any(	select salary
					from employees
                    where job_id='IT_PROG')
and job_id<>'IT_PROG';

select employee_id,last_name,job_id,salary
from employees
where salary > any(	select salary
					from employees
                    where job_id='IT_PROG')
and job_id<>'IT_PROG';

select employee_id,last_name,job_id,salary
from employees
where salary < all(	select salary
					from employees
                    where job_id='IT_PROG')
and job_id<>'IT_PROG';

select employee_id,last_name,job_id,salary
from employees
where salary > all(	select salary
					from employees
                    where job_id='IT_PROG')
and job_id<>'IT_PROG';

create or replace view empvu80
as select employee_id,first_name,salary from employees
where department_id=80;

select * from empvu80;

select employee_id,first_name,salary
from employees
where department_id=80;

desc empvu80;

create or replace view empvu81
as select first_name
from employees
where first_name like '%a';

create or replace view empvu81
as select first_name,department_name
from employees e join departments d
on e.department_id=d.department_id
where first_name like '%a';

select * from empvu81;

-- create or replace view empwithDepName(eName,dName)
-- as select first_name,department_name
-- from employees e join departments d
-- on e.department_id=d.department_id
-- where first_name like '%a';
