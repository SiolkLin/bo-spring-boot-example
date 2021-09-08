CREATE TABLE bo_example_company (
  id VARSTRING(36) ,
  company_name VARSTRING(255) ,
  KEY(id)
)

CREATE TABLE bo_example_user (
  id VARSTRING(36) ,
  username VARSTRING(255),
  company_id VARSTRING(36) ,
  KEY(id)
  
) 


insert into bo_example_company values
('C01','BigObject'),
('C02','Oracle'),
('C03','Microsoft')



insert into bo_example_user values
('U01','Domo','C01'),
('U02','Kutar','C01'),
('U03','Creeper','C02')

