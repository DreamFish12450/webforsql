CREATE VIEW SourceStuNum AS
SELECT zky_sourceOfStudents08,count(zky_Sno08) sourceSum
FROM Zhouky_Students08
GROUP BY zky_sourceOfStudents08


CREATE VIEW CavgGrade AS--每门课程平均成绩统计
SELECT zhouky_Score08.zky_Cno08,avg(zky_Score08) avg_score
FROM zhouky_Score08,zhouky_Courses08
WHERE zhouky_Score08.zky_Cno08=zhouky_Courses08.zky_Cno08
Group by zhouky_Score08.zky_Cno08

CREATE VIEW CreditStatic AS--学生所学课程及学分统计；
SELECT zky_Sno08,zky_Cname08,zky_credit08
FROM zhouky_Score08,zhouky_Courses08
WHERE zhouky_Score08.zky_Cno08=zhouky_Courses08.zky_Cno08 and zhouky_Courses08.zky_openSemester08=zhouky_Score08.zky_openSemester08

create index index_credit on zhouky_credits08(zky_totalCredits08)
create index index_score on zhouky_score08(zky_score08)


drop view CavgGrade
if(exists(select *from sys.objects where name='CavgGrade'))
drop proc CavgGrade
go
create procedure CavgGrade
as
begin
SELECT zhouky_Score08.zky_Cno08,avg(zky_Score08) avg_score
FROM zhouky_Score08,zhouky_Courses08
WHERE zhouky_Score08.zky_Cno08=zhouky_Courses08.zky_Cno08
Group by zhouky_Score08.zky_Cno08
exec CavgGrade
end
go


if(exists(select *from sys.objects where name='StuScores2'))
drop proc StuScores2
go
create procedure StuScores2(@zky_Sno08 nvarchar(10),@zky_openSemester08 nvarchar(10))
as
begin
set @zky_Sno08=@zky_Sno08 ;
set @zky_openSemester08 = @zky_openSemester08 ;
SELECT *FROM zhouky_Score08
WHERE zky_Sno08=@zky_Sno08 and zky_openSemester08 = @zky_openSemester08;
end
go



ALTER TABLE zhouky_MajorESet08 DROP constraint FK_zhouky_MajorESetMno08
ALTER TABLE zhouky_MajorESet08 DROP constraint FK_zhouky_MajorESetschoolName08
ALTER TABLE zhouky_Class08 DROP constraint FK_zhouky_ClassMno08
ALTER TABLE zhouky_ClassOpen08 DROP constraint FK_zhouky_ClassOpenclassNumber08
ALTER TABLE zhouky_ClassOpen08 DROP constraint FK_zhouky_ClassOpenCnoOpenSemester08
ALTER TABLE zhouky_Attendclass08 DROP constraint FK_zhouky_AttendclassTno08
ALTER TABLE zhouky_Attendclass08 DROP constraint FK_zhouky_AttendclassclassNumber08
ALTER TABLE zhouky_Teaching08 DROP constraint FK_zhouky_TeachingTno08
ALTER TABLE zhouky_Teaching08 DROP constraint FK_zhouky_TeachingCnoopenSemester08
ALTER TABLE zhouky_Score08 DROP constraint FK_zhouky_ScoreSno08
ALTER TABLE zhouky_Score08 DROP constraint FK_zhouky_ScoreCnoopenSemester08
ALTER TABLE zhouky_Students08 DROP constraint FK_zhouky_StudentsCno08
ALTER TABLE zhouky_Credits08 DROP constraint FK_zhouky_Credits08


alter table zhouky_MajorESet08  add constraint FK_zhouky_MajorESetMno08 FOREIGN KEY(zky_Mno08) REFERENCES zhouky_Major08(zky_Mno08) ON DELETE CASCADE
alter table zhouky_MajorESet08  add constraint FK_zhouky_MajorESetschoolName08 FOREIGN KEY(zky_schoolName08) REFERENCES zhouky_School08(zky_schoolName08) ON DELETE CASCADE
alter table zhouky_Class08  add constraint FK_zhouky_ClassMno08 FOREIGN KEY(zky_Mno08) REFERENCES zhouky_Major08(zky_Mno08) ON DELETE CASCADE
alter table zhouky_ClassOpen08  add constraint FK_zhouky_ClassOpenclassNumber08 FOREIGN KEY(zky_classNumber08) REFERENCES zhouky_Class08(zky_classNumber08) ON DELETE CASCADE
alter table zhouky_ClassOpen08  add constraint FK_zhouky_ClassOpenCnoOpenSemester08 FOREIGN KEY(zky_Cno08,zky_openSemester08) REFERENCES zhouky_Courses08(zky_Cno08,zky_openSemester08) ON DELETE CASCADE
alter table zhouky_Attendclass08  add constraint FK_zhouky_AttendclassTno08 FOREIGN KEY(zky_Tno08) REFERENCES zhouky_Teacher08(zky_Tno08) ON DELETE CASCADE
alter table zhouky_Attendclass08  add constraint FK_zhouky_AttendclassclassNumber08 FOREIGN KEY(zky_classNumber08) REFERENCES zhouky_Class08(zky_classNumber08) ON DELETE CASCADE
alter table zhouky_Teaching08  add constraint FK_zhouky_TeachingTno08 FOREIGN KEY(zky_Tno08) REFERENCES zhouky_Teacher08(zky_Tno08) ON DELETE CASCADE
alter table zhouky_Teaching08  add constraint FK_zhouky_TeachingCnoopenSemester08 FOREIGN KEY(zky_Cno08 ,zky_openSemester08) REFERENCES zhouky_Courses08(zky_Cno08 ,zky_openSemester08) ON DELETE CASCADE
alter table zhouky_Score08  add constraint FK_zhouky_ScoreSno08 FOREIGN KEY(zky_Sno08) REFERENCES zhouky_Students08(zky_Sno08) ON DELETE CASCADE
alter table zhouky_Score08  add constraint FK_zhouky_ScoreCnoopenSemester08 FOREIGN KEY(zky_Cno08 ,zky_openSemester08) REFERENCES zhouky_Courses08(zky_Cno08 ,zky_openSemester08) ON DELETE CASCADE
alter table zhouky_Students08  add constraint FK_zhouky_StudentsCno08 FOREIGN KEY(zky_classNumber08) REFERENCES zhouky_Class08(zky_classNumber08) ON DELETE CASCADE
alter table zhouky_Credits08  add constraint FK_zhouky_Credits08 FOREIGN KEY(zky_Sno08) REFERENCES zhouky_Students08(zky_Sno08) ON DELETE CASCADE
