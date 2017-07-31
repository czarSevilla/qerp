insert into sec_roles(description_es_mx, description_en_us) values('Administrador General', 'Root Administrator'),
('Administrador de Empresa', 'Company Administrator'), ('Responsable de Recursos Humanos', 'Human Resource Manager'),
('Usuario de Recursos Humanos', 'Human Resource User');

insert into sec_modules(description_es_mx, description_en_us)
values('Seguridad', 'Security'), ('Administración de Catálogos', 'Catalogues Administration');

insert into sec_permissions(id_sec_permission, id_sec_module, description_es_mx, description_en_us, order_num)
values('ROLE_R_JOB_TTL', 2, 'Consultar Catálogo de Puestos', 'List Job Titles Catalogue', 1),
('ROLE_C_JOB_TTL', 2, 'Insertar en Catálogo de Puestos', 'Insert into Job Titles Catalogue', 2),
('ROLE_U_JOB_TTL', 2, 'Modificar en Catálogo de Puestos', 'Update on Job Titles Catalogue', 3),
('ROLE_D_JOB_TTL', 2, 'Eliminar en Catálogo de Puestos', 'Delete on Job Titles Catalogue', 4),
('ROLE_R_CURRENCY', 2, 'Consultar Catálogo de Monedas', 'List Currencies Catalogue', 5),
('ROLE_C_CURRENCY', 2, 'Insertar en Catálogo de Monedas', 'Insert into Currencies Catalogue', 6),
('ROLE_U_CURRENCY', 2, 'Modificar en Catálogo de Monedas', 'Update on Currencies Catalogue', 7),
('ROLE_D_CURRENCY', 2, 'Eliminar en Catálogo de Monedas', 'Delete on Currencies Catalogue', 8);
