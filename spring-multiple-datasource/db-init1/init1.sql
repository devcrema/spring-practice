create table user
(
    id     bigint(12) unsigned auto_increment primary key,
    email  varchar(255) default ''                not null comment '이메일',
    reg_ts timestamp   default CURRENT_TIMESTAMP not null,
    upd_ts timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    constraint idx_u_name
        unique (email)
) comment '유저';
