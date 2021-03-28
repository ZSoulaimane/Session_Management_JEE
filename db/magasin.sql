CREATE TABLE commande (
 num tinyint(4) NOT NULL auto_increment,
 article varchar(20) NOT NULL default '',
 qui tinyint(4) NOT NULL default '0',
 PRIMARY KEY (num)
);

CREATE TABLE personnel (
 numero tinyint(4) NOT NULL auto_increment,
 nom varchar(20) NOT NULL default '',
 PRIMARY KEY (numero)
);