select * from sys_user


SELECT DISTINCT t_2.id role_id,t_0.id , t_0.label , t_0.parent_id , t_0.authority , t_0.css , t_0.path_resource_id ,
                t_0.dynamic_handler , t_0.hidden , t_0.params , t_0.type , t_0.url , t_0.sort , t_3.user_id join_f0 FROM (select * from sys_menu WHERE ( deleted= 0 ) ) t_0
join (select * from sys_role_menu WHERE ( deleted= 0 ) ) t_1 on t_1.menu_id = t_0.id
join (select * from sys_role WHERE ( deleted= 0 ) ) t_2 on t_2.id = t_1.role_id
join (select * from sys_role_user WHERE ( deleted= 0 ) ) t_3 on t_3.role_id = t_2.id
 WHERE t_3.user_id IN ( '110588348101165911' )
    and t_0.id='481749751037952000'
   AND t_3.deleted= 0 ORDER BY ifnull( t_0.sort ,1) -1 ASC, t_0.sort ASC;


select ``


select * from sys_role_menu where role_id='110352963290923110' and menu_id='481749751662903296' and deleted=0;

select * from sys_role where id='110352963290923110' and deleted=0;

select * from sys_role_user WHERE ( deleted= 0 ) and role_id='110352963290923110';









INSERT INTO sys_user (id, name, passwd, phone, portrait_id, language, valid, cache_key, last_login_time, create_by, create_time, update_by, update_time, deleted, delete_by, delete_time, version) VALUES ('110588348101165911', 'admin', '{bcrypt}$2a$10$.k23oAcH5.YzdwAj6OIxZuMPrvWRsOAX.tOgeRTqwaW0OIAiN2Zni', '15365254842', '465814972102868992', 'zh_ch', 1, '443c1', '2022-01-26 22:05:17', '', '2021-06-09 16:52:05', null, '2022-01-26 19:46:48', 0, '', null, 139);


select r.id,ru.user_id from sys_role r join sys_role_user ru on r.id=ru.role_id
where ru.user_id='110588348101165911'
;

select id from sys_role where id not in (select role_id from sys_role_user where user_id='110588348101165911');

select * from sys_role_menu where role_id='110352963290923110' and menu_id='481749751662903296';




