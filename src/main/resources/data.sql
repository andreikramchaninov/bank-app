/*insert into customer (fullname, address, age) values
('David Abbott', '733 Oxford Road Libertyville, IL 60048', 34),
('Graham Anderson', '888 Argyle Ave. Libertyville, IL 60048', 45),
('Christina Arrowsmith', '12 South Longbranch Ave. Libertyville, IL 60048', 23),
('Ozan Aydin', '14 Clay St. Libertyville, IL 60048', 45),
('Arun Banerjee', '8663 County St. Libertyville, IL 60048', 67),
('Anthony Barnard', '770 Pierce Court Libertyville, IL 60048', 65),
('Jermaine Barrett', '96 Proctor St. Libertyville, IL 60048', 43),
('Jason Berry', '96 East Lakeshore Rd. Libertyville, IL 60048', 18),
('Pauline Brand', '79 Jones Street Libertyville, IL 60048', 45),
('Michelle Burley', '81 Fieldstone Rd. Libertyville, IL 60048', 43),
('Sheila Chopra', '693 N. Lakeview Ave. Libertyville, IL 60048', 32),
('James Connolly', '78 Smoky Hollow Court Libertyville, IL 60048', 44),
('Ryan Davis', '944 Studebaker Street Libertyville, IL 60048', 33),
('John Day', '7867 Atlantic Street Libertyville, IL 60048', 54),
('Frederick Duckworth', '9595 Deerfield Dr. Libertyville, IL 60048', 65),
('Lee Figg', '19 Lexington Court Libertyville, IL 60048', 89),
('Patrick Gadsby', '67 Lake View Ave. Libertyville, IL 60048', 57),
('Christine Gilbert', '58 South Willow Lane Libertyville, IL 60048', 51),
('Rebecca Goldberg', '8396 Pearl Road Libertyville, IL 60048', 23),
('Andrew Golding', '3 Henry Smith Street Libertyville, IL 60048', 42),
('Wayne Golding', '96 East Ridge Lane Libertyville, IL 60048', 31),
('Rudolph Grant', '8695 Plymouth St. Libertyville, IL 60048', 33),
('Keith Gratton', '9448 San Juan Court Libertyville, IL 60048', 30),
('Neil Hammond', '120 Shady Ave. Libertyville, IL 60048', 21),
('Jahanara Haque', '3 Fieldstone St. Libertyville, IL 60048', 23),
('Mohammed Hasan', '90 Hillside Lane Libertyville, IL 60048', 24),
('Matthew Jefferys', '11 Addison Lane Libertyville, IL 60048', 45),
('Carol John', '8081 Cambridge St. Libertyville, IL 60048', 47),
('Heidi Jones', '293 Silver Spear Ave. Libertyville, IL 60048', 53),
('Phil Kirwin', '23 N. Cactus Ave. Libertyville, IL 60048', 42),
('Jacqueline MacKay', '9399 Bow Ridge Street Libertyville, IL 60048', 23),
('Dean McDonald', '8034 Bay Lane Libertyville, IL 60048', 43),
('Emma Mumford', '7118 Sutor St. Libertyville, IL 60048', 55),
('Stanley Perkins', '9063 Valley Street Libertyville, IL 60048', 46),
('Alexander Queenan', '43 Courtland Dr. Libertyville, IL 60048', 45),
('Yasmin Rehman', '8072 Alderwood Road Libertyville, IL 60048', 19),
('David Ringer', '9271 Del Monte Avenue Libertyville, IL 60048', 32),
('David Smith', '8991 Overlook St. Libertyville, IL 60048', 43),
('Lionel Smith', '405 Race Ave. Libertyville, IL 60048', 23),
('Ritesh Srivastava', '33 North Columbia Road Libertyville, IL 60048', 23),
('Neil Stevenson', '694 E. Newport Ave. Libertyville, IL 60048', 43),
('Deborah Taylor', '471 Berkshire Ave. Libertyville, IL 60048', 23),
('Scott Taylor', '197 N. Colonial St. Libertyville, IL 60048', 34),
('Michelle Taylor', '95 Southampton Dr. Libertyville, IL 60048', 55),
('Stephanie Taylor', '8095 North Ashley Dr. Libertyville, IL 60048', 34),
('Togy Thomas', '753 Bay Dr. North Canton, Libertyville, IL 60048', 43),
('Hayden Todd', '760 Trout Lane Libertyville, IL 60048', 34),
('Carole-Anne Turner', '9502 SE. Columbia Street Libertyville, IL 60048', 23),
('Clive Wightman', '179 Creek Dr. Libertyville, IL 60048', 23),
('Lee Wright', '719 West Devonshire Ave. Libertyville, IL 60048', 43);

insert into bank_account (customer_id, money) values
(1, 234234.34), (1, 237737.53), (2, 776.55), (2, 4454.57), (3, 2334.55),
(3, 2342346.34), (4, 465757.95), (5, 964785.55), (6, 6546.56), (7, 22.34),
(8, 4367.76), (8, 0658.56), (8, 565.89), (9, 87579.55), (10, 0.55), (11, 4675.46),
(11, 88665.76), (11, 4566.86), (12, 5836.54), (12, 689.65), (13, 5654.98), (14, 5675.75),
(15, 454.55), (15, 34557.55), (16, 3234.12), (16, 12743.54), (17, 7995.66), (18, 9976.64),
(18, 46468.65), (19, 56588.57), (19, 7655.57), (20, 7754.88), (21, 8654.64), (22, 854.00),
(23, 4562.64), (23, 668.44), (24, 6543.99), (25, 5789.74), (26, 844.54), (26, 5455.86),
(27, 633.43), (28, 5212.54),(29, 47.44), (29, 4688.43), (30, 46689.44), (31, 899.55),
(31, 578.43), (31, 4778.34), (32, 5653.56), (33, 363.33), (33, 377.75), (33, 7433.77),
(33, 3736.64), (34, 656.65), (35, 653.56), (35, 845.74), (36, 9999999.99), (37, 676765.67),
(38, 6777.77), (39, 25252.34), (40, 363277.44), (41, 467983.44), (41, 45.45), (41, 8008.88),
(42, 22473.55), (42, 567.44), (43, 44.76), (43, 557.55), (44, 6589.56), (45, 567.565),
(45, 5588.53), (46, 755.56), (46, 89.65), (46, 559.54), (47, 67.56), (48, 579.67), (49, 679.54),
(50, 679.65), (50, 66.44);*/

/*insert into bank_operation (account_id, money) values*/
