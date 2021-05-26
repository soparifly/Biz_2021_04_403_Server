-- tdUser
use todolistDB;
select * from tbl_todoList;

create view view_todoList AS (
select 
td_seq 일련번호,
td_date 작성일자,
td_time 작성시각,
td_todo 할일,
td_area 장소
from tbl_todoList
);
SELECT * FROM view_TodoList;

CREATE TABLE tbl_tdlist (
td_seq BIGINT auto_increment Primary key,
td_sdate varchar(10) not null,
td_stime varchar(10) not null,
td_doit varchar(300) not null,

td_edate varchar(10) default '', -- 완료날짜
td_etime varchar(10) default '' -- 완료시간
);