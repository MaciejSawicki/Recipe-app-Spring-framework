CREATE DATABASE sfg_dev;
CREATE DATABASE sfg_prod;

CREATE USER 'sfg_dev_user'@'localhost' IDENTIFIED BY 'dab';
CREATE USER 'sfg_prod_user'@'localhost' IDENTIFIED BY 'dab';

GRANT SELECT ON sfg_dev.* to 'sfg_dev_user'@'localhost';
GRANT INSERT ON sfg_dev.* to 'sfg_dev_user'@'localhost';
GRANT UPDATE ON sfg_dev.* to 'sfg_dev_user'@'localhost';
GRANT DELETE ON sfg_dev.* to 'sfg_dev_user'@'localhost';
GRANT SELECT ON sfg_dev.* to 'sfg_prod_user'@'localhost';
GRANT INSERT ON sfg_dev.* to 'sfg_prod_user'@'localhost';
GRANT UPDATE ON sfg_dev.* to 'sfg_prod_user'@'localhost';
GRANT DELETE ON sfg_dev.* to 'sfg_prod_user'@'localhost';