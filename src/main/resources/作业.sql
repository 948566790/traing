/*1.查询 "001" 课程比 "002" 课程成绩高的所有学生的学号；(子查询/连表)*/
select a.student_id
from t_score a,
     t_score b
where a.student_id = b.student_id
  and a.course_id = '001'
  and b.course_id = '002'
  and a.score > b.score;

/*2.查询平均成绩大于60分的同学的学号和平均成绩：*/
select student_id, avg(score)
from t_score
group by student_id
having avg(score) > 60;

/*3.查询所有同学的学号、姓名、选课数、总成绩(比较有难度 group by 和 函数)*/
select b.student_id, student_name, count(course_id), sum(score)
from t_score a
         right outer join t_student b
                          on a.student_id = b.student_id
group by student_id;
/*4.查询 姓 李 同学的个数(考察like和count)*/
select count(*)
from t_student
where student_name like '李%';
/*5.查询没有 003课程成绩的学生*/
select *
from t_student
where student_id not in (select student_id
                         from t_score
                         where course_id = '003');
/*6.查询学过"001"并且也学过编号"002"课程的同学的学号、姓名；*/
select a.student_id, b.student_name
from t_score a,
     t_student b,
     t_score c
where a.student_id = b.student_id
  and a.student_id = c.student_id
  and a.course_id = '001'
  and c.course_id = '002';

/*7.查询平均课程成绩小于70分的同学的学号、姓名；*/
select b.student_id, student_name
from t_score a
         inner join t_student b
                    on a.student_id = b.student_id
group by student_id
having avg(score) < 70;
/*8.查询没有学全所有课的同学的学号、姓名；*/
select a.student_id, student_name
from t_score a
         inner join t_student b
                    on a.student_id = b.student_id
group by student_id
having count(course_id) < 5;
/*9.查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分*/
select course_id as 课程ID, max(score) as 最高分, min(score) as 最低分
from t_score
group by course_id;
/*10.查询每门课程有成绩的学生数*/
select distinct count(student_id)
from t_score
group by student_id
having count(score) = 5;
/*11.查询男生、女生人数*/
select count(gender)
from t_student
group by gender;
/*12.统计同名同姓人数*/
select (count(a.student_id)) / 2
from t_student a,
     t_student b
where a.student_name = b.student_name
  and a.student_id != b.student_id;


