create table zhouky_School08(
zky_schoolName08 nvarchar(15) primary key,
zky_schoolAddress08 nvarchar(30),
zky_whether98508 nvarchar(2) check  (zky_whether98508='是' or zky_whether98508='否'),
)
create table zhouky_MajorESet08(
zky_Mno08 nvarchar(10),
zky_schoolName08 nvarchar(15),
zky_whetherFocalPoint08 nvarchar(2) check  (zky_whetherFocalPoint08='是' or zky_whetherFocalPoint08='否'),
)

create table zhouky_Major08(
zky_Mno08 nvarchar(10) primary key,
zky_Mname08 nvarchar(15),
)

create table zhaodj_Class08(--创建班级表
zdj_classNumber08 NVARCHAR(5)  primary key,
zdj_Mno08 NVARCHAR(10),
zdj_classSize08 INT ,
zdj_isExperimental08 NVARCHAR(2) NOT NULL CHECK(zdj_isExperimental08 IN('是','否'))
)

create table zhaodj_ClassOpen08(--创建班级开设表
zdj_classNumber08 NVARCHAR(5),
zdj_Cno08 NVARCHAR(5) ,
zdj_openSemester08 NVARCHAR(10),
CONSTRAINT [PK_zhaodj_ClassOpen08] PRIMARY KEY(zdj_classNumber08,zdj_Cno08,zdj_openSemester08)
)

create table zhaodj_Teacher08(--创建教师表
zdj_Tno08 NVARCHAR(10) primary key,
zdj_Tname08 NVARCHAR(5),
zdj_Tsex08 NVARCHAR(2),
zdj_Tage08 int,
zdj_Ttitle08 NVARCHAR(10),
zdj_Tphone08 NVARCHAR(15)
)
create table Zhuxy_Attendclass08(--创建上课表
zxy_Tno08 nvarchar(10),
zxy_classNumber08 nvarchar(5),
constraint PK_Ac08 primary key(zxy_Tno08,zxy_classNumber08)
)
create table Zhuxy_Teaching08(--创建授课表
zxy_Tno08 nvarchar(10),
zxy_Cno08 nvarchar(5),
zxy_openSemester08 nvarchar(10),
constraint PK_Teach primary key(zxy_Tno08,zxy_Cno08,zxy_openSemester08)
)
create table Zhuxy_Courses08(--创建课程表
zxy_Cno08 nvarchar(5),
zxy_openSemester08 nvarchar(10),
zxy_Cname08 nvarchar(10),
zxy_Chours08 int,
zxy_natureofAssessment08 nvarchar(5)check(zxy_natureofAssessment08='考试'or zxy_natureofAssessment08='考察'),
zxy_credit08 int,
constraint PK_Ac primary key(zxy_Cno08,zxy_openSemester08)
)

CREATE TABLE caizy_Students08
(
czy_Sno08 nvarchar(10) primary key,
czy_Sname08 nvarchar(5),
czy_Ssex08 nvarchar(2),
czy_Sage08 int,
czy_sourceOfStudents08 nvarchar(15),
czy_Cno08 nvarchar(5)
)

CREATE TABLE caizy_Score08
(
czySno08  nvarchar(10)
czyCno08 nvarchar(5)
czyopenSemester08 nvarchar(10)
czy_Score08 int
)
CREATE TABLE caizy_Credits08
(
czySno08 nvarchar(10)
totalCredits08 int
)


-----------------------------创建外键：
alter table zhaodj_Score08  add  primary key(zdj_Sno08,zdj_Cno08,zdj_openSemester08)
alter table zhaodj_Credits08  add  primary key(zdj_Sno08)
alter table zhaodj_MajorESet08  add  primary key(zdj_Mno08)
alter table zhaodj_MajorESet08  add constraint FK_zhaodj_MajorESetMno08 FOREIGN KEY(zdj_Mno08) REFERENCES zhaodj_Major08(zdj_Mno08)
alter table zhaodj_MajorESet08  add constraint FK_zhaodj_MajorESetschoolName08 FOREIGN KEY(zdj_schoolName08) REFERENCES zhaodj_School08(zdj_schoolName08)
alter table zhaodj_Class08  add constraint FK_zhaodj_ClassMno08 FOREIGN KEY(zdj_Mno08) REFERENCES zhaodj_Major08(zdj_Mno08)
alter table zhaodj_ClassOpen08  add constraint FK_zhaodj_ClassOpenclassNumber08 FOREIGN KEY(zdj_classNumber08) REFERENCES zhaodj_Class08(zdj_classNumber08)
alter table zhaodj_ClassOpen08  add constraint FK_zhaodj_ClassOpenCnoOpenSemester08 FOREIGN KEY(zdj_Cno08,zdj_openSemester08) REFERENCES zhaodj_Courses08(zdj_Cno08,zdj_openSemester08)
alter table zhaodj_Attendclass08  add constraint FK_zhaodj_AttendclassTno08 FOREIGN KEY(zdj_Tno08) REFERENCES zhaodj_Teacher08(zdj_Tno08)
alter table zhaodj_Attendclass08  add constraint FK_zhaodj_AttendclassclassNumber08 FOREIGN KEY(zdj_classNumber08) REFERENCES zhaodj_Class08(zdj_classNumber08)
alter table zhaodj_Teaching08  add constraint FK_zhaodj_TeachingTno08 FOREIGN KEY(zdj_Tno08) REFERENCES zhaodj_Teacher08(zdj_Tno08)
alter table zhaodj_Teaching08  add constraint FK_zhaodj_TeachingCnoopenSemester08 FOREIGN KEY(zdj_Cno08 ,zdj_openSemester08) REFERENCES zhaodj_Courses08(zdj_Cno08 ,zdj_openSemester08)
alter table zhaodj_Score08  add constraint FK_zhaodj_ScoreSno08 FOREIGN KEY(zdj_Sno08) REFERENCES zhaodj_Students08(zdj_Sno08)
alter table zhaodj_Score08  add constraint FK_zhaodj_ScoreCnoopenSemester08 FOREIGN KEY(zdj_Cno08 ,zdj_openSemester08) REFERENCES zhaodj_Courses08(zdj_Cno08 ,zdj_openSemester08)
alter table zhaodj_Students08  add constraint FK_zhaodj_StudentsCno08 FOREIGN KEY(zdj_classNumber08) REFERENCES zhaodj_Class08(zdj_classNumber08)
alter table zhaodj_Credits08  add constraint FK_zhaodj_Credits08 FOREIGN KEY(zdj_Sno08) REFERENCES zhaodj_Students08(zdj_Sno08)




蔡泽永sql语句
(1)根据地区信息，统计某一地区的学生数;
#CREATE VIEW SourceStunum AS
SELECT czy_sourceOfStudents08,count(czy_Sno08) sourceSum
FROM caizy_Students08
GROUP BY czy_sourceOfStudents08
(2)学生成绩按每学年成绩统计；
#CREATE VIEW StuGradeStaticbyYear AS
SELECT czy_Sno08,czy_Cno08,czy_Score08
FROM caizy_Score08
WHERE czy_openSemester08='?' and czy_Sno08='?'
(3)学生成绩名次按学年排定；
CREATE VIEW Stu_GPA
AS
SELECT caizy_Students08.czy_Sno08,caizy_Students08.czy_Sname08,caizy_Score08.czy_Cno08,caizy_Courses08.czy_credit08,caizy_Score08.czy_Score08
FROM caizy_Courses08,caizy_Score08,caizy_Students08
WHERE caizy_Students08.czy_Sno08=caizy_Score08.czy_Sno08 and caizy_Courses08.czy_Cno08=caizy_Score08.czy_Cno08

SELECT czy_Sno08,round(CONVERT(float,sum((czy_Score08-50.0)/10.0*czy_Credit08))/sum(czy_credit08),2) czy_gpa08,
ROW_NUMBER() OVER(ORDER BY round(CONVERT(float,sum((czy_Score08-50.0)/10.0*czy_Credit08))/sum(czy_credit08),2) DESC) crank
FROM Stu_GPA
GROUP BY czy_Sno08

(4)每门课程平均成绩统计；
#CREATE VIEW CavgGrade AS
SELECT caizy_Score08.czy_Cno08,avg(czy_Score08) avg_score
FROM caizy_Score08,caizy_Courses08
WHERE caizy_Score08.czy_Cno08=caizy_Courses08.czy_Cno08
Group by caizy_Score08.czy_Cno08
(5)学生所学课程及学分统计；
#CREATE VIEW CreditStatic AS
SELECT czy_Sno08,czy_Cname08,czy_credit08
FROM caizy_Score08,caizy_Courses08
WHERE caizy_Score08.czy_Cno08=caizy_Courses08.czy_Cno08

SELECT czy_Sno08,totalCredits08
FROM caizy_Credits08
WHERE czy_Sno08='?'
(6)对每个学生输入成绩的时候，自动生成学生的已修学分总数；

(7)学生成绩查询；
#CREATE VIEW StuScores AS
SELECT *FROM caizy_Score08
WHERE czy_Sno08='?'

-- (8)教师任课查询；
#CREATE VIEW TeaCourses AS
SELECT *FROM caizy_Teaching08
WHERE czy_Tno08='?'
-- (9)班级课程开设查询。
#CREATE VIEW ClassCourses AS
SELECT czy_classNumber08,czy_Cname08,czy_credit08,caizy_ClassOpen08.czy_openSemester08
FROM caizy_ClassOpen08,caizy_Courses08
WHERE czy_classNumber08='?' and caizy_ClassOpen08.czy_Cno08=caizy_Courses08.czy_Cno08


存储过程

CREATE PROCEDURE PRO_autoCredit
@
数据
insert into caizy_Students08 values('0','蔡泽永','男',20,'浙江','1803')
insert into caizy_Students08 values('1','蔡泽','男',20,'浙江','1803')
insert into caizy_Students08 values('2','蔡永','男',20,'南京','1803')
insert into caizy_Students08 values('3','蔡永泽','男',20,'浙江','1803')


insert into caizy_Class08 values('1803','G101',30,'是')
insert into caizy_Class08 values('1804','G101',30,'是')


INSERT INTO caizy_Major08 values('G101','软件工程')

INSERT INTO caizy_Courses08 values('G101','1','数据结构',64,'考试',4)
INSERT INTO caizy_Courses08 values('T102','1','C++',64,'考试',4)
INSERT INTO caizy_Courses08 values('T103','2','JAVA',64,'考试',4)


insert into caizy_Score08 values('0','T102','1',98)
insert into caizy_Score08 values('0','T103','2',95)

-- //1-9功能整合及测试
-- (1)根据地区信息，统计某一地区的学生数；
CREATE VIEW SourceStuNum AS
SELECT zxy_sourceOfStudents08,count(zxy_Sno08) sourceSum
FROM Zhuxy_Students08
GROUP BY zxy_sourceOfStudents08
//查询查询语句和输入地区查询两种语句和结果
select *from SourceStuNum
select  sourceSum from SourceStuNum where zxy_sourceOfStudents08='浙江'