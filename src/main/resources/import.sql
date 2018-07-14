-- the password hash is generated by BCrypt Calculator Generator(https://www.dailycred.com/article/bcrypt-calculator)
INSERT INTO USERS (id, username, password, first_name, last_name, email, phone_number, enabled, last_password_reset_date,company_id) VALUES (1, 'user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Fan', 'Jin', 'user@example.com', '+1234567890', true, '2017-10-01 21:58:58.508-07','');
INSERT INTO USERS (id, username, password, first_name, last_name, email, phone_number, enabled, last_password_reset_date) VALUES (2, 'admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Jing', 'Xiao', 'admin@example.com', '+0987654321', true, '2017-10-01 18:57:58.508-07');

INSERT INTO AUTHORITY (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (id, name) VALUES (2, 'ROLE_ADMIN');
INSERT INTO AUTHORITY (id, name) VALUES (3, 'ROLE_EMP');
INSERT INTO AUTHORITY (id, name) VALUES (4, 'ROLE_HR');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 3);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 4);

DELETE FROM State;
INSERT INTO State(id,state_name,created_at,updated_at) VALUES (1,'AB-Alberta',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO State(id,state_name,created_at,updated_at) VALUES (2,'BC-British Columbia',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO State(id,state_name,created_at,updated_at) VALUES (3,'MB-Manitoba',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO State(id,state_name,created_at,updated_at) VALUES (4,'NB-New Brunswick',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO State(id,state_name,created_at,updated_at) VALUES (5,'NF-Newfoundland',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO State(id,state_name,created_at,updated_at) VALUES (6,'NT-Northwest Territories',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO State(id,state_name,created_at,updated_at) VALUES (7,'NS-Nova Scotia',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO State(id,state_name,created_at,updated_at) VALUES (8,'NU-Nunavut',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO State(id,state_name,created_at,updated_at) VALUES (9,'ON-Ontario',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO State(id,state_name,created_at,updated_at) VALUES (10,'PE-Prince Edward Island',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO State(id,state_name,created_at,updated_at) VALUES (11,'QC-Québec',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO State(id,state_name,created_at,updated_at) VALUES (12,'SK-Saskatchewan',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO State(id,state_name,created_at,updated_at) VALUES (13,'YK-Yukon',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


DELETE FROM Industry;
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (1,'Communications',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (2,'Retail trade',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (3,'Automotive',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (4,'DSS',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (5,'Energy',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (6,'Office',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (7,'Manufacturing',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (8,'Construction',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (9,'Wholesale trade',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (10,'Transportation',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (11,'Finance,Accounting and Insurance',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (12,'Real estate and rental and leasing',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (13,'Professional,scientific and technical services',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (14,'Professional,business and legal',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (15,'Management of companies and enterprises',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (16,'Administrative, Customer Service and support, and remediation services',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (17,'Waste management',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (18,'Educational services',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (19,'Health care and social assistance',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (20,'Arts, entertainment and recreation',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Industry(id,industry_name,created_at,updated_at) VALUES (21,'Accommodation and food services',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


DELETE FROM Additional_Requirements;
INSERT INTO Additional_Requirements(id,Additional_Requirements_name,created_at,updated_at) VALUES (1,'Medical Safety',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Additional_Requirements(id,Additional_Requirements_name,created_at,updated_at) VALUES (2,'Transport',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

DELETE FROM Performance_Review;
INSERT INTO Performance_Review(id,performance_review_name,created_at,updated_at) VALUES (1,'Annual',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Performance_Review(id,performance_review_name,created_at,updated_at) VALUES (2,'Bi-Annual',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Performance_Review(id,performance_review_name,created_at,updated_at) VALUES (3,'None',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


DELETE FROM Benefits;
INSERT INTO Benefits(id,Benefits_name,created_at,updated_at) VALUES (1,'None',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Benefits(id,Benefits_name,created_at,updated_at) VALUES (2,'3 months',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Benefits(id,Benefits_name,created_at,updated_at) VALUES (3,'6 months',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Benefits(id,Benefits_name,created_at,updated_at) VALUES (4,'1 year',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


DELETE FROM Assign_To;
INSERT INTO Assign_To(id,Assign_To_name,created_at,updated_at) VALUES (1,'Domenic Richichi',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO Assign_To(id,Assign_To_name,created_at,updated_at) VALUES (2,'Natalie Hansford',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);



DELETE FROM call_topic;
INSERT INTO call_topic(id,call_topic_name,created_at,updated_at) VALUES (1,'Benefits',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO call_topic(id,call_topic_name,created_at,updated_at) VALUES (2,'Discipline',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO call_topic(id,call_topic_name,created_at,updated_at) VALUES (3,'Health and Safety',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO call_topic(id,call_topic_name,created_at,updated_at) VALUES (4,'Leave of Absence',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO call_topic(id,call_topic_name,created_at,updated_at) VALUES (5,'Ministry of Labour',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO call_topic(id,call_topic_name,created_at,updated_at) VALUES (6,'New Hire',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO call_topic(id,call_topic_name,created_at,updated_at) VALUES (7,'Other',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO call_topic(id,call_topic_name,created_at,updated_at) VALUES (8,'Policies',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO call_topic(id,call_topic_name,created_at,updated_at) VALUES (9,'Sick Leave',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO call_topic(id,call_topic_name,created_at,updated_at) VALUES (10,'Termination',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO call_topic(id,call_topic_name,created_at,updated_at) VALUES (11,'Training',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


