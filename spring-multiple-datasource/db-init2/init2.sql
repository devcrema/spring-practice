create table order
(
    id     bigint(12) unsigned auto_increment primary key,
    user_id  varchar(255) default ''                not null comment 'db1.user FK',
    reg_ts timestamp   default CURRENT_TIMESTAMP not null,
    upd_ts timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
) comment '주문';
