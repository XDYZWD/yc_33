create database favorite;
use favorite;
create table tag(
	tid int primary key auto_increment,
	tname varchar(50),
	tcount int
);
insert into tag(tname,tcount) values('12',1)
commit
select * from favorite where tname='12'
delete from tag
create table favorite(
	fid int primary key auto_increment,
	flabel varchar(500),
	furl varchar(500),
	fdesc varchar(500),
	ftags varchar(500) 
);
--联合主键
select * from tagfavorite where tname='军事'
insert into  ''
create table tagfavorite(
	fid int,
	tid int,
	primary key(tid,fid)
);
alter table tagfavorite add constraint fk_tagfavorite_tid 
foreign key(tid) references tag(tid);
g
alter table tagfavorite add constraint fk_tagfavorite_fid 
foreign key(fid) references favorite(fid);
commit
drop table  favorite
ALTER TABLE tagfavorite DROP FOREIGN KEY fk_tagfavorite_fid;
