insert into tb_users (id, username, password, role) values (100, 'ana@email.com', '$2a$12$VQSVztr/M8tcwzcy9jJgFebpqybKpF4FVwM3zilhOAI4yL1iW3rJa', 'ROLE_ADMIN');
insert into tb_users (id, username, password, role) values (101, 'bia@email.com', '$2a$12$VQSVztr/M8tcwzcy9jJgFebpqybKpF4FVwM3zilhOAI4yL1iW3rJa', 'ROLE_CLIENT');
insert into tb_users (id, username, password, role) values (102, 'bob@email.com', '$2a$12$VQSVztr/M8tcwzcy9jJgFebpqybKpF4FVwM3zilhOAI4yL1iW3rJa', 'ROLE_CLIENT');

insert into tb_parking_spot (id, code, status) values (10, 'A-01', 'AVAILABLE');
insert into tb_parking_spot (id, code, status) values (20, 'A-02', 'AVAILABLE');
insert into tb_parking_spot (id, code, status) values (30, 'A-03', 'OCCUPIED');
insert into tb_parking_spot (id, code, status) values (40, 'A-04', 'AVAILABLE');
