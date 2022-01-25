select * from sys_user


SELECT DISTINCT t_0.id , t_0.label , t_0.parent_id , t_0.authority , t_0.css , t_0.path_resource_id ,
                t_0.dynamic_handler , t_0.hidden , t_0.params , t_0.type , t_0.url , t_0.sort , t_3.user_id join_f0 FROM (select * from sys_menu WHERE ( deleted= 0 ) ) t_0
join (select * from sys_role_menu WHERE ( deleted= 0 ) ) t_1 on t_1.menu_id = t_0.id
join (select * from sys_role WHERE ( deleted= 0 ) ) t_2 on t_2.id = t_1.role_id
join (select * from sys_role_user WHERE ( deleted= 0 ) ) t_3 on t_3.role_id = t_2.id
 WHERE t_3.user_id IN ( '110588348101165911' ) AND t_3.deleted= 0 ORDER BY ifnull( t_0.sort ,1) -1 ASC, t_0.sort ASC



执行：SELECT DISTINCT t_0.id , t_0.label , t_0.parent_id , t_0.authority , t_0.css , t_0.path_resource_id , t_0.dynamic_handler , t_0.hidden , t_0.params , t_0.type , t_0.url , t_0.sort , t_3.user_id join_f0 , t_0.id join_fs_sys_role_menu_sf_nioj_id , t_1.role_id join_fs_sys_role_sf_nioj_role_id , t_2.id join_fs_sys_role_user_sf_nioj_id , t_3.user_id join_fs_sys_user_sf_nioj_user_id FROM (select * from sys_menu WHERE ( deleted= 0 ) ) t_0
join (select * from sys_role_menu WHERE ( deleted= 0 ) ) t_1 on t_1.menu_id = t_0.id
join (select * from sys_role WHERE ( deleted= 0 ) ) t_2 on t_2.id = t_1.role_id
join (select * from sys_role_user WHERE ( deleted= 0 ) ) t_3 on t_3.role_id = t_2.id
 WHERE t_3.user_id IN ( '110588348101165911' ) AND t_3.deleted= 0 ORDER BY ifnull( t_0.sort ,1) -1 ASC, t_0.sort ASC