insert into users(username, email, password, enabled)
values ('user1', 'user1@user.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true),
       ('user2', 'user2@user.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', true);

insert into authorities(authority) values ('USER');

insert into user_authority(user_id, authority_id)
values (1, 1), (2, 1);